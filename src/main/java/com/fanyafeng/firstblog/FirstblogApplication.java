package com.fanyafeng.firstblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.fanyafeng.firstblog.dao")
public class FirstblogApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FirstblogApplication.class, args);
    }

}
