package com.fanyafeng.firstblog.config;

import com.fanyafeng.firstblog.interceptor.LoginInterceptor;
import com.fanyafeng.firstblog.interceptor.LoginInterceptorAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Author： fanyafeng
 * Data： 2019-02-25 22:09
 * Email: fanyafeng@live.cn
 */
@SpringBootConfiguration
public class GlobalConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/user");
        super.addInterceptors(registry);
    }
}
