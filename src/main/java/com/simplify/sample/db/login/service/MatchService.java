package com.simplify.sample.db.login.service;

import com.simplify.sample.db.login.dao.MatchDao;
import com.simplify.sample.db.login.model.UserModel;
import com.simplify.sample.db.login.model.WindmillAndLadybirdModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MatchService {

    @Autowired
    private MatchDao matchDao;

    public WindmillAndLadybirdModel getWindmillAndLadybirdInfo(UserModel userModel) throws Exception {
        return matchDao.getWindmillAndLadybirdInfo(userModel);
    }


    public int updateWindmillAndLadybird(WindmillAndLadybirdModel windmillAndLadybirdModel) throws Exception {
        return matchDao.updateWindmillAndLadybird(windmillAndLadybirdModel);
    }


}
