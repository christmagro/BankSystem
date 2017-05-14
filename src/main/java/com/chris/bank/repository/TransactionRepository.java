package com.chris.bank.repository;

import com.chris.bank.model.AccountModel;
import com.chris.bank.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@RepositoryRestResource(exported = false)
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {

    List<TransactionModel> findByTransactionDebitAccount(AccountModel account);
    List<TransactionModel> findByTransactionCreditAccount(AccountModel account);
}
