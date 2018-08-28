package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 用户登录信息，MySQL存储
 */
@JsonSerialize
public class UserLogin extends BaseDBEntry{
    private Long userId;

    private String loginIp;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Override
    public String toString() {
        return "UserLogin{" + super.toString() +
                ", userId=" + userId +
                ", loginIp='" + loginIp + '\'' +
                '}';
    }
}
