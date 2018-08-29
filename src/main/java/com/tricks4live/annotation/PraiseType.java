package com.tricks4live.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.tricks4live.annotation.PraiseType.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@StringDef({PRAISE_TREAD, VERIFY_SUBJECT, VERIFY_IMPROVE, AGREE_COMMENT, COLLECT_SUBJECT})
public @interface PraiseType {
    String PRAISE_TREAD = "Praise_Tread";
    String VERIFY_SUBJECT = "Verify_Subject";
    String VERIFY_IMPROVE = "Verify_Improve";
    String AGREE_COMMENT = "Agree_Comment";
    String COLLECT_SUBJECT = "Collect_Subject";
}
