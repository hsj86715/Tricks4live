package com.tricks4live.utils;

import com.tricks4live.annotation.ErrCode;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final Duration REDIS_CACHE_DURATION = Duration.ofSeconds(120);

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_MILLI = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_FORMAT_DAY = "yyyy-MM-dd";
    public static final String HEADER = "Accept=application/json";
    public static final String APPLICATION_JSON = "application/json";
    private static final Map<Integer, CodeMsg> CODE_MSG;

    static {
        CODE_MSG = new HashMap<>();
        CODE_MSG.put(ErrCode.UNKNOWN, new CodeMsg(ErrCode.UNKNOWN, "Unknown Error"));
        CODE_MSG.put(ErrCode.OK, new CodeMsg(ErrCode.OK, "Request executed successfully"));

        CODE_MSG.put(ErrCode.EMAIL_OCCUPIED, new CodeMsg(ErrCode.EMAIL_OCCUPIED,
                "The email: %s has been occupied by other user, please change another."));
        CODE_MSG.put(ErrCode.USERNAME_OCCUPIED, new CodeMsg(ErrCode.USERNAME_OCCUPIED,
                "The user name: %s has been occupied by other user, please change another."));
        CODE_MSG.put(ErrCode.PHONE_OCCUPIED, new CodeMsg(ErrCode.PHONE_OCCUPIED,
                "The phone: %s has been occupied by other user, please change another."));
        CODE_MSG.put(ErrCode.EMPTY_USERNAME, new CodeMsg(ErrCode.EMPTY_USERNAME,
                "User name must not be null or empty."));
        CODE_MSG.put(ErrCode.EMPTY_PWD, new CodeMsg(ErrCode.EMPTY_PWD, "Password must not be null or empty."));
        CODE_MSG.put(ErrCode.EMPTY_EMAIL, new CodeMsg(ErrCode.EMPTY_EMAIL, "Email must not be null or empty."));
        CODE_MSG.put(ErrCode.PWD_SHORT, new CodeMsg(ErrCode.PWD_SHORT, "The password is too short, the suggested minimal length is 6."));
        CODE_MSG.put(ErrCode.PWD_SIMPLE, new CodeMsg(ErrCode.PWD_SIMPLE, "The password is too simple, need more complex."));
        CODE_MSG.put(ErrCode.USER_NOT_EXISTS, new CodeMsg(ErrCode.USER_NOT_EXISTS, "The user name: %s is not exists."));
        CODE_MSG.put(ErrCode.USERNAME_OR_PWD_ERR, new CodeMsg(ErrCode.USERNAME_OR_PWD_ERR,
                "User name or password are not correct."));

        CODE_MSG.put(ErrCode.REQUEST_PARAMETER_LOST, new CodeMsg(ErrCode.REQUEST_PARAMETER_LOST,
                "The request %s must not be null or empty."));
        CODE_MSG.put(ErrCode.ILLEGAL_ARGUMENT, new CodeMsg(ErrCode.ILLEGAL_ARGUMENT, "The argument %s is/are not illegal."));
        CODE_MSG.put(ErrCode.EMAIL_NEED_VERIFY, new CodeMsg(ErrCode.EMAIL_NEED_VERIFY, "Your email need be verified first."));
        CODE_MSG.put(ErrCode.PERMISSION_PROHIBITED, new CodeMsg(ErrCode.PERMISSION_PROHIBITED,
                "User operation has been refused by permission prohibited."));
    }

    public static CodeMsg getErrorMsg(@ErrCode Integer errCode) {
        return CODE_MSG.get(errCode);
    }

    public static class CodeMsg {
        private Integer code;
        private String msg;

        private CodeMsg(@ErrCode Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
