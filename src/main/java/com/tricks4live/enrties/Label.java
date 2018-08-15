package com.tricks4live.enrties;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

/**
 * 标签用MongoDB存储
 */
@JsonSerialize
@Document(collection = "label")
public class Label {
    @Id
    private String id;
    @Field("name_cn")
    private String nameCN;
    @Field("name_en")
    private String nameEN;

    public Label() {
    }

    public Label(String nameCN, String nameEN) {
        this.nameCN = nameCN;
        this.nameEN = nameEN;
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
                "id='" + id + '\'' +
                ", nameCN='" + nameCN + '\'' +
                ", nameEN='" + nameEN + '\'' +
                '}';
    }
}
