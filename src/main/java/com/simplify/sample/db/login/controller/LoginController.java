package com.simplify.sample.db.login.controller;

 import com.simplify.sample.db.login.model.UserModel;
 import com.simplify.sample.db.login.service.UserInfoService;
 import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/")
    public String loginPage(){
        return "/index.html";

    }

    //사용자로 부터 id,pass를 받아 회원 정보를 체크
    @PostMapping("/checkuser")
    public String checkUser(String id, String password, HttpServletRequest req) {

        UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setPassword(password);

        try {
            int isUser = userInfoService.checkUser(userModel);
            if(isUser != 0){
                return "/assets/index.html";
            }
         }
        catch (Exception e){
            log.error("회원정보가 없습니다.");
        }

        return "/test.html";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "/index.html";
    }
//
//    @PostMapping("/checkgachonstu")
//    public void isGachonStudent(UserModel usermodel){
//
//        //가천대학교 학생인지 검사한 후 회원가입 페이지를 보여준다.
//        //인증 방식은 알아보기
////        if("가천대생이 맞다면"){
////            return "redirect:/registerinfo";
////        }else{
////            return "/register";
////        }
//
//    }
//
//    //id,pass를 등록한다.
//    @PostMapping("/registeruser")
//    public String registeruser(@RequestBody UserModel usermodel, HttpServletResponse response) throws Exception {
//
//        int rowCount = userInfoService.registerInfo(usermodel);
//
//        if(rowCount == 0){
//            log.error("회원가입 도중 오류가 발생했습니다.");
//        }
//
//        return "/registeruserenrty";
//    }
//
//    //추가적인 정보들을 등록한다.
//    //등록 완료 후 myroom으로 간다.
//    @PostMapping("/registeruserenrty")
//    public String registerUserEntry(@RequestBody UserModel usermodel, HttpServletResponse response) throws Exception {
//
//        int rowCount = userInfoService.registerUserEntry(usermodel);
//
//        if(rowCount == 0){
//            log.error("정보입력도중 오류가 발생했습니다.");
//        }
//
//        return "/myroom";
//    }




}
