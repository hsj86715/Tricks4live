package com.tricks4live.entries;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.utils.Constants;

import java.io.Serializable;
import java.util.Date;

@JsonSerialize
public class CommentInfo implements Serializable {
    private Long id;
    private Long subjectId;//评论的主题ID
    private UserSimple user;//评论人
    private String content;//评论内容
    private Long superId;//回复的评论ID

    private Integer floor = 1;//楼层
    private Integer agreeCount;

    private CommentInfo follow;
    private Boolean deleted = false;
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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

    public Long getSuperId() {
        return superId;
    }

    public void setSuperId(Long superId) {
        this.superId = superId;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getAgreeCount() {
        return agreeCount;
    }

    public void setAgreeCount(Integer agreeCount) {
        this.agreeCount = agreeCount;
    }

    public CommentInfo getFollow() {
        return follow;
    }

    public void setFollow(CommentInfo follow) {
        this.follow = follow;
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

    @Override
    public String toString() {
        return "CommentInfo{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", superId=" + superId +
                ", floor=" + floor +
                ", agreeCount=" + agreeCount +
                ", follow=" + follow +
                ", deleted=" + deleted +
                ", createDate=" + createDate +
                '}';
    }
}
