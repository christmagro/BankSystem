package com.chris.bank.dto;

import com.chris.bank.model.AccountModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Data
@EqualsAndHashCode
public class ApiTransaction {
    private long transactionId;
    private double transactionAmount;
    private String transactionMessage;
    private Timestamp transactionCreated;
    private Long sourceAccountNumber;
    private Long destinationAccountNumber;
}
