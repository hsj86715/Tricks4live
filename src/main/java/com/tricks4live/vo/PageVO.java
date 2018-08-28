package com.tricks4live.vo;

public abstract class PageVO {
    private Long limitOff;
    private Integer limitRows;

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
