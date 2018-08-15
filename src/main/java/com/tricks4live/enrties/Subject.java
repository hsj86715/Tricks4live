package com.tricks4live.enrties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.utils.Constants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * 主题用MongoDB存储
 */
@JsonSerialize
@Document(collection = "subject")
public class Subject implements Serializable {
    @Id
    private String id;
    private String title;
    private String cid;//所属分类
    private String uid;//发布者ID

    private String content;

    @Field("pic_urls")
    private String[] picUrls;

    @Field("video_url")
    private String videoUrl;

    @Field("create_time")
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date createTime;

    @Field("last_modify")
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date lastModify;

    @Field("valid_users")
    private Pair<String, String>[] validUsers;//觉得有用的人

    @Field("invalid_users")
    private Pair<String, String>[] invalidUsers;//觉得没有用的人

    private Pair<String, String>[] verifiers;//参与验证的人

    private Label[] labels;

    private Boolean visible = true;
    private Boolean deleted = false;

    public Subject() {
    }

    public Subject(String title, String cid, String uid, String content) {
        this.title = title;
        this.cid = cid;
        this.uid = uid;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String[] picUrls) {
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

    public Pair<String, String>[] getValidUsers() {
        return validUsers;
    }

    public void setValidUsers(Pair<String, String>[] validUsers) {
        this.validUsers = validUsers;
    }

    public Pair<String, String>[] getInvalidUsers() {
        return invalidUsers;
    }

    public void setInvalidUsers(Pair<String, String>[] invalidUsers) {
        this.invalidUsers = invalidUsers;
    }

    public Pair<String, String>[] getVerifiers() {
        return verifiers;
    }

    public void setVerifiers(Pair<String, String>[] verifiers) {
        this.verifiers = verifiers;
    }

    public Label[] getLabels() {
        return labels;
    }

    public void setLabels(Label[] labels) {
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
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", cid='" + cid + '\'' +
                ", uid='" + uid + '\'' +
                ", content='" + content + '\'' +
                ", picUrls=" + Arrays.toString(picUrls) +
                ", videoUrl='" + videoUrl + '\'' +
                ", createTime=" + createTime +
                ", lastModify=" + lastModify +
                ", validUsers=" + Arrays.toString(validUsers) +
                ", invalidUsers=" + Arrays.toString(invalidUsers) +
                ", verifiers=" + Arrays.toString(verifiers) +
                ", labels=" + Arrays.toString(labels) +
                ", visible=" + visible +
                ", deleted=" + deleted +
                '}';
    }
}
