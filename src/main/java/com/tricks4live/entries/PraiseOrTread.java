package com.tricks4live.entries;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.utils.Constants;

import java.io.Serializable;
import java.util.Date;

/**
 * 赞或者踩，MySQL存储
 */
@JsonSerialize
public class PraiseOrTread implements Serializable {
    private Long id;
    private Long sid;
    private Long uid;
    private Boolean praise = false;
    private Boolean tread = false;

    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "PraiseOrTread{" +
                "id=" + id +
                ", sid=" + sid +
                ", uid=" + uid +
                ", praise=" + praise +
                ", tread=" + tread +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
