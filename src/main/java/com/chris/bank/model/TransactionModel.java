package com.chris.bank.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Entity
@Table(name = "transaction")
public class TransactionModel {
    private long transactionId;
    private double transactionAmount;
    private String transactionMessage;
    private Timestamp transactionCreated;
    private AccountModel transactionDebitAccount;
    private AccountModel transactionCreditAccount;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "transaction_amount", nullable = false, precision = 0)
    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Basic
    @Column(name = "transaction_message", nullable = true, length = 45)
    public String getTransactionMessage() {
        return transactionMessage;
    }

    public void setTransactionMessage(String transactionMessage) {
        this.transactionMessage = transactionMessage;
    }

    @Basic
    @Column(name = "transaction_created", nullable = false)
    public Timestamp getTransactionCreated() {
        return transactionCreated;
    }

    public void setTransactionCreated(Timestamp transactionCreated) {
        this.transactionCreated = transactionCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionModel that = (TransactionModel) o;

        if (transactionId != that.transactionId) return false;
        if (Double.compare(that.transactionAmount, transactionAmount) != 0) return false;
        if (transactionDebitAccount != that.transactionDebitAccount) return false;
        if (transactionCreditAccount != that.transactionCreditAccount) return false;
        if (transactionMessage != null ? !transactionMessage.equals(that.transactionMessage) : that.transactionMessage != null)
            return false;
        if (transactionCreated != null ? !transactionCreated.equals(that.transactionCreated) : that.transactionCreated != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (transactionId ^ (transactionId >>> 32));
        temp = Double.doubleToLongBits(transactionAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (transactionMessage != null ? transactionMessage.hashCode() : 0);
        result = 31 * result + (transactionCreated != null ? transactionCreated.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "transaction_debit_account", referencedColumnName = "account_id", nullable = false)
    public AccountModel getTransactionDebitAccount() {
        return transactionDebitAccount;
    }

    public void setTransactionDebitAccount(AccountModel transactionDebitAccount) {
        this.transactionDebitAccount = transactionDebitAccount;
    }

    @ManyToOne
    @JoinColumn(name = "transaction_credit_account", referencedColumnName = "account_id", nullable = false)
    public AccountModel getTransactionCreditAccount() {
        return transactionCreditAccount;
    }

    public void setTransactionCreditAccount(AccountModel transactionCreditAccount) {
        this.transactionCreditAccount = transactionCreditAccount;
    }
}


