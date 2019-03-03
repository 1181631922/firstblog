package com.fanyafeng.firstblog;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
@MapperScan("com.fanyafeng.firstblog.dao")
public class FirstblogApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FirstblogApplication.class, args);
    }

}
