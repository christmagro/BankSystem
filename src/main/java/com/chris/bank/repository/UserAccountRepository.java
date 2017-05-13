package com.chris.bank.repository;

import com.chris.bank.model.UserAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@RepositoryRestResource(exported = false)
public interface UserAccountRepository extends JpaRepository<UserAccountModel, Long>{
    UserAccountModel findByUserUsername(String username);
}
