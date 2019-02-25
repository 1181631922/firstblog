package com.fanyafeng.firstblog.interceptor;

import java.lang.annotation.*;

/**
 * Author： fanyafeng
 * Data： 2019-02-25 22:02
 * Email: fanyafeng@live.cn
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoginInterceptorAnnotation {
    boolean required() default true;
}
