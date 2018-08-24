package com.tricks4live.entries.result;

public class UserCheckResult extends BaseResult {
    private Boolean usable = false;

    public Boolean getUsable() {
        return usable;
    }

    public void setUsable(Boolean usable) {
        this.usable = usable;
    }

    @Override
    public String toString() {
        return "UserCheckResult{" +
                "usable=" + usable +
                ", code=" + code +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
