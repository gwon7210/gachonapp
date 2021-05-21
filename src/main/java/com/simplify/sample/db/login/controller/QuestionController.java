package com.simplify.sample.db.login.controller;

import com.simplify.sample.db.login.model.QuestionEntryModel;
import com.simplify.sample.db.login.model.QuestionModel;
import com.simplify.sample.db.login.service.QuestionService;
import com.simplify.sample.db.login.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Controller
public class QuestionController {

        @Autowired
        UserInfoService userInfoService;

        @Autowired
        QuestionService questionService;

        @GetMapping("/question/{topic}")
        public String questionPage(@PathVariable String topic, Model model) throws Exception {

            List<QuestionEntryModel> questionEntryModelList = questionService.getQuestionEntry(topic);
            QuestionModel questionModel = questionService.getQuestion(topic);

            model.addAttribute("questionEntryModelList", questionEntryModelList);
            model.addAttribute("questionModel", questionModel);
            model.addAttribute("topic", topic);
            return "/questions/questions";
        }

    @PostMapping("/question/getanswer")
    public String getanswer(String answer) throws Exception {

        return "/main/page";
    }


}
