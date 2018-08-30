package com.tricks4live.vo;

public class PageVO {
    private Long limitOff;
    private Integer limitRows;

    public PageVO() {
    }

    public PageVO(Long limitOff, Integer limitRows) {
        this.limitOff = limitOff;
        this.limitRows = limitRows;
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
