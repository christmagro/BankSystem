package com.chris.bank.service;

import com.chris.bank.dto.mapper.CustomObjectMapper;
import com.chris.bank.repository.AccountRepository;
import com.chris.bank.repository.AddressRepository;
import com.chris.bank.repository.ClientRepository;
import com.chris.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Christian Magro on 14/05/2017.
 */
public abstract class AbstractService {
    @Autowired
    protected CustomObjectMapper modelMapper;

    @Autowired
    protected ClientRepository clientRepository;

    @Autowired
    protected AddressRepository addressRepository;

    @Autowired
    protected EncryptionService encryptionService;

    @Autowired
    protected AccountRepository accountRepository;

    @Autowired
    protected TransactionRepository transactionRepository;
}
