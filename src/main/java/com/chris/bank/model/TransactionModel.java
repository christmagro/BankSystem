package com.chris.bank.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Entity
@Table(name = "transaction")
public class TransactionModel {
    private long transactionId;
    private String transactionDirection;
    private double transactionAmount;
    private String transactionMessage;
    private Timestamp transactionCreated;
    private Set<AccountModel> accounts = new HashSet<>();

    @Id
    @Column(name = "transaction_id", nullable = false)
    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "transaction_direction", nullable = false, length = 2)
    public String getTransactionDirection() {
        return transactionDirection;
    }

    public void setTransactionDirection(String transactionDirection) {
        this.transactionDirection = transactionDirection;
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
        if (transactionDirection != null ? !transactionDirection.equals(that.transactionDirection) : that.transactionDirection != null)
            return false;
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
        result = 31 * result + (transactionDirection != null ? transactionDirection.hashCode() : 0);
        temp = Double.doubleToLongBits(transactionAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (transactionMessage != null ? transactionMessage.hashCode() : 0);
        result = 31 * result + (transactionCreated != null ? transactionCreated.hashCode() : 0);
        return result;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "transactions")
    public Set<AccountModel> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Set<AccountModel> accounts) {
        this.accounts = accounts;
    }
}
