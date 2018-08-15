package com.tricks4live.enrties;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * 改进用MongoDB存储
 */
@JsonSerialize
@Document(collection = "subject_improvement")
public class Improvement implements Serializable {
    @Id
    private String id;
    private String uid;
    private String sid;
    private String content;//改进内容

    @Field("improve_date")
    private Date improveDate;//发起改进的时间

    private Boolean approve = false;//是否被采纳

    @Field("approve_date")
    private Date approveDate;//采纳的时间

    @Field("valid_users")
    private Pair<String, String>[] validUsers;//觉得有用的人

    @Field("invalid_users")
    private Pair<String, String>[] invalidUsers;//觉得没有用的人

    private Pair<String, String>[] verifiers;//参与验证的人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getImproveDate() {
        return improveDate;
    }

    public void setImproveDate(Date improveDate) {
        this.improveDate = improveDate;
    }

    public Boolean getApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Improvement that = (Improvement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(sid, that.sid) &&
                Objects.equals(content, that.content) &&
                Objects.equals(improveDate, that.improveDate) &&
                Objects.equals(approve, that.approve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, sid, content, improveDate, approve);
    }

    @Override
    public String toString() {
        return "Improvement{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", sid='" + sid + '\'' +
                ", content='" + content + '\'' +
                ", improveDate=" + improveDate +
                ", approve=" + approve +
                ", approveDate=" + approveDate +
                ", validUsers=" + Arrays.toString(validUsers) +
                ", invalidUsers=" + Arrays.toString(invalidUsers) +
                ", verifiers=" + Arrays.toString(verifiers) +
                '}';
    }
}
