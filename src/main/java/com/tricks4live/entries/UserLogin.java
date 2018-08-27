package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 用户登录信息，MySQL存储
 */
@JsonSerialize
public class UserLogin extends BaseDBEntry{
    private Long uid;

    private String loginIp;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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
                "uid=" + uid +
                ", loginIp='" + loginIp + '\'' +
                '}';
    }
}
