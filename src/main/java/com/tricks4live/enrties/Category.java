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
    private String id;//自身ID

    @Column(name = "name_cn", length = 32)
    private String nameCN;//中文分类名称

    @Column(name = "name_en", length = 64)
    private String nameEN;//英文分类名称

    @Column(name = "super_id")
    private String superId;//上级分类ID

    private Integer level = 1;//分类等级

    private Boolean available = true;//是否可用

    public Category() {
    }

    public Category(String id, String nameCN, String nameEN) {
        this.id = id;
        this.nameCN = nameCN;
        this.nameEN = nameEN;
    }

    public Category(String id, String nameCN, String nameEN, String superId, Integer level) {
        this.id = id;
        this.nameCN = nameCN;
        this.nameEN = nameEN;
        this.superId = superId;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(nameCN, category.nameCN) &&
                Objects.equals(nameEN, category.nameEN) &&
                Objects.equals(superId, category.superId) &&
                Objects.equals(level, category.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCN, nameEN, superId, level);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", nameCN='" + nameCN + '\'' +
                ", nameEN='" + nameEN + '\'' +
                ", superId='" + superId + '\'' +
                ", level=" + level +
                ", available=" + available +
                '}';
    }
}
