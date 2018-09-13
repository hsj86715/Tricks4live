package com.tricks4live;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAbleClass {
    final Logger logger = LoggerFactory.getLogger(LogAbleClass.this.getClass().getTypeName());

    protected void println(String method, Object arg) {
        println(method + ": " + arg);
    }

    protected void println(String string) {
        System.out.println();
        logger.info(string);
    }

    protected void printlnWithDivider(String method, Object arg) {
        printlnWithDivider(method + ": " + arg);
    }

    protected void printlnWithDivider(String string) {
        System.out.println("================================================================================================================================");
        println(string);
        System.out.println();
        System.out.println("================================================================================================================================");
    }
}
