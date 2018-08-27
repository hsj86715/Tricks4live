package com.tricks4live.entries;

/**
 * 用户收藏，MySQL存储
 */
public class Collection extends BaseDBEntry {
    private Long uid;
    private Long sid;

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


    @Override
    public String toString() {
        return "Collection{" + super.toString() +
                "uid=" + uid +
                ", sid=" + sid +
                '}';
    }
}
