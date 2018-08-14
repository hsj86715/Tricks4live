package com.tricks4live;

import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(BaseTest.this.getClass().getTypeName());

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
