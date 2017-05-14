package com.chris.bank.repository;

import com.chris.bank.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Christian Magro on 13/05/2017.
 */
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}
