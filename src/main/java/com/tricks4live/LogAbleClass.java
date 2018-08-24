package com.tricks4live;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAbleClass {
    protected final Logger logger = LoggerFactory.getLogger(LogAbleClass.this.getClass().getTypeName());

    protected void println(String method, Object arg) {
        println(method + ": " + arg);
    }

    protected void println(String string) {
        System.out.println("================================================================================================================================");
        System.out.println();
        logger.info(string);
        System.out.println();
        System.out.println("================================================================================================================================");

    }
}
