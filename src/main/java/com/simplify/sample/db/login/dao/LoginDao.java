package com.simplify.sample.db.login.dao;


 import com.simplify.sample.db.login.model.UserModel;
 import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

    protected static final String NAMESPACE = "com.gachonmeeting.demo.db.login.dao.";

    @Autowired
    private SqlSession sqlSession;


    public int checkUser(UserModel usermodel){
        return sqlSession.insert(NAMESPACE + "checkUser", usermodel);
    }

    /**
     * 유저 계정 저장
     *
     * @param usermodel
     * @return
     * @throws Exception
     */
    public int registerInfo(UserModel usermodel){
         return sqlSession.insert(NAMESPACE + "registerInfo", usermodel);
    }

    /**
     * 유저 저장
     *
     * @param usermodel
     * @return
     * @throws Exception
     */
    public int registerUserEntry(UserModel usermodel){
        return sqlSession.insert(NAMESPACE + "registerUserEntry", usermodel);
    }




}
