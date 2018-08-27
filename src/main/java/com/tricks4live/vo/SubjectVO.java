package com.tricks4live.vo;

import com.tricks4live.entries.Label;

import java.util.List;

public class SubjectVO {
    private Long id;
    private List<String> picturePaths;
    private List<Label> labelList;
    private Long categoryId;
    private Long limitOff;
    private Integer limitRows;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getPicturePaths() {
        return picturePaths;
    }

    public void setPicturePaths(List<String> picturePaths) {
        this.picturePaths = picturePaths;
    }

    public List<Label> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<Label> labelList) {
        this.labelList = labelList;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
