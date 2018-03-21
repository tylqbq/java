package com.transfar.webportal.chp.common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 汤玉龙 on 2018/3/21.  拦截器 判断是否登录
 */
public class CommInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception {
        System.out.println(session);
        System.out.println(session.getAttribute("user"));
        //从session获取登录信息
        if(session.getAttribute("user")!=null) {
            System.out.println("不拦截");
            return true;
        }else {
            System.out.println("拦截");
            System.out.println("Interceptor：跳转到login页面！");
            response.sendRedirect("/login");
            return false;
        }
    }
}
