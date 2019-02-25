package com.fanyafeng.firstblog.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Author： fanyafeng
 * Data： 2019-02-25 22:06
 * Email: fanyafeng@live.cn
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (accessLoginInterceptor((HandlerMethod) handler)) {
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private boolean accessLoginInterceptor(HandlerMethod handlerMethod) {
        Method method = handlerMethod.getMethod();
        LoginInterceptorAnnotation annotation = method.getAnnotation(LoginInterceptorAnnotation.class);
        return annotation != null && annotation.required();
    }
}
