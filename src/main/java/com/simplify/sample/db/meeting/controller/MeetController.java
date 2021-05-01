package com.simplify.sample.db.meeting.controller;//package com.gachonmeeting.demo.db.meeting.controller;
//
//import com.gachonmeeting.demo.db.login.model.UserModel;
//import com.gachonmeeting.demo.db.login.service.UserInfoService;
//import com.gachonmeeting.demo.db.meeting.service.MeetService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//
//@Slf4j
//@RestController
//public class MeetController {
//
//    @Autowired
//    MeetService meetService;
//
//    @GetMapping("/login")
//    public String loginPage(){
//        return "/login";
//    }
//
//    //사용자로 부터 id,pass를 받아 회원 정보를 체크
//    @PostMapping("/checkuser")
//    public void checkUser(UserModel usermodel){
//
//    }
//
//    @GetMapping("/register")
//    public String registerPage(){
//        return "/register";
//    }
//
//
//    //추가적인 정보들을 등록한다.
//    @PostMapping("/registeruserenrty")
//    public String registerUserEntry(@RequestBody UserModel usermodel, HttpServletResponse response) throws Exception {
//
//        int rowCount = meetService.registerUserEntry(usermodel);
//
//        if(rowCount == 0){
//            log.error("정보입력도중 오류가 발생했습니다.");
//        }
//
//        return "/registeruserenrty";
//    }
//
//
//
//
//}
