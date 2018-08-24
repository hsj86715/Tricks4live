package com.tricks4live.entries;

import java.util.Date;
import java.util.Objects;

/**
 * 用户收藏，MySQL存储
 */
public class Collection {
    private Long id;
    private Long uid;
    private Long sid;

    private Date collectTime;

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

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(sid, that.sid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uid, sid);
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", sid='" + sid + '\'' +
                ", collectTime=" + collectTime +
                '}';
    }
}
