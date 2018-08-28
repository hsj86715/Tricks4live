package com.tricks4live.vo;

import com.tricks4live.entries.Label;

import java.util.List;

public class SubjectVO extends PageVO {
    private Long id;
    private List<String> picturePaths;
    private List<Label> labelList;
    private Long categoryId;

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
}
