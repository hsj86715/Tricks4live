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
 * 评论用MongoDB存储
 */
@JsonSerialize
@Document(collection = "subject_comment")
public class Comment implements Serializable{
    @Id
    private String id;//自身ID

    private String sid;//评论的主题ID
    private String uid;//评论人ID
    private String content;//评论内容
    private String superId;//回复的评论ID

    @Field("comment_time")
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = "GMT+8")
    private Date commentTime;//评论时间

    @Field("agree_users")
    private Pair<String, String>[] agreeUsers;//赞同的人的ID和头像

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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

    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Pair<String, String>[] getAgreeUsers() {
        return agreeUsers;
    }

    public void setAgreeUsers(Pair<String, String>[] agreeUsers) {
        this.agreeUsers = agreeUsers;
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
                "id='" + id + '\'' +
                ", sid='" + sid + '\'' +
                ", uid='" + uid + '\'' +
                ", content='" + content + '\'' +
                ", superId='" + superId + '\'' +
                ", commentTime=" + commentTime +
                ", agreeUsers=" + Arrays.toString(agreeUsers) +
                '}';
    }
}
