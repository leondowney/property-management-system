package com.property.management.intercept;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author Leon Downey
 * @date 2023/4/7 14:05
 * @describe： 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
        return true;
    }
}
