package com.transfar.webportal.chp.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 汤玉龙 on 2018/3/21.  登录拦截器
 */
public class CommInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        //获取Session
        HttpSession session = request.getSession();
        System.out.println(session);
        System.out.println(session.getAttribute("user"));
        if(session.getAttribute("user")!=null) {
            System.out.println("session存在");
            return true;
        }else {
            System.out.println("session不存在");
            return false;
        }
    }
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exc)
            throws Exception {

    }
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler,ModelAndView modelAndView) throws Exception {
    }
}
