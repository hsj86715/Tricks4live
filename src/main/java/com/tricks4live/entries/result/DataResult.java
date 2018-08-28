package com.tricks4live.entries.result;

public class DataResult<T> extends BaseResult {
    private T data;

    public DataResult() {
        super();
    }

    public DataResult(T data) {
        super();
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataResult{" +
                "data=" + data +
                ", code=" + code +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
