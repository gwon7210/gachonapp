package com.simplify.sample.db.support;

import com.simplify.sample.db.login.model.UserEntryModel;
import com.simplify.sample.db.login.model.UserModel;
import com.simplify.sample.db.login.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {

    @Autowired
    QuestionService questionService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        HttpSession session = request.getSession();
        Object obj = session.getAttribute("userModel");
        log.info(request.getRequestURI());

        if(request.getRequestURI().equals("/logout")||request.getRequestURI().equals("/")) {
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


        UserModel userModel = (UserModel)session.getAttribute("userModel");
        if(userModel != null) {

            // 로그인 성공시 Session에 저장후, 초기 화면 이동
            log.info("new login success");

            UserEntryModel userEntryModel = new UserEntryModel();
            userEntryModel.setId(userModel.getId());
            userEntryModel = questionService.getUserEntry(userEntryModel);

            if(userEntryModel != null){
                modelAndView.addObject("selfIntroduce", userEntryModel.getIntroduction() );
            }

            session.setAttribute("userModel", userModel);
         }else{
            session.invalidate();
        }

     }
}
