package com.tricks4live;

import java.lang.reflect.Type;

public class Steps implements Type{
    private String operation;
    private String picture;
    private Integer timeCosts;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getTimeCosts() {
        return timeCosts;
    }

    public void setTimeCosts(Integer timeCosts) {
        this.timeCosts = timeCosts;
    }

    @Override
    public String toString() {
        return "Steps{" +
                "operation='" + operation + '\'' +
                ", picture='" + picture + '\'' +
                ", timeCosts=" + timeCosts +
                '}';
    }
}
