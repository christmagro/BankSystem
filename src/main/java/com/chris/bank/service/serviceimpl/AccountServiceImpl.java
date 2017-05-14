package com.chris.bank.service.serviceimpl;

import com.chris.bank.dto.*;
import com.chris.bank.exceptionhandling.InsufficientFunds;
import com.chris.bank.exceptionhandling.InvalidAccountException;
import com.chris.bank.exceptionhandling.InvalidClientId;
import com.chris.bank.model.AccountModel;
import com.chris.bank.model.ClientModel;
import com.chris.bank.model.TransactionModel;
import com.chris.bank.service.AbstractService;
import com.chris.bank.service.AccountService;
import com.chris.bank.utils.BalanceDirection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Service
public class AccountServiceImpl extends AbstractService implements AccountService {


    @Value("${accountnumber.start}")
    private long accountNumberStart;

    private long issueNewAccountNumber() {
        return (accountNumberStart + accountRepository.count() + 1);
    }


    @Override
    @Transactional
    public ApiAccount createAccount(ApiAccount apiAccount, String clientId) {

        ClientModel client = clientRepository.findOne(encryptionService.decrypt(clientId));
        if (client == null) {
            throw new InvalidClientId();
        }
        AccountModel account = modelMapper.map(apiAccount, AccountModel.class);
        account.setClient(client);
        account.setAccountTimestamp(java.sql.Timestamp.valueOf(LocalDateTime.now()));
        account.setAccountNumber(issueNewAccountNumber());
        return modelMapper.map(accountRepository.save(account), ApiAccount.class);

    }

    @Override
    @Transactional
    public synchronized ApiAccountTransferResponse createTransfer(ApiAccountTransferRequest apiAccountTransferRequest) {

        AccountModel sourceAccount = accountRepository.findByAccountNumber(apiAccountTransferRequest.getSourceAccount());
        AccountModel destinationAccount = accountRepository.findByAccountNumber(apiAccountTransferRequest.getDestinationAccount());

        if (sourceAccount == null) {
            throw new InvalidAccountException("source", apiAccountTransferRequest.getSourceAccount());
        }
        if (destinationAccount == null) {
            throw new InvalidAccountException("destination", apiAccountTransferRequest.getDestinationAccount());
        }

        return initializeTransfer(sourceAccount, destinationAccount, apiAccountTransferRequest.getAmount());
    }

    @Override
    public List<ApiAccount> listClientAccounts(String clientId) {

        ClientModel client = clientRepository.findOne(encryptionService.decrypt(clientId));
        if (client == null) {
            throw new InvalidClientId();
        }
        return modelMapper.mapAsList(accountRepository.findByClient(client), ApiAccount.class);

    }

    @Override
    public ApiAccountTransaction listAccountTransactions(Long accountNumber) {
        AccountModel account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new InvalidAccountException(accountNumber);
        }
        ApiAccountTransaction apiAccountTransaction = new ApiAccountTransaction();
        apiAccountTransaction.setDebitTransactions(modelMapper.mapAsList(transactionRepository.findByTransactionDebitAccount(account), ApiTransaction.class));
        apiAccountTransaction.setCreditTransactions(modelMapper.mapAsList(transactionRepository.findByTransactionCreditAccount(account), ApiTransaction.class));
        return apiAccountTransaction;
    }

    private synchronized ApiAccountTransferResponse initializeTransfer(AccountModel sourceAccount, AccountModel destinationAccount, Double amount) {

        ApiAccount apiAccountDestinationAccount;

        if (sourceAccount.getAccountBalanceStatus().equals(BalanceDirection.CR.name())) {
            if (sourceAccount.getAccountOverdraftLimit() - sourceAccount.getAccountBalance() < amount) {
                throw new InsufficientFunds(sourceAccount.getAccountNumber());
            } else {
                sourceAccount.setAccountBalance(amount + sourceAccount.getAccountBalance());
                apiAccountDestinationAccount = modelMapper.map(updateDestinationAccountBalance(destinationAccount, amount), ApiAccount.class);
                createTransaction(sourceAccount, destinationAccount, amount);
            }

        } else {
            if (sourceAccount.getAccountBalance() < amount) {
                if (sourceAccount.getAccountBalance() + sourceAccount.getAccountOverdraftLimit() < amount) {
                    throw new InsufficientFunds(sourceAccount.getAccountNumber());
                } else {
                    sourceAccount.setAccountBalance(amount - sourceAccount.getAccountBalance());
                    sourceAccount.setAccountBalanceStatus(BalanceDirection.CR.name());
                    apiAccountDestinationAccount = modelMapper.map(updateDestinationAccountBalance(destinationAccount, amount), ApiAccount.class);

                }
            } else {
                sourceAccount.setAccountBalance(sourceAccount.getAccountBalance() - amount);
                apiAccountDestinationAccount = modelMapper.map(updateDestinationAccountBalance(destinationAccount, amount), ApiAccount.class);
                createTransaction(sourceAccount, destinationAccount, amount);
            }

        }
        return new ApiAccountTransferResponse(modelMapper.map(accountRepository.save(sourceAccount), ApiAccount.class), apiAccountDestinationAccount);

    }


    private synchronized AccountModel updateDestinationAccountBalance(AccountModel destinationAccount, double amount) {
        if (destinationAccount.getAccountBalanceStatus().equals(BalanceDirection.CR.name())) {
            if (destinationAccount.getAccountBalance() <= amount) {
                destinationAccount.setAccountBalanceStatus(BalanceDirection.DR.name());
                destinationAccount.setAccountBalance(amount - destinationAccount.getAccountBalance());
            } else {
                destinationAccount.setAccountBalance(destinationAccount.getAccountBalance() - amount);
            }
        } else {
            destinationAccount.setAccountBalance(destinationAccount.getAccountBalance() + amount);
        }
        return accountRepository.save(destinationAccount);
    }

    private void createTransaction(AccountModel sourceAccount, AccountModel destinationAccount, Double amount) {
        TransactionModel transaction = new TransactionModel();
        transaction.setTransactionAmount(amount);
        transaction.setTransactionCreditAccount(sourceAccount);
        transaction.setTransactionDebitAccount(destinationAccount);
        transaction.setTransactionMessage("A2A Transfer");
        transaction.setTransactionCreated(java.sql.Timestamp.valueOf(LocalDateTime.now()));
        transactionRepository.save(transaction);
    }


}
