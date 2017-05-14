package com.chris.bank.dto;

import com.chris.bank.utils.AccountType;
import com.chris.bank.utils.BalanceDirection;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Data
@EqualsAndHashCode
public class ApiAccount {
    private String accountId;
    @NotEmpty
    private AccountType accountType;
    private double accountBalance;
    @NotEmpty
    private BalanceDirection accountBalanceStatus;
    private String accountCreated;
    private double accountOverdraftLimit;
    private long accountNumber;
}
