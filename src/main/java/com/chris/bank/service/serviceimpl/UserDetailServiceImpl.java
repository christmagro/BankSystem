package com.chris.bank.service.serviceimpl;

import com.chris.bank.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Service
@Qualifier("UserDetailService")
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private DataService dataService;


    public UserDetailsService userDetailsService() {
        return this;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return dataService.retrieveUsername(username);
    }
}
