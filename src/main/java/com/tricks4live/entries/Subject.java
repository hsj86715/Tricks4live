package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.List;

/**
 * 主题，MySQL存储
 */
@JsonSerialize
public class Subject extends BaseDBEntry implements Serializable {
    private String title;
    private Long cid;//所属分类
    private Long uid;//发布者ID
    private String content;
    private List<String> picUrls;
    private String videoUrl;
    //    private Integer validCount;//觉得有用的人
//    private Integer invalidCount;//觉得没有用的人
    private List<Label> labels;
    private Boolean deleted = false;

    public Subject() {
    }

    public Subject(String title, Long cid, Long uid, String content) {
        this.title = title;
        this.cid = cid;
        this.uid = uid;
        this.content = content;
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
    public String toString() {
        return "Subject{" + super.toString() +
                "title='" + title + '\'' +
                ", cid=" + cid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", picUrls=" + picUrls +
                ", videoUrl='" + videoUrl + '\'' +
                ", labels=" + labels +
                ", deleted=" + deleted +
                '}';
    }
}
