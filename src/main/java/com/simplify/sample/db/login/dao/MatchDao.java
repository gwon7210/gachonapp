package com.simplify.sample.db.login.dao;


import com.simplify.sample.db.login.model.Matchingmodel;
import com.simplify.sample.db.login.model.UserEntryModel;
import com.simplify.sample.db.login.model.UserModel;
import com.simplify.sample.db.login.model.WindmillAndLadybirdModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MatchDao {

    protected static final String NAMESPACE = "Account.";

    @Autowired
    private SqlSession sqlSession;

    public WindmillAndLadybirdModel getWindmillAndLadybirdInfo(UserModel userModel) throws Exception{
        return sqlSession.selectOne(NAMESPACE + "getWindmillAndLadybirdInfo", userModel);
    }

    public int updateWindmillAndLadybird(WindmillAndLadybirdModel windmillAndLadybirdModel) throws Exception{
        return sqlSession.update(NAMESPACE + "updateWindmillAndLadybird", windmillAndLadybirdModel);
    }

    public int sendFirstMessage(HashMap<String, String> map) throws Exception{
        return sqlSession.insert(NAMESPACE + "sendFirstMessage", map);
    }

    public List<Matchingmodel> getFirstMatch(UserModel userModel) throws Exception{
        return sqlSession.selectList(NAMESPACE + "getFirstMatch", userModel);
    }

    public int insertThirdMatchYesorNo(Map map) throws Exception{
        return sqlSession.insert("senderandreceiver", map);
    }




}
