package com.tk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author taoke
 * @date 2021-8-30 21:37:20
 * @description 启动类
 */
@SpringBootApplication
@ComponentScan("com.tk.*")
@EnableScheduling
public class MessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class);
    }

}
