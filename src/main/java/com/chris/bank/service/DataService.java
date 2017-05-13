package com.chris.bank.service;

import com.chris.bank.repository.UserAccountRepository;
import com.chris.bank.security.BankUser;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Christian Magro on 13/05/2017.
 */
public interface DataService {

    BankUser retrieveUsername(String username);

}
