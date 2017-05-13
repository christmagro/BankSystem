package com.chris.bank.service.serviceimpl;

import com.chris.bank.model.UserAccountModel;
import com.chris.bank.repository.UserAccountRepository;
import com.chris.bank.security.BankUser;
import com.chris.bank.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public BankUser retrieveUsername(String username) {
        UserAccountModel userAccountModel = userAccountRepository.findByUserUsername(username);
        if (userAccountModel != null) {
            List<String> roles = new ArrayList<>();
            roles.add("User");
            return new BankUser(userAccountModel.getUserUsername(), userAccountModel.getUserPassword(), userAccountModel.isUserEnable(), roles);
        } else {
            throw new UsernameNotFoundException("Username: '" + username + " is not valid'");
        }    }
}
