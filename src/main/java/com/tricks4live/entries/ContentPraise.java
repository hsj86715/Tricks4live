package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tricks4live.annotation.PraiseType;

import java.io.Serializable;

@JsonSerialize
public class ContentPraise extends BaseDBEntry implements Serializable {
    private UserSimple user;
    private Long contentId;
    @PraiseType
    private String praiseType = PraiseType.PRAISE_TREAD;
    private Boolean praised = null;

    public ContentPraise() {
    }

    public ContentPraise(Long userId, Long contentId, @PraiseType String praiseType) {
        this(userId, contentId, praiseType, null);
    }

    public ContentPraise(Long userId, Long contentId, @PraiseType String praiseType, Boolean praised) {
        this.user = new UserSimple(userId);
        this.contentId = contentId;
        this.praiseType = praiseType;
        this.praised = praised;
    }

    public UserSimple getUser() {
        return user;
    }

    public void setUser(UserSimple user) {
        this.user = user;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getPraiseType() {
        return praiseType;
    }

    public void setPraiseType(@PraiseType String praiseType) {
        this.praiseType = praiseType;
    }

    public Boolean getPraised() {
        return praised;
    }

    public void setPraised(Boolean praised) {
        this.praised = praised;
    }

    @Override
    public String toString() {
        return "ContentPraise{" + super.toString() +
                ", user=" + user +
                ", contentId=" + contentId +
                ", praiseType=" + praiseType +
                ", praised=" + praised +
                '}';
    }
}
