package com.tricks4live.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.tricks4live.annotation.ContentType.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@StringDef({SIMPLE, STEP, STEP_WITH_TIME})
public @interface ContentType {
    String SIMPLE = "Simple";
    String STEP = "Step";
    String STEP_WITH_TIME = "Step_with_time";
}
