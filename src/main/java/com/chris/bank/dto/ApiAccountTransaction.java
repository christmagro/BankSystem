package com.chris.bank.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by Christian Magro on 14/05/2017.
 */
@Data
@EqualsAndHashCode
public class ApiAccountTransaction {

    private List<ApiTransaction> debitTransactions;
    private List<ApiTransaction> creditTransactions;
}
