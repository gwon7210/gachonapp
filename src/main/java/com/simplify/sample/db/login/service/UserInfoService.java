package com.simplify.sample.db.login.service;


  import com.simplify.sample.db.login.dao.LoginDao;
  import com.simplify.sample.db.login.model.UserModel;
  import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserInfoService {

    @Autowired
    private LoginDao loginDao;


    public int checkUser(UserModel usermodel) throws Exception {
        return loginDao.checkUser(usermodel);
    }

    /**
     * 유저 계정 정보 저장
     *
     * @param usermodel
     * @return
     * @throws Exception
     */
     public int registerInfo(UserModel usermodel) throws Exception {
          return loginDao.registerInfo(usermodel);
     }

    /**
     * 유저 정보 저장
     *
     * @param usermodel
     * @return
     * @throws Exception
     */
    public int registerUserEntry(UserModel usermodel) throws Exception {
        return loginDao.registerUserEntry(usermodel);
    }

}
