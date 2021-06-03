package com.simplify.sample.db.login.controller;

import com.simplify.sample.db.login.model.QnAmodel;
import com.simplify.sample.db.login.model.QuestionEntryModel;
import com.simplify.sample.db.login.model.QuestionModel;
import com.simplify.sample.db.login.model.UserModel;
import com.simplify.sample.db.login.service.QuestionService;
import com.simplify.sample.db.login.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String getanswer(String answer, String topic, HttpServletRequest request) throws Exception {

        UserModel userModel = (UserModel)request.getSession().getAttribute("userModel");

        QnAmodel qnamodel = new QnAmodel();
        qnamodel.setAnswer(answer);
        qnamodel.setTopic(topic);
        qnamodel.setId(userModel.getId());


        int rowCount = questionService.createUserAnswer(qnamodel);

        return "/main/page";
    }


}
