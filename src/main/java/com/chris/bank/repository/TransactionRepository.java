package com.chris.bank.repository;

import com.chris.bank.model.AccountModel;
import com.chris.bank.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Christian Magro on 13/05/2017.
 */
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {

    List<TransactionModel> findByTransactionDebitAccount(AccountModel account);
    List<TransactionModel> findByTransactionCreditAccount(AccountModel account);
}
