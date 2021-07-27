package com.simplify.sample.db.login.service;


  import com.simplify.sample.db.login.dao.LoginDao;
  import com.simplify.sample.db.login.model.UserEntryModel;
  import com.simplify.sample.db.login.model.UserModel;
  import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

  import java.util.List;

@Service
@Slf4j
public class UserInfoService {

    @Autowired
    private LoginDao loginDao;


    public int checkUser(UserModel usermodel) throws Exception {
        return loginDao.checkUser(usermodel);
    }

    public List<UserModel> getRandomUserInfoList(UserModel userModel) throws Exception {
        return loginDao.getRandomUserInfoList(userModel);
    }

    public List<UserEntryModel> getUserEntry(List<UserModel> userModelList) throws Exception {
        return loginDao.getUserEntry(userModelList);
    }

    public UserModel getUserInfo(String id) throws Exception {
        return loginDao.getUserInfo(id);
    }

    public List<UserModel> getUserInfoList(List<UserModel> userModelList) throws Exception {
        return loginDao.getUserInfoList(userModelList);
    }

    public int createAnimal(UserEntryModel model) throws Exception {
        return loginDao.createAnimal(model);
    }

}
