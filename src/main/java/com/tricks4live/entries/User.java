package com.tricks4live.entries;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.annotation.Authority;
import com.tricks4live.utils.Constants;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 用户信息，MySQL存储
 */
@JsonSerialize
public class User implements Serializable {
    private Long id;

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

    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date registerDate;

    private Boolean active = true;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(registerDate, user.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, registerDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", token='" + token + '\'' +
                ", avatar='" + avatar + "\'" +
                ", permission=" + permission +
                ", registerDate=" + registerDate +
                ", active=" + active +
                '}';
    }
}
