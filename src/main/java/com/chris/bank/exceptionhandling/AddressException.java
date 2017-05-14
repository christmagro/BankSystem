package com.chris.bank.exceptionhandling;

import org.springframework.http.HttpStatus;

/**
 * Created by Christian Magro on 14/05/2017.
 */
public class AddressException extends GlobalException {
    public AddressException() {
        super("Only one Primary address is allowed", HttpStatus.BAD_REQUEST);
    }
}
