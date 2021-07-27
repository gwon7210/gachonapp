package com.simplify.sample.db.login.service;

import com.simplify.sample.db.login.dao.MatchDao;
import com.simplify.sample.db.login.model.Matchingmodel;
import com.simplify.sample.db.login.model.UserModel;
import com.simplify.sample.db.login.model.WindmillAndLadybirdModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public int sendFirstMessage(HashMap<String, String> map) throws Exception {
        return matchDao.sendFirstMessage(map);
    }

    public List<Matchingmodel> getFirstMatch(UserModel userModel) throws Exception {
        return matchDao.getFirstMatch(userModel);
    }

    public int insertThirdMatchYesorNo(String id, String receiver) throws Exception {
        Map map = new HashMap<String,String>();

        map.put("id",id);
        map.put("receiver", receiver);

        return matchDao.insertThirdMatchYesorNo(map);

    }


}
