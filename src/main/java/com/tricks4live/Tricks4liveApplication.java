package com.tricks4live;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.tricks4live.mappers.*")
public class Tricks4liveApplication {
    public static void main(String[] args) {
        SpringApplication.run(Tricks4liveApplication.class, args);
    }
}
