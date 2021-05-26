package com.simplify.sample.db.login.service;


import com.simplify.sample.db.login.dao.QuestionDao;
import com.simplify.sample.db.login.model.QnAmodel;
import com.simplify.sample.db.login.model.QuestionEntryModel;
import com.simplify.sample.db.login.model.QuestionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<QuestionEntryModel> getQuestionEntry(String topic) throws Exception {
        return questionDao.getQuestionEntry(topic);
    }

    public QuestionModel getQuestion(String topic) throws Exception {
        return questionDao.getQuestion(topic);
    }

    public int createUserAnswer(QnAmodel model) throws Exception {
        return questionDao.createUserAnswer(model);
    }

}
