package com.transfar.webportal.chp.common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ������ on 2018/3/21.  ������ �ж��Ƿ��¼
 */
public class CommInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception {
        System.out.println(session);
        System.out.println(session.getAttribute("user"));
        //��session��ȡ��¼��Ϣ
        if(session.getAttribute("user")!=null) {
            System.out.println("������");
            return true;
        }else {
            System.out.println("����");
            System.out.println("Interceptor����ת��loginҳ�棡");
            response.sendRedirect("/login");
            return false;
        }
    }
}
