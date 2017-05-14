package com.chris.bank.controller;

import com.chris.bank.dto.ApiAccount;
import com.chris.bank.dto.ApiAccountTransaction;
import com.chris.bank.dto.ApiAccountTransferRequest;
import com.chris.bank.dto.ApiAccountTransferResponse;
import com.chris.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Christian Magro on 14/05/2017.
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * An Api that creates and account for a specific client
     * @param apiAccount A complex object containing all the required account information
     * @param clientId An encoded ID representing a unique client in the system
     * @return
     */
    @RequestMapping(value = "/{clientId}", method = RequestMethod.POST)
    public ApiAccount createAccount(@RequestBody ApiAccount apiAccount,
                                    @PathVariable String clientId) {

        return accountService.createAccount(apiAccount, clientId);
    }

    /**
     * An Api used to complete and Account to Account Transfer
     * @param apiAccountTransferRequest A complex object containing the required information to complete transfer
     * @return A complex object containing a summary of the accounts after transfer
     */
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public ApiAccountTransferResponse createTransfer(@RequestBody ApiAccountTransferRequest apiAccountTransferRequest) {

        return accountService.createTransfer(apiAccountTransferRequest);
    }

    /**
     * An Api that returns a list of account for a particular client
     * @param clientId An encoded ID representing a unique client in the system
     * @return A list of complex object containing all the account details
     */
    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
    public List<ApiAccount> getClientAccounts(@PathVariable String clientId) {

        return accountService.listClientAccounts(clientId);
    }

    /**
     * An Api that returns a list of transactions for a specific Account
     * @param accountNumber A specific account number found on the system
     * @return A complex object that contains all the transactions the occurred in the system for the specific account (Contains both credit and debit transactions)
     */
    @RequestMapping(value = "/transactions/{accountNumber}", method = RequestMethod.GET)
    public ApiAccountTransaction getAccountTransactions(@PathVariable Long accountNumber) {

        return accountService.listAccountTransactions(accountNumber);
    }

}
