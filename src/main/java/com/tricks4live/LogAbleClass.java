package com.tricks4live;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAbleClass {
    final Logger logger = LoggerFactory.getLogger(LogAbleClass.this.getClass().getTypeName());

    void println(String method, Object arg) {
        println(method + ": " + arg);
    }

    void println(String string) {
//        System.out.println("================================================================================================================================");
        System.out.println();
        logger.info(string);
//        System.out.println();
//        System.out.println("================================================================================================================================");

    }
}
