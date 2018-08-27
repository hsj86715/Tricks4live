package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * 评论，MongoDB存储
 */
@JsonSerialize
public class Comment extends BaseDBEntry implements Serializable {
    private Long sid;//评论的主题ID
    private Long uid;//评论人ID
    private String content;//评论内容

    private Long superId;//回复的评论ID

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
    public String toString() {
        return "Comment{" + super.toString() +
                "sid=" + sid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", superId=" + superId +
                ", floor=" + floor +
                ", follow=" + follow +
                '}';
    }
}
