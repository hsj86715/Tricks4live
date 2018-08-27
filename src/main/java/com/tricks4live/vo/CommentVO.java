package com.tricks4live.vo;

public class CommentVO {
    private Long subjectId;
    private Long limitOff;
    private Integer limitRows;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getLimitOff() {
        return limitOff;
    }

    public void setLimitOff(Long limitOff) {
        this.limitOff = limitOff;
    }

    public Integer getLimitRows() {
        return limitRows;
    }

    public void setLimitRows(Integer limitRows) {
        this.limitRows = limitRows;
    }
}
