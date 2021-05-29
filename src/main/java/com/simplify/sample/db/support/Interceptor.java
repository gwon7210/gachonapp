package com.simplify.sample.db.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {
    private static final String LOGIN = "login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Object obj = session.getAttribute("userModel");
        log.error(request.getRequestURI());

        if(request.getRequestURI().equals("/logout")) {
            session.invalidate();
            response.sendRedirect("/first");
        }
        if(!request.getRequestURI().equals("/first")) {
            if (obj == null&&!request.getRequestURI().equals("/checkuser")) {
                response.sendRedirect("/first");
                return false;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();

        Object userModel = session.getAttribute("userModel");
        if(userModel != null) {

            // 로그인 성공시 Session에 저장후, 초기 화면 이동
            log.info("new login success");
            session.setAttribute(LOGIN, userModel);
        }else{
            session.invalidate();
        }

     }
}
