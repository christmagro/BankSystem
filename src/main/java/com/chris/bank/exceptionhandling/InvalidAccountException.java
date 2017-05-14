package com.chris.bank.exceptionhandling;

import org.springframework.http.HttpStatus;

/**
 * Created by Christian Magro on 14/05/2017.
 */
public class InvalidAccountException extends GlobalException {
    public InvalidAccountException(String message, Long accountNumber) {
        super("Invalid " + message + " account provided with account number " + accountNumber, HttpStatus.BAD_REQUEST);
    }

    public InvalidAccountException(Long accountNumber) {
        super("Invalid account number " + accountNumber, HttpStatus.BAD_REQUEST);
    }
}
