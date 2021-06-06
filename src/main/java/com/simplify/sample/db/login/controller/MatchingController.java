package com.simplify.sample.db.login.controller;

import com.simplify.sample.db.login.model.UserModel;
import com.simplify.sample.db.login.service.QuestionService;
import com.simplify.sample.db.login.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class MatchingController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    QuestionService questionService;


        @GetMapping("/getMatchingUser")
        public String getMatchingUser() throws Exception {

            List<UserModel> userModel = userInfoService.getRandomUserInfoList();


            // 유저 3명 대려오기

            // 각 유저들 이너 조인을 통해 각 유저 정보 가져오기

            // 뿌려주기


            return "/index";
        }





}