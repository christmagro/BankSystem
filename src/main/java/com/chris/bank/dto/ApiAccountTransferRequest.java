package com.chris.bank.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * Created by Christian Magro on 14/05/2017.
 */
@Data
@EqualsAndHashCode
public class ApiAccountTransferRequest {
    @NotNull
    private long sourceAccount;
    @NotNull
    private long destinationAccount;
    @NotNull
    private double amount;
}
