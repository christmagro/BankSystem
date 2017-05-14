package com.chris.bank.model;

import javax.persistence.*;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Entity
@Table(name = "user_account")
public class UserAccountModel {
    private long userId;
    private String userUsername;
    private String userPassword;
    private boolean userEnable;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_username", nullable = false, length = 45)
    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 200)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_enable", nullable = false)
    public boolean isUserEnable() {
        return userEnable;
    }

    public void setUserEnable(boolean userEnable) {
        this.userEnable = userEnable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccountModel that = (UserAccountModel) o;

        if (userId != that.userId) return false;
        if (userEnable != that.userEnable) return false;
        if (userUsername != null ? !userUsername.equals(that.userUsername) : that.userUsername != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (userUsername != null ? userUsername.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userEnable ? 1 : 0);
        return result;
    }
}
