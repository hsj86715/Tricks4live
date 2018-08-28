package com.tricks4live.entries.result;

import com.tricks4live.annotation.ErrCode;
import com.tricks4live.annotation.Status;
import com.tricks4live.utils.Constants;
import com.tricks4live.utils.Constants.CodeMsg;

import java.io.Serializable;

public class BaseResult implements Serializable {
    @ErrCode
    protected Integer code;
    @Status
    protected String status;
    protected String msg;

    public BaseResult() {
        setCodeMsg(Constants.getErrorMsg(ErrCode.OK));
        this.status = Status.SUCCESS;
    }

    public BaseResult(@ErrCode Integer code, @Status String status) {
        setCodeMsg(Constants.getErrorMsg(code));
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

    public void setCodeMsg(CodeMsg codeMsg) {
        setCode(codeMsg.getCode());
        setMsg(codeMsg.getMsg());
    }

    public void setCodeMsg(CodeMsg codeMsg, Object... args) {
        setCode(codeMsg.getCode());
        setMsg(String.format(codeMsg.getMsg(), args));
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
