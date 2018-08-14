package com.tricks4live.enrties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @Column(name = "cid")
    private String cId;

    @Column(name = "cname_cn", length = 32)
    private String cNameCN;

    @Column(name = "cname_en", length = 64)
    private String cNameEN;

    @Column(name = "super_id")
    private String cSuperId;

    private Integer level = 1;

    public Category() {
    }

    public Category(String cId, String cNameCN, String cNameEN) {
        this.cId = cId;
        this.cNameCN = cNameCN;
        this.cNameEN = cNameEN;
    }

    public Category(String cId, String cNameCN, String cNameEN, String cSuperId, Integer level) {
        this.cId = cId;
        this.cNameCN = cNameCN;
        this.cNameEN = cNameEN;
        this.cSuperId = cSuperId;
        this.level = level;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcNameCN() {
        return cNameCN;
    }

    public void setcNameCN(String cNameCN) {
        this.cNameCN = cNameCN;
    }

    public String getcNameEN() {
        return cNameEN;
    }

    public void setcNameEN(String cNameEN) {
        this.cNameEN = cNameEN;
    }

    public String getcSuperId() {
        return cSuperId;
    }

    public void setcSuperId(String cSuperId) {
        this.cSuperId = cSuperId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(cId, category.cId) &&
                Objects.equals(cNameCN, category.cNameCN) &&
                Objects.equals(cNameEN, category.cNameEN) &&
                Objects.equals(cSuperId, category.cSuperId) &&
                Objects.equals(level, category.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cId, cNameCN, cNameEN, cSuperId, level);
    }

    @Override
    public String toString() {
        return "Category{" +
                "cId='" + cId + '\'' +
                ", cNameCN='" + cNameCN + '\'' +
                ", cNameEN='" + cNameEN + '\'' +
                ", cSuperId='" + cSuperId + '\'' +
                ", level=" + level +
                '}';
    }
}
