package com.tricks4live;

import java.lang.reflect.Type;

public class Steps implements Type{
    private String operation;
    private String stepPicture;
    private Integer stepCost;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStepPicture() {
        return stepPicture;
    }

    public void setStepPicture(String stepPicture) {
        this.stepPicture = stepPicture;
    }

    public Integer getStepCost() {
        return stepCost;
    }

    public void setStepCost(Integer stepCost) {
        this.stepCost = stepCost;
    }

    @Override
    public String toString() {
        return "Steps{" +
                "operation='" + operation + '\'' +
                ", stepPicture='" + stepPicture + '\'' +
                ", stepCost=" + stepCost +
                '}';
    }
}
