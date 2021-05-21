package com.simplify.sample.db.login.dao;


import com.simplify.sample.db.login.model.QuestionEntryModel;
import com.simplify.sample.db.login.model.QuestionModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDao {

    protected static final String NAMESPACE = "Question.";

    @Autowired
    private SqlSession sqlSession;


    public List<QuestionEntryModel> getQuestionEntry(String topic) throws Exception{
        return sqlSession.selectList(NAMESPACE + "getQuestionEntry", topic);
    }

    public QuestionModel getQuestion(String topic) throws Exception{
        return sqlSession.selectOne(NAMESPACE + "getQuestion", topic);
    }

}
