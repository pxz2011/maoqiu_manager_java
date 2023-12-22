package com.pxzq.maoqiumanager;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ASUS
 */
@SpringBootApplication
@MapperScan("com.pxzq.maoqiumanager.dao")
@Slf4j
public class MaoqiuManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaoqiuManagerApplication.class, args);
        log.info("Application started");
    }

}