package com.chris.bank.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Entity
@Table(name = "client")
public class ClientModel {
    private long clientId;
    private String clientName;
    private String clientSurname;
    private Date clientDob;
    private Set<AccountModel> accounts = new HashSet<>();
    private Set<AddressModel> addresses = new HashSet<>();

    @Id
    @Column(name = "client_id", nullable = false)
    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "client_name", nullable = false, length = 45)
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Basic
    @Column(name = "client_surname", nullable = false, length = 45)
    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    @Basic
    @Column(name = "client_dob", nullable = false)
    public Date getClientDob() {
        return clientDob;
    }

    public void setClientDob(Date clientDob) {
        this.clientDob = clientDob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientModel that = (ClientModel) o;

        if (clientId != that.clientId) return false;
        if (clientName != null ? !clientName.equals(that.clientName) : that.clientName != null) return false;
        if (clientSurname != null ? !clientSurname.equals(that.clientSurname) : that.clientSurname != null)
            return false;
        if (clientDob != null ? !clientDob.equals(that.clientDob) : that.clientDob != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (clientId ^ (clientId >>> 32));
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientSurname != null ? clientSurname.hashCode() : 0);
        result = 31 * result + (clientDob != null ? clientDob.hashCode() : 0);
        return result;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "client_account", joinColumns = {
            @JoinColumn(name = "client_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "account_id",
                    nullable = false, updatable = false)})
    public Set<AccountModel> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Set<AccountModel> accounts) {
        this.accounts = accounts;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "client_address", joinColumns = {
            @JoinColumn(name = "client_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "address_id",
                    nullable = false, updatable = false)})
    public Set<AddressModel> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(Set<AddressModel> addresses) {
        this.addresses = addresses;
    }
}
