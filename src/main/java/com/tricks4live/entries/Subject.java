package com.tricks4live.entries;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.utils.Constants;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 主题，MySQL存储
 */
@JsonSerialize
public class Subject implements Serializable {
    private Long id;
    private String title;
    private Long cid;//所属分类
    private Long uid;//发布者ID

    private String content;

    private List<String> picUrls;

    private String videoUrl;

    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date lastModify;

//    private Integer validCount;//觉得有用的人
//
//    private Integer invalidCount;//觉得没有用的人
//
    private List<Label> labels;

    private Boolean visible = true;
    private Boolean deleted = false;

    public Subject() {
    }

    public Subject(String title, Long cid, Long uid, String content) {
        this.title = title;
        this.cid = cid;
        this.uid = uid;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }

//    public Integer getValidCount() {
//        return validCount;
//    }
//
//    public void setValidCount(Integer validCount) {
//        this.validCount = validCount;
//    }
//
//    public Integer getInvalidCount() {
//        return invalidCount;
//    }
//
//    public void setInvalidCount(Integer invalidCount) {
//        this.invalidCount = invalidCount;
//    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id) &&
                Objects.equals(title, subject.title) &&
                Objects.equals(cid, subject.cid) &&
                Objects.equals(uid, subject.uid) &&
                Objects.equals(createTime, subject.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, cid, uid, createTime);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cid=" + cid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", picUrls=" + picUrls +
                ", videoUrl='" + videoUrl + '\'' +
                ", createTime=" + createTime +
                ", lastModify=" + lastModify +
                ", labels=" + labels +
                ", visible=" + visible +
                ", deleted=" + deleted +
                '}';
    }
}
