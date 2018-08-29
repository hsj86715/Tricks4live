package com.tricks4live.vo;

import com.tricks4live.annotation.PraiseType;

public class PraiseVO extends PageVO {
    private Long contentId;
    @PraiseType
    private String praiseType;

    private Boolean praised = null;

    private Long userId;

    public PraiseVO() {
    }

    public PraiseVO(@PraiseType String praiseType, Boolean praised) {
        this(null, praiseType, praised);
    }

    public PraiseVO(Long contentId, @PraiseType String praiseType, Boolean praised) {
        this.contentId = contentId;
        this.praiseType = praiseType;
        this.praised = praised;
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

    public void setPraiseType(String praiseType) {
        this.praiseType = praiseType;
    }

    public Boolean getPraised() {
        return praised;
    }

    public void setPraised(Boolean praised) {
        this.praised = praised;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
