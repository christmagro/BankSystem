package com.chris.bank.exceptionhandling;

import com.chris.bank.dto.ApiError;
import com.chris.bank.exceptionhandling.GlobalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Christian Magro on 14/05/2017.
 */
@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ApiError> handleCustomException(GlobalException ex) {
        ApiError apiError = new ApiError(ex.getMessage(), ex.getStatus().name());
                return new ResponseEntity<>(apiError, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception ex) {
        ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.BAD_REQUEST.name());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
