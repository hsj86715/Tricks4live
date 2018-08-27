package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * 赞或者踩，MySQL存储
 */
@JsonSerialize
public class Verifier extends BaseDBEntry implements Serializable {
    private Long sid;
    private Long uid;
    private Boolean valid;

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

    @Override
    public String toString() {
        return "Verifier{" + super.toString() +
                "sid=" + sid +
                ", uid=" + uid +
                ", valid=" + valid +
                '}';
    }
}
