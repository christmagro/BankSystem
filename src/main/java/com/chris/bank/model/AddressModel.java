package com.chris.bank.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Entity
@Table(name = "address")
public class AddressModel {
    private long addressId;
    private String addressLine1;
    private String addressLine2;
    private String addressCity;
    private String addressCounty;
    private boolean addressPrimary;
    private Set<ClientModel> clients = new HashSet<>(0);

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "address_line1", nullable = false, length = 200)
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Basic
    @Column(name = "address_line2", nullable = true, length = 200)
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Basic
    @Column(name = "address_city", nullable = false, length = 45)
    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    @Basic
    @Column(name = "address_county", nullable = false, length = 45)
    public String getAddressCounty() {
        return addressCounty;
    }

    public void setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty;
    }

    @Basic
    @Column(name = "address_primary", nullable = false)
    public boolean isAddressPrimary() {
        return addressPrimary;
    }

    public void setAddressPrimary(boolean addressPrimary) {
        this.addressPrimary = addressPrimary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressModel that = (AddressModel) o;

        if (addressId != that.addressId) return false;
        if (addressPrimary != that.addressPrimary) return false;
        if (addressLine1 != null ? !addressLine1.equals(that.addressLine1) : that.addressLine1 != null) return false;
        if (addressLine2 != null ? !addressLine2.equals(that.addressLine2) : that.addressLine2 != null) return false;
        if (addressCity != null ? !addressCity.equals(that.addressCity) : that.addressCity != null) return false;
        if (addressCounty != null ? !addressCounty.equals(that.addressCounty) : that.addressCounty != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (addressId ^ (addressId >>> 32));
        result = 31 * result + (addressLine1 != null ? addressLine1.hashCode() : 0);
        result = 31 * result + (addressLine2 != null ? addressLine2.hashCode() : 0);
        result = 31 * result + (addressCity != null ? addressCity.hashCode() : 0);
        result = 31 * result + (addressCounty != null ? addressCounty.hashCode() : 0);
        result = 31 * result + (addressPrimary ? 1 : 0);
        return result;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "addresses")
    public Set<ClientModel> getClients() {
        return this.clients;
    }

    public void setClients(Set<ClientModel> clients) {
        this.clients = clients;
    }
}
