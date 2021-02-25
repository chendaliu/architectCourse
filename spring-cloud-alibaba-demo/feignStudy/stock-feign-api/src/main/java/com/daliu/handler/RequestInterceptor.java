package com.daliu.handler;

import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @Title:
 * @Description:
 * @Author: Daliu
 * @CreateTime: 2021-02-25 01:03
 * @Version:1.0
 **/
public class RequestInterceptor implements feign.RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        template.header("token", request.getHeader("token"));
    }
}