package com.simplify.sample.db.login.controller;

import com.simplify.sample.db.login.model.WindmillAndLadybirdModel;
import com.simplify.sample.db.login.model.UserEntryModel;
import com.simplify.sample.db.login.model.UserModel;
import com.simplify.sample.db.login.service.MatchService;
import com.simplify.sample.db.login.service.QuestionService;
import com.simplify.sample.db.login.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
public class MatchingController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    QuestionService questionService;
    @Autowired
    MatchService matchService;

        @GetMapping("/getMatchingUser")
        public String getMatchingUser(Model model, HttpServletRequest request) throws Exception {

            UserModel user = (UserModel)request.getSession().getAttribute("userModel");
            UserModel userInfo = userInfoService.getUserInfo(user.getId());

            //램덤으로 유저 3명 대려옴 (본인 성별 제외하는 쿼리 추가)
            List<UserModel> userModel = userInfoService.getRandomUserInfoList(userInfo);
            List<UserEntryModel> userEntryModelList =userInfoService.getUserEntry(userModel);


            model.addAttribute("userModel", userModel);
            model.addAttribute("userEntryModelList", userEntryModelList);
            return "/matching/matching";
        }


        @PostMapping("/tryfirstmatch")
        public String tryfirstmatch(String id) throws Exception {

            UserModel userInfo = userInfoService.getUserInfo(id);
            WindmillAndLadybirdModel windmillAndLadybirdModel = matchService.getWindmillAndLadybirdInfo(userInfo);

            //바람개비가 하나 이상일 때만 매칭을 시도한다.
            if(windmillAndLadybirdModel.getWindmillCount()==0){
                return "/main/page";
            }

            //바람개비가 하나 이상이면 -1을 한 후 상대방에게 메세지를 보낸다.



            return "hello";
        }

}
