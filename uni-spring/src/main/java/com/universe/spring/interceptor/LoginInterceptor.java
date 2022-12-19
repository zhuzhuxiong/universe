package com.universe.spring.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author l x
 */
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("hello","world");

        String contextPath = request.getContextPath();
        log.info("contextPath:{}",contextPath);
        log.info("attribute:{}",request.getAttribute("hello"));
        return super.preHandle(request, response, handler);
    }
}
