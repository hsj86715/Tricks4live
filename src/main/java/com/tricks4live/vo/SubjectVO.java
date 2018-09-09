package com.tricks4live.vo;

import com.tricks4live.entries.LabelSimple;

import java.util.List;

public class SubjectVO extends PageVO {
    private Long id;
    private List<LabelSimple> labelList;
    private Long categoryId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LabelSimple> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<LabelSimple> labelList) {
        this.labelList = labelList;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
