package com.chris.bank.exceptionhandling;

import org.springframework.http.HttpStatus;

/**
 * Created by Christian Magro on 14/05/2017.
 */
public class InvalidClientId extends GlobalException {


    public InvalidClientId() {
        super("Provided client was not found", HttpStatus.NOT_FOUND);
    }
}
