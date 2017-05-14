package com.chris.bank.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Entity
@Table(name = "account")
public class AccountModel {
    private long accountId;
    private String accountType;
    private double accountBalance;
    private String accountBalanceStatus;
    private Timestamp accountTimestamp;
    private double accountOverdraftLimit;
    private long accountNumber;
    private Set<TransactionModel> accountDebitTransactions = new HashSet<>();
    private Set<TransactionModel> accountCreditTransactions = new HashSet<>();
    private ClientModel client;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "account_type", nullable = false, length = 10)
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "account_balance", nullable = false, precision = 0)
    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Basic
    @Column(name = "account_balance_status", nullable = false, length = 2)
    public String getAccountBalanceStatus() {
        return accountBalanceStatus;
    }

    public void setAccountBalanceStatus(String accountBalanceStatus) {
        this.accountBalanceStatus = accountBalanceStatus;
    }

    @Basic
    @Column(name = "account_timestamp", nullable = false)
    public Timestamp getAccountTimestamp() {
        return accountTimestamp;
    }

    public void setAccountTimestamp(Timestamp accountTimestamp) {
        this.accountTimestamp = accountTimestamp;
    }

    @Basic
    @Column(name = "account_overdraft_limit", nullable = false, precision = 0)
    public double getAccountOverdraftLimit() {
        return accountOverdraftLimit;
    }

    public void setAccountOverdraftLimit(double accountOverdraftLimit) {
        this.accountOverdraftLimit = accountOverdraftLimit;
    }

    @Basic
    @Column(name = "account_number", nullable = false)
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountModel that = (AccountModel) o;

        if (accountId != that.accountId) return false;
        if (Double.compare(that.accountBalance, accountBalance) != 0) return false;
        if (Double.compare(that.accountOverdraftLimit, accountOverdraftLimit) != 0) return false;
        if (accountNumber != that.accountNumber) return false;
        if (accountType != null ? !accountType.equals(that.accountType) : that.accountType != null) return false;
        if (accountBalanceStatus != null ? !accountBalanceStatus.equals(that.accountBalanceStatus) : that.accountBalanceStatus != null)
            return false;
        if (accountTimestamp != null ? !accountTimestamp.equals(that.accountTimestamp) : that.accountTimestamp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (accountId ^ (accountId >>> 32));
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        temp = Double.doubleToLongBits(accountBalance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (accountBalanceStatus != null ? accountBalanceStatus.hashCode() : 0);
        result = 31 * result + (accountTimestamp != null ? accountTimestamp.hashCode() : 0);
        temp = Double.doubleToLongBits(accountOverdraftLimit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (accountNumber ^ (accountNumber >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "transactionDebitAccount")
    public Set<TransactionModel> getAccountDebitTransactions() {
        return accountDebitTransactions;
    }

    public void setAccountDebitTransactions(Set<TransactionModel> accountDebitTransactions) {
        this.accountDebitTransactions = accountDebitTransactions;
    }

    @OneToMany(mappedBy = "transactionDebitAccount")
    public Set<TransactionModel> getAccountCreditTransactions() {
        return accountCreditTransactions;
    }

    public void setAccountCreditTransactions(Set<TransactionModel> accountCreditTransactions) {
        this.accountCreditTransactions = accountCreditTransactions;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }
}
