package com.tricks4live.entries;

import com.tricks4live.annotation.ContentType;

import java.io.Serializable;

/**
 * 主题，MySQL存储
 */
public class Subject extends BaseDBEntry implements Serializable {
    private String title;
    private Long categoryId;//所属分类
    private Long userId;//发布者
    private String content;
    private String coverPicture;
    @ContentType
    private String contentType = ContentType.SIMPLE;
    private String operateSteps;//json格式字符串
    private String videoUrl;
    private Boolean deleted = false;

    public Subject() {
    }

    public Subject(String title, Long categoryId, Long userId, String content) {
        this.title = title;
        this.categoryId = categoryId;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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


    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


    @Override
    public String toString() {
        return "Subject{" + super.toString() +
                ", title='" + title + '\'' +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                ", coverPicture='" + coverPicture + "\'" +
                ", content='" + content + '\'' +
                ", contentType='" + contentType + "\'" +
                ", operateSteps='" + operateSteps + "\'" +
                ", videoUrl='" + videoUrl + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
