package com.simplify.sample.db.login.service;


import com.simplify.sample.db.login.dao.LoginDao;
import com.simplify.sample.db.login.dao.QuestionDao;
import com.simplify.sample.db.login.model.QuestionModel;
import com.simplify.sample.db.login.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<QuestionModel> getQuestion(String topic) throws Exception {
        return questionDao.getQuestion(topic);
    }

}
