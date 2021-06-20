package com.simplify.sample.db.login.dao;


import com.simplify.sample.db.login.model.UserEntryModel;
import com.simplify.sample.db.login.model.UserModel;
import com.simplify.sample.db.login.model.WindmillAndLadybirdModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
