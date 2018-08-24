package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;

/**
 * 标签，MySQL存储
 */
@JsonSerialize
public class Label {
    private Long id;
    private String nameCN;
    private String nameEN;

    public Label() {
    }

    public Label(String nameCN, String nameEN) {
        this.nameCN = nameCN;
        this.nameEN = nameEN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(id, label.id) &&
                Objects.equals(nameCN, label.nameCN) &&
                Objects.equals(nameEN, label.nameEN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCN, nameEN);
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", nameCN='" + nameCN + '\'' +
                ", nameEN='" + nameEN + '\'' +
                '}';
    }
}
