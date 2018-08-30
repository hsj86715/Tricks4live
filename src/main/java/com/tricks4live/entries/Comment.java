package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * 评论，MongoDB存储
 */
@JsonSerialize
public class Comment extends BaseDBEntry implements Serializable {
    private Long subjectId;//评论的主题ID
    private UserSimple user;//评论人
    private String content;//评论内容

    private Long superId;//回复的评论ID

//    private List<Pair<String, String>> agreeUsers;//赞同的人的ID和头像

    private Integer floor = 1;//楼层

    private Comment follow;
    private Boolean deleted = false;

    public Comment(Long subjectId, Long userId, String content) {
        this(subjectId, userId, content, null);
    }

    public Comment(Long subjectId, Long userId, String content, Long superId) {
        this.subjectId = subjectId;
        this.user = new UserSimple(userId);
        this.content = content;
        this.superId = superId;
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

//    public List<Pair<String, String>> getAgreeUsers() {
//        return agreeUsers;
//    }
//
//    public void setAgreeUsers(List<Pair<String, String>> agreeUsers) {
//        this.agreeUsers = agreeUsers;
//    }

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

    public Comment getFollow() {
        return follow;
    }

    public void setFollow(Comment fellow) {
        this.follow = fellow;
    }

    @Override
    public String toString() {
        return "Comment{" + super.toString() +
                ", subjectId=" + subjectId +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", superId=" + superId +
                ", floor=" + floor +
                ", deleted=" + deleted +
                ", follow=" + follow +
                '}';
    }
}
