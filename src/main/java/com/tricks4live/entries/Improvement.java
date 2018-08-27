package com.tricks4live.entries;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.utils.Constants;

import java.io.Serializable;
import java.util.Date;

/**
 * 主题改进，MySQL存储
 */
@JsonSerialize
public class Improvement extends BaseDBEntry implements Serializable {
    private Long uid;
    private Long sid;
    private String content;//改进内容

    private Boolean approve = false;//是否被采纳

    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date approveDate;//采纳的时间

    private Integer validCount;//觉得有用的人

    private Integer invalidCount;//觉得没有用的人

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
    public String toString() {
        return "Improvement{" + super.toString() +
                ", uid=" + uid +
                ", sid=" + sid +
                ", content='" + content + '\'' +
                ", approve=" + approve +
                ", approveDate=" + approveDate +
                ", validCount=" + validCount +
                ", invalidCount=" + invalidCount +
                '}';
    }
}
