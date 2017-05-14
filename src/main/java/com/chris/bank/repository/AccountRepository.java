package com.chris.bank.repository;

import com.chris.bank.model.AccountModel;
import com.chris.bank.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@RepositoryRestResource(exported = false)
public interface AccountRepository extends JpaRepository<AccountModel, Long> {

    AccountModel findByAccountNumber(Long accountNumber);
    List<AccountModel> findByClient(ClientModel client);
}
