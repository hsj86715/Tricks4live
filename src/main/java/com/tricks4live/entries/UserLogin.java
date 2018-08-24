package com.tricks4live.entries;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.utils.Constants;

import java.util.Date;

/**
 * 用户登录信息，MySQL存储
 */
@JsonSerialize
public class UserLogin {
    private Long id;

    private Long uid;

    @JsonFormat(pattern = Constants.DATE_FORMAT_MILLI, timezone = "GMT+8")
    private Date loginTime;

    private String loginIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", uid=" + uid +
                ", loginTime=" + loginTime +
                ", loginIp='" + loginIp + '\'' +
                '}';
    }
}
