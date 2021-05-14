package com.simplify.sample.db.login.controller;

import com.simplify.sample.db.login.model.UserModel;
import com.simplify.sample.db.login.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class QuestionController {

        @Autowired
        UserInfoService userInfoService;

        @GetMapping("/question/{topic}")
        public String loginPage(@PathVariable String topic){

            String url = "/questions/".concat(topic);
            return url;
        }


}
