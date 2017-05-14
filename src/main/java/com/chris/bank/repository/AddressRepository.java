package com.chris.bank.repository;

import com.chris.bank.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@RepositoryRestResource(exported = false)
public interface AddressRepository extends JpaRepository<AddressModel, Long> {
}
