package com.simplify.sample.db.login.dao;


 import com.simplify.sample.db.login.model.UserModel;
 import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 import java.util.List;


@Repository
public class LoginDao {

    protected static final String NAMESPACE = "Account.";

    @Autowired
    private SqlSession sqlSession;


    public int checkUser(UserModel usermodel) throws Exception{
        return sqlSession.selectOne(NAMESPACE + "checkUser", usermodel);
    }

    public List<UserModel> getRandomUserInfoList() throws Exception{
        return sqlSession.selectList(NAMESPACE + "getRandomUserInfoList");
    }



}
