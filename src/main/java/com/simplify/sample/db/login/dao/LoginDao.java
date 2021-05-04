package com.simplify.sample.db.login.dao;


 import com.simplify.sample.db.login.model.UserModel;
 import org.apache.catalina.User;
 import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 import java.util.List;

@Repository
public class LoginDao {

    protected static final String NAMESPACE = "Account.";

    @Autowired
    private SqlSession sqlSession;


//    public int checkUser(UserModel usermodel){
//        return sqlSession.selectOne(NAMESPACE + "checkUser", usermodel);
//    }
    public int checkUser(UserModel usermodel) throws Exception{
        return sqlSession.selectOne(NAMESPACE + "checkUser", usermodel);
    }

//    /**
//     * 유저 계정 저장
//     *
//     * @param usermodel
//     * @return
//     * @throws Exception
//     */
//    public int registerInfo(UserModel usermodel){
//         return sqlSession.insert(NAMESPACE + "registerInfo", usermodel);
//    }
//
//    /**
//     * 유저 저장
//     *
//     * @param usermodel
//     * @return
//     * @throws Exception
//     */
//    public int registerUserEntry(UserModel usermodel){
//        return sqlSession.insert(NAMESPACE + "registerUserEntry", usermodel);
//    }




}
