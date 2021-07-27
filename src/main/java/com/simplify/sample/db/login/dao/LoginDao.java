package com.simplify.sample.db.login.dao;


import com.simplify.sample.db.login.model.UserEntryModel;
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


    public int checkUser(UserModel usermodel) throws Exception {
        return sqlSession.selectOne(NAMESPACE + "checkUser", usermodel);
    }

    public List<UserModel> getRandomUserInfoList(UserModel userModel) throws Exception {
        //userModel을 파라미터로 주니 오류 발생, 추후 조추하기 (본인 성별 제외를 위해)
        return sqlSession.selectList(NAMESPACE + "getRandomUserInfoList", userModel.getId());
    }

    public List<UserEntryModel> getUserEntry(List<UserModel> userModelList) throws Exception {
        return sqlSession.selectList(NAMESPACE + "getUserEntry", userModelList);
    }

    public UserModel getUserInfo(String id) throws Exception {
        return sqlSession.selectOne(NAMESPACE + "getUserInfo", id);
    }

    public List<UserModel> getUserInfoList(List<UserModel> userModelList) throws Exception {
        return sqlSession.selectList(NAMESPACE + "getUserInfoList", userModelList);
    }

    public int createAnimal(UserEntryModel model) throws Exception{
        return sqlSession.update(NAMESPACE + "createAnimal", model);
    }




}
