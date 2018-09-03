package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * 标签，MySQL存储
 */
@JsonSerialize
public class Label extends BaseDBEntry implements Serializable {
    private String nameCN;
    private String nameEN;

    public Label() {
    }

    public Label(String nameCN, String nameEN) {
        this.nameCN = nameCN;
        this.nameEN = nameEN;
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
    public String toString() {
        return "Label{" + super.toString() +
                ", nameCN='" + nameCN + '\'' +
                ", nameEN='" + nameEN + '\'' +
                '}';
    }
}
