package com.hyun.shopping_mall_example.interceptor;

import com.hyun.shopping_mall_example.domain.UserVO;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        UserVO userVO = (UserVO)httpSession.getAttribute("user");

        if (userVO == null) {
            response.sendRedirect("/user/signin");
            return false;
        }

        if (!userVO.getIs_admin()) {
            response.sendRedirect("/");
            return false;
        }

        return true;
    }
}
