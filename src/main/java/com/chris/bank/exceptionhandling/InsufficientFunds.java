package com.chris.bank.exceptionhandling;

import org.springframework.http.HttpStatus;

/**
 * Created by Christian Magro on 14/05/2017.
 */
public class InsufficientFunds extends GlobalException {
    public InsufficientFunds(Long accountNumber) {
        super("Transfer cannot be completed due to insufficient funds in source account " + accountNumber, HttpStatus.FORBIDDEN);
    }
}
