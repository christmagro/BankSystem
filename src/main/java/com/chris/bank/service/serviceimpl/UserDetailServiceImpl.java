package com.chris.bank.service.serviceimpl;

import com.chris.bank.model.UserAccountModel;
import com.chris.bank.repository.UserAccountRepository;
import com.chris.bank.security.BankUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Service
@Qualifier("UserDetailService")
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private UserAccountRepository userAccountRepository;


    public UserDetailsService userDetailsService() {
        return this;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccountModel userAccountModel = userAccountRepository.findByUserUsername(username);
        if (userAccountModel != null) {
            List<String> roles = new ArrayList<>();
            roles.add("User");
            return new BankUser(userAccountModel.getUserUsername(), userAccountModel.getUserPassword(), userAccountModel.isUserEnable(), roles);
        } else {
            throw new UsernameNotFoundException("Username: '" + username + " is not valid'");
        }
    }
}
