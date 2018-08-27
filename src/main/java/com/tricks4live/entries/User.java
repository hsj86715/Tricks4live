package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.annotation.Authority;

import java.io.Serializable;

/**
 * 用户信息，MySQL存储
 */
@JsonSerialize
public class User extends BaseDBEntry implements Serializable {
    private String userName;

    private String nickName;

    private String password;

    private String email;

    private String phone;

    private String address;

    private String token;

    private String avatar;

    @Authority
    private Integer permission = Authority.NONE;

    private Boolean canceled = false;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public void addPermission(@Authority Integer permission) {
        this.permission = this.permission | permission;
    }

    public void removePermission(@Authority Integer permission) {
        this.permission = this.permission & (~permission);
    }

    public boolean hasPermission(@Authority Integer permission) {
        return (this.permission & permission) != 0;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    @Override
    public String toString() {
        return "User{" + super.toString() +
                "userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", token='" + token + '\'' +
                ", avatar='" + avatar + '\'' +
                ", permission=" + permission +
                ", canceled=" + canceled +
                '}';
    }
}
