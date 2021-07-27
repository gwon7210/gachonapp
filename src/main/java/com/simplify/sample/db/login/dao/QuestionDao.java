package com.simplify.sample.db.login.dao;


import com.simplify.sample.db.login.model.*;
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

    public int createUserAnswer(QnAmodel model) throws Exception{
        return sqlSession.insert(NAMESPACE + "createAnswer", model);
    }

    public int deleteUserAnswer(QnAmodel model) throws Exception{
        return sqlSession.insert(NAMESPACE + "deleteUserAnswer", model);
    }

    public int createUserEntry(UserEntryModel model) throws Exception{
        return sqlSession.insert(NAMESPACE + "createUserEntry", model);
    }

    public int getUserEntryCount(UserEntryModel model) throws Exception{
        return sqlSession.selectOne(NAMESPACE + "getUserEntryCount", model);
    }

    public int deleteUserEntry(UserEntryModel model) throws Exception{
        return sqlSession.delete(NAMESPACE + "deleteUserEntry", model);
    }

    public UserEntryModel getUserEntry(UserEntryModel model) throws Exception{
        return sqlSession.selectOne(NAMESPACE + "getUserEntry", model);
    }

}
