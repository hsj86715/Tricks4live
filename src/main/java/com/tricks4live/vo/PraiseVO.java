package com.tricks4live.vo;

import com.tricks4live.annotation.PraiseType;

public class PraiseVO extends PageVO {
    private Long contentId;
    @PraiseType
    private String praiseType;

    private Boolean praised = null;

    public PraiseVO() {
    }

    public PraiseVO(Long contentId, String praiseType) {
        this.contentId = contentId;
        this.praiseType = praiseType;
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
}
