package com.tricks4live.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface Authority {
    int                 NONE = 1;//通过注册产生的用户，无任何权限，可以登录，浏览，需要邮箱验证
    int BASE =          NONE << 1;//需要邮箱验证，点赞，取消赞，评论，改进
    int VERIFIER =      NONE << 2;//验证员
    int CAT_SUB_3 =     NONE << 3;//3级分类下管理
    int CAT_SUB_2 =     NONE << 4;//2级分类下管理
    int CAT_SUB_1 =     NONE << 5;//1级分类下管理
    int SYSTEM_SUB =    NONE << 6;//后台子管理用户
    int SYSTEM_MAIN =   NONE << 7;//后台主管理用户
    int SYSTEM_ROOT =   NONE << 8;//系统超级管理，上帝
}
