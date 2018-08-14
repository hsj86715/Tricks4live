package com.tricks4live.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.tricks4live.annotation.ErrCode.*;


@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@IntDef({UNKNOWN, OK,
        USERNAME_OCCUPIED, EMAIL_OCCUPIED, PHONE_OCCUPIED, PWD_SHORT, PWD_SIMPLE, USER_NOT_EXISTS,
        REQUEST_PARAMETER_LOST})
public @interface ErrCode {
    /**
     * 未知异常
     */
    int UNKNOWN = 0;
    /**
     * 缺少请求的必要参数
     */
    int REQUEST_PARAMETER_LOST = 201;
    //==========================正常=============================//
    /**
     * 正常执行完成
     */
    int OK = 200;
    //========================= User ============================//
    //用户名被占用
    int USERNAME_OCCUPIED = 101;

    //邮箱被占用
    int EMAIL_OCCUPIED = 102;

    //手机已被绑定其他账号
    int PHONE_OCCUPIED = 103;

    //用户名为空
    int EMPTY_USERNAME = 104;

    //用户密码为空
    int EMPTY_PWD = 105;

    //用户邮箱为空
    int EMPTY_EMAIL = 106;

    //密码长度不够
    int PWD_SHORT = 107;

    //密码过于简单
    int PWD_SIMPLE = 108;

    //用户不存在
    int USER_NOT_EXISTS = 109;

    //用户名或密码错误
    int USERNAME_OR_PWD_ERR = 110;
}
