package com.simplify.sample.db.login.controller;

import com.simplify.sample.db.login.model.*;
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



    //자기소개, mbti 답변
    @PostMapping("/question/createintroduction")
    public String createIntroduction(String selfIntroduce, String mbti, HttpServletRequest request, Model model) throws Exception {

        UserModel userModel = (UserModel)request.getSession().getAttribute("userModel");
        UserEntryModel userEntryModel = new UserEntryModel();
        userEntryModel.setId(userModel.getId());
        int isExist = questionService.getUserEntryCount(userEntryModel);

        //이미 답변이 되있는 상태이면, 해당 id의 엔트리를 모두 삭제한다.
        if(isExist >= 1){
            questionService.deleteUserEntry(userEntryModel);
        }


        userEntryModel.setId(userModel.getId());
        userEntryModel.setIntroduction(selfIntroduce);
        userEntryModel.setMbti(mbti);

        int rowCount = questionService.createUserEntry(userEntryModel);

        //화면에 표시될 자기소개글귀
        model.addAttribute("selfIntroduce",selfIntroduce);
        return "/main/page";
    }

    //재미있는 질문들 조회
    @GetMapping("/question/{topic}")
    public String questionPage(@PathVariable String topic, Model model) throws Exception {

        List<QuestionEntryModel> questionEntryModelList = questionService.getQuestionEntry(topic);
        QuestionModel questionModel = questionService.getQuestion(topic);

        model.addAttribute("questionEntryModelList", questionEntryModelList);
        model.addAttribute("questionModel", questionModel);
        model.addAttribute("topic", topic);
        return "/questions/questions";
    }

    //재미있는 질문칸에 대한 답변 생셩
    @PostMapping("/question/createanswer")
    public String createAnswer(String answer, String topic, HttpServletRequest request) throws Exception {

        UserModel userModel = (UserModel)request.getSession().getAttribute("userModel");

        QnAmodel qnamodel = new QnAmodel();
        qnamodel.setAnswer(answer);
        qnamodel.setTopic(topic);
        qnamodel.setId(userModel.getId());

        questionService.deleteUserAnswer(qnamodel);
        int rowCount = questionService.createUserAnswer(qnamodel);

        return "/main/page";
    }

}
