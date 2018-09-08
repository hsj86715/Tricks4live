package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.annotation.ContentType;

import java.io.Serializable;
import java.util.List;

/**
 * 主题，MySQL存储
 */
@JsonSerialize
public class Subject extends BaseDBEntry implements Serializable {
    private String title;
    private Long categoryId;//所属分类
    private UserSimple user;//发布者
    private String content;
    private String coverPicture;
    @ContentType
    private String contentType = ContentType.SIMPLE;
    private String operateSteps;//json格式字符串
    private String videoUrl;
    private Integer validCount;//觉得有用的人
    private Integer invalidCount;//觉得没有用的人
    private List<Label> labels;
    private Boolean deleted = false;

    public Subject() {
    }

    public Subject(String title, Long categoryId, Long userId, String content) {
        this.title = title;
        this.categoryId = categoryId;
        this.user = new UserSimple(userId);
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public UserSimple getUser() {
        return user;
    }

    public void setUser(UserSimple user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(@ContentType String contentType) {
        this.contentType = contentType;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public String getOperateSteps() {
        return operateSteps;
    }

    public void setOperateSteps(String operateSteps) {
        this.operateSteps = operateSteps;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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
                ", title='" + title + '\'' +
                ", categoryId=" + categoryId +
                ", user=" + user +
                ", coverPicture='" + coverPicture + "\'" +
                ", content='" + content + '\'' +
                ", contentType='" + contentType + "\'" +
                ", operateSteps='" + operateSteps + "\'" +
                ", videoUrl='" + videoUrl + '\'' +
                ", validCount=" + validCount +
                ", invalidCount" + invalidCount +
                ", labels=" + labels +
                ", deleted=" + deleted +
                '}';
    }
}
