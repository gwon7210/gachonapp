package com.simplify.sample.db.login.controller;

import com.simplify.sample.db.login.dao.QuestionDao;
import com.simplify.sample.db.login.model.QuestionModel;
import com.simplify.sample.db.login.service.QuestionService;
import com.simplify.sample.db.login.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Slf4j
@Controller
public class QuestionController {

        @Autowired
        UserInfoService userInfoService;

        @Autowired
        QuestionService questionService;

        @GetMapping("/question/{topic}")
        public String loginPage(@PathVariable String topic) throws Exception {

            List<QuestionModel> model = questionService.getQuestion(topic);

            String url = "/questions/".concat(topic);
            return url;
        }


}
