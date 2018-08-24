package com.tricks4live.entries;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.utils.Constants;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 评论，MongoDB存储
 */
@JsonSerialize
public class Comment implements Serializable {
    private Long id;//自身ID

    private Long sid;//评论的主题ID
    private Long uid;//评论人ID
    private String content;//评论内容

    private Long superId;//回复的评论ID

    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date commentTime;//评论时间

//    private List<Pair<String, String>> agreeUsers;//赞同的人的ID和头像

    private Integer floor = 1;//楼层

    private Comment follow;

    public Comment() {
    }

    public Comment(Long sid, Long uid, String content) {
        this.sid = sid;
        this.uid = uid;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
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

    public Long getSuperId() {
        return superId;
    }

    public void setSuperId(Long superId) {
        this.superId = superId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
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

    public Comment getFollow() {
        return follow;
    }

    public void setFollow(Comment fellow) {
        this.follow = fellow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(sid, comment.sid) &&
                Objects.equals(uid, comment.uid) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(superId, comment.superId) &&
                Objects.equals(commentTime, comment.commentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sid, uid, content, superId, commentTime);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", sid=" + sid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", superId=" + superId +
                ", commentTime=" + commentTime +
                ", floor=" + floor +
                ", follow=" + follow +
                '}';
    }
}
