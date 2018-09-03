package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * 分类信息，MySQL存储
 */
@JsonSerialize
public class Category extends BaseDBEntry implements Serializable {
    private String nameCN;//中文分类名称

    private String nameEN;//英文分类名称

    private Long superId;//上级分类ID

    private Integer level = 1;//分类等级

    public Category(){

    }

    public Category(String nameCN, String nameEN) {
        this.nameCN = nameCN;
        this.nameEN = nameEN;
    }

    public Category(String nameCN, String nameEN, Long superId, Integer level) {
        this.nameCN = nameCN;
        this.nameEN = nameEN;
        this.superId = superId;
        this.level = level;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public Long getSuperId() {
        return superId;
    }

    public void setSuperId(Long superId) {
        this.superId = superId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Category{" + super.toString() +
                ", nameCN='" + nameCN + '\'' +
                ", nameEN='" + nameEN + '\'' +
                ", superId='" + superId + '\'' +
                ", level=" + level +
                '}';
    }
}
