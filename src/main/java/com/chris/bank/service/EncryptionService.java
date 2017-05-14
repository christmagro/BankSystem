package com.chris.bank.service;

/**
 * Created by Christian Magro on 14/05/2017.
 */
public interface EncryptionService {

    String encrypt(Long id);
    Long decrypt(String input);
}
