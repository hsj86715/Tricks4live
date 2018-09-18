package com.tricks4live.entries;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.annotation.ContentType;
import com.tricks4live.utils.Constants;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonSerialize
public class SubjectInfo implements Serializable {
    private Long id;//自身ID
    private String title;
    private CategorySimple category;//所属分类
    private UserSimple user;//发布者
    private String content;
    private String coverPicture;
    @ContentType
    private String contentType = ContentType.SIMPLE;
    private String operateSteps;//json格式字符串
    private String videoUrl;
    private Integer validCount;//觉得有用的人
    private Integer invalidCount;//觉得没有用的人
    private Boolean validated = false;
    private Boolean invalidated = false;
    private Boolean collected = false;
    private Boolean focused = false;
    private List<LabelSimple> labels;
    private Boolean deleted = false;
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date createDate;
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date updateDate;

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

    public CategorySimple getCategory() {
        return category;
    }

    public void setCategory(CategorySimple category) {
        this.category = category;
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

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Boolean getInvalidated() {
        return invalidated;
    }

    public void setInvalidated(Boolean invalidated) {
        this.invalidated = invalidated;
    }

    public Boolean getCollected() {
        return collected;
    }

    public void setCollected(Boolean collected) {
        this.collected = collected;
    }

    public Boolean getFocused() {
        return focused;
    }

    public void setFocused(Boolean focused) {
        this.focused = focused;
    }

    public List<LabelSimple> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelSimple> labels) {
        this.labels = labels;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Subject toSubject() {
        Subject subject = new Subject(title, category.getId(), user.getId(), content);
        subject.setContentType(contentType);
        subject.setCoverPicture(coverPicture);
        subject.setOperateSteps(operateSteps);
        subject.setUpdateDate(updateDate);
        subject.setCreateDate(createDate);
        subject.setDeleted(deleted);
        subject.setVideoUrl(videoUrl);
        return subject;
    }

    @Override
    public String toString() {
        return "SubjectInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", coverPicture='" + coverPicture + '\'' +
                ", contentType='" + contentType + '\'' +
                ", operateSteps='" + operateSteps + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", validCount=" + validCount +
                ", invalidCount=" + invalidCount +
                ", validated=" + validated +
                ", invalidated=" + invalidated +
                ", collected=" + collected +
                ", focused=" + focused +
                ", labels=" + labels +
                ", deleted=" + deleted +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
