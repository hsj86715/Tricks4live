package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 主题改进，MySQL存储
 */
@JsonSerialize
public class Improvement implements Serializable {
    private Long id;
    private Long uid;
    private Long sid;
    private String content;//改进内容

    private Date improveDate;//发起改进的时间

    private Boolean approve = false;//是否被采纳

    private Date approveDate;//采纳的时间

    private Integer validCount;//觉得有用的人

    private Integer invalidCount;//觉得没有用的人

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getImproveDate() {
        return improveDate;
    }

    public void setImproveDate(Date improveDate) {
        this.improveDate = improveDate;
    }

    public Boolean getApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public Integer getValidCount() {
        return validCount;
    }

    public void setValidCount(Integer validCount) {
        this.validCount = validCount;
    }

    public Integer getInvalidCount() {
        return invalidCount;
    }

    public void setInvalidCount(Integer invalidCount) {
        this.invalidCount = invalidCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Improvement that = (Improvement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(sid, that.sid) &&
                Objects.equals(content, that.content) &&
                Objects.equals(improveDate, that.improveDate) &&
                Objects.equals(approve, that.approve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, sid, content, improveDate, approve);
    }

    @Override
    public String toString() {
        return "Improvement{" +
                "id=" + id +
                ", uid=" + uid +
                ", sid=" + sid +
                ", content='" + content + '\'' +
                ", improveDate=" + improveDate +
                ", approve=" + approve +
                ", approveDate=" + approveDate +
                ", validCount=" + validCount +
                ", invalidCount=" + invalidCount +
                '}';
    }
}
