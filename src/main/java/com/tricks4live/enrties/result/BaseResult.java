package com.tricks4live.enrties.result;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.annotation.Status;

import java.io.Serializable;

public class BaseResult implements Serializable {
    @ErrCode
    protected Integer code;
    @Status
    protected String status;
    protected String msg;

    public BaseResult() {
        this.code = ErrCode.OK;
        this.status = Status.SUCCESS;
    }

    public BaseResult(Integer code, @Status String status) {
        this.code = code;
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
