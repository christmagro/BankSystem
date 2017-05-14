package com.chris.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Christian Magro on 14/05/2017.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class ApiError {
    private String message;
    private String status;
}
