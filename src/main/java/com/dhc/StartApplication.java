package com.dhc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author Haochen.Dai
 * @date Created in 2020/8/18 19:55
 * @description
 */
@SpringBootApplication
@Configuration
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
