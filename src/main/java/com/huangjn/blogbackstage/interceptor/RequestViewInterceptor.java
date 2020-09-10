package com.huangjn.blogbackstage.interceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
配置跳转页面的拦截器
 */
@Component
public class RequestViewInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null || modelAndView.getViewName().startsWith("redirect")) {
            return;
        }

        String path = request.getServletPath();
        String template = (String) modelAndView.getModelMap().get("template");
        if (StringUtils.isBlank(template)) {
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            modelAndView.getModelMap().addAttribute(
                    "template", path.toLowerCase());
        }
        HandlerInterceptor.super.preHandle(request,response,handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        HandlerInterceptor.super.preHandle(request,response,handler);
    }
}
