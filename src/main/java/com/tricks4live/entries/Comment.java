package com.tricks4live.entries;

import java.io.Serializable;

/**
 * 评论，MongoDB存储
 */
public class Comment extends BaseDBEntry implements Serializable {
    private Long subjectId;//评论的主题ID
    private Long userId;//评论人
    private String content;//评论内容

    private Long superId;//回复的评论ID

    private Integer floor = 1;//楼层
    private Boolean deleted = false;

    public Comment() {

    }

    public Comment(Long subjectId, Long userId, String content) {
        this(subjectId, userId, content, null);
    }

    public Comment(Long subjectId, Long userId, String content, Long superId) {
        this.subjectId = subjectId;
        this.userId = userId;
        this.content = content;
        this.superId = superId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comment{" + super.toString() +
                ", subjectId=" + subjectId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", superId=" + superId +
                ", floor=" + floor +
                ", deleted=" + deleted +
                '}';
    }
}
