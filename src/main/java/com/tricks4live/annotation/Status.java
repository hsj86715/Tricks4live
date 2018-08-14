package com.tricks4live.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.tricks4live.annotation.Status.FAIL;
import static com.tricks4live.annotation.Status.SUCCESS;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@StringDef({SUCCESS, FAIL})
public @interface Status {
    String SUCCESS = "Success", FAIL = "Fail";
}
