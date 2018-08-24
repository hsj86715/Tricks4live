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
public class Verifier implements Serializable {
    private Long id;
    private Long sid;
    private Long uid;
    private Boolean valid;

    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date verifyDate;

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

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    @Override
    public String toString() {
        return "Verifier{" +
                "id=" + id +
                ", sid=" + sid +
                ", uid=" + uid +
                ", valid=" + valid +
                ", verifyDate=" + verifyDate +
                '}';
    }
}
