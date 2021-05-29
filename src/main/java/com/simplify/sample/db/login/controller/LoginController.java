package com.simplify.sample.db.login.controller;

 import com.simplify.sample.db.login.model.UserModel;
 import com.simplify.sample.db.login.service.UserInfoService;
 import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.*;

 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    @Autowired
        UserInfoService userInfoService;

        @GetMapping("/first")
        public String loginPage(){

            return "/index";
        }

         //사용자로 부터 id,pass를 받아 회원 정보를 체크
        @PostMapping("/checkuser")
        public String checkUser(String id, String password, Model model, HttpServletRequest request) throws Exception {

            UserModel userModel = new UserModel();
            userModel.setId(id);
            userModel.setPassword(password);
            int isUser=0;

            try {
                isUser = userInfoService.checkUser(userModel);
                model.addAttribute("userModel", userModel);
            } catch (Exception e){
                log.error("로그인 시도중 오류가 발생했습니다.");
            }

            if(isUser != 0){
                request.getSession().setAttribute("userModel", userModel);
                return "/main/page";
            }else{
                request.getSession().setAttribute("userModel", null);
                return "/index";
            }
        }

    @GetMapping("/register")
    public String registerPage(){

        return "/index.html";
    }

    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 전체를 날려버림
        return "redirect:/index"; // 로그아웃 후 게시글 목록으로 이동하도록...함
    }
}
