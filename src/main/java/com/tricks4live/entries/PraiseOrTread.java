package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * 赞或者踩，MySQL存储
 */
@JsonSerialize
public class PraiseOrTread extends BaseDBEntry implements Serializable {
    private Long sid;
    private Long uid;
    private Boolean praise = false;
    private Boolean tread = false;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Boolean getPraise() {
        return praise;
    }

    public void setPraise(Boolean praise) {
        this.praise = praise;
    }

    public Boolean getTread() {
        return tread;
    }

    public void setTread(Boolean tread) {
        this.tread = tread;
    }

    @Override
    public String toString() {
        return "PraiseOrTread{" + super.toString() +
                "sid=" + sid +
                ", uid=" + uid +
                ", praise=" + praise +
                ", tread=" + tread +
                '}';
    }
}
