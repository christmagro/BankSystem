package com.chris.bank.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Created by Christian Magro on 14/05/2017.
 */
@Data
@AllArgsConstructor
public class GlobalException extends RuntimeException{
    private String message;
    private HttpStatus status;


}
