package com.simplify.sample.db.login.controller;

import com.simplify.sample.db.login.model.Matchingmodel;
import com.simplify.sample.db.login.model.WindmillAndLadybirdModel;
import com.simplify.sample.db.login.model.UserEntryModel;
import com.simplify.sample.db.login.model.UserModel;
import com.simplify.sample.db.login.service.MatchService;
import com.simplify.sample.db.login.service.QuestionService;
import com.simplify.sample.db.login.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
public class MatchingController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    QuestionService questionService;
    @Autowired
    MatchService matchService;

        @GetMapping("/getMatchingUser")
        public String getMatchingUser(Model model, HttpServletRequest request) throws Exception {

            UserModel user = (UserModel)request.getSession().getAttribute("userModel");
            UserModel userInfo = userInfoService.getUserInfo(user.getId());

            //램덤으로 유저 3명 대려옴 (본인 성별 제외하는 쿼리 추가)
            List<UserModel> userModel = userInfoService.getRandomUserInfoList(userInfo);
            List<UserEntryModel> userEntryModelList =userInfoService.getUserEntry(userModel);


            model.addAttribute("userModel", userModel);
            model.addAttribute("userEntryModelList", userEntryModelList);
            return "/matching/matching";
        }


        @PostMapping("/tryfirstmatch")
        public String tryfirstmatch(String id, Model model, HttpServletRequest request)throws Exception {

            UserModel user = (UserModel)request.getSession().getAttribute("userModel");

            UserModel userInfo = userInfoService.getUserInfo(user.getId());
            WindmillAndLadybirdModel windmillAndLadybirdModel = matchService.getWindmillAndLadybirdInfo(userInfo);

            //바람개비가 하나 이상일 때만 매칭을 시도한다.
            if(windmillAndLadybirdModel.getWindmillCount()==0){
                return "/main/page";
            }

            //바람개비가 하나 이상이면 -1을 한 후 상대방에게 메세지를 보낸다.
            windmillAndLadybirdModel.setWindmillCount(windmillAndLadybirdModel.getWindmillCount()-1);
            int rowCount = matchService.updateWindmillAndLadybird(windmillAndLadybirdModel);

            //존재하는 상대방인지 확인 체크
            UserModel partnerInfo = userInfoService.getUserInfo(id);
            if(partnerInfo == null){
                throw new NullPointerException("존재하지 않는 사용자입니다.");
            }

            //상대방의 아이디와 메세지를 FirstMatching 테이블에 저장
            String message = request.getParameter("message");
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("message", message);
            map.put("sender", user.getId());
            map.put("receiver", id);
            int rowCount2 = matchService.sendFirstMessage(map);

            //상대방이 바람개비 봤을 때 무당이 사용하기


            return "/main/page";
        }


    @GetMapping("/getproposerinfolist")
    public String getProposerInfoList(Model model, HttpServletRequest request ) throws Exception {

        //본인 정보 조회
        UserModel user = (UserModel)request.getSession().getAttribute("userModel");
        UserModel userInfo = userInfoService.getUserInfo(user.getId());

        //본인에게 온 매칭시도들 조회
        List<Matchingmodel> matchingModelList = matchService.getFirstMatch(userInfo);
        List<UserModel> userModelList = new ArrayList<>();
        for(Matchingmodel matchingmodel : matchingModelList){
            UserModel tempModel = new UserModel();

            //혹시나 해당 유저에게 잘 온건지 한번 확인
            if(user.getId().equals(matchingmodel.getReceiver())) {
                tempModel.setId(matchingmodel.getSender());
            }

            userModelList.add(tempModel);
        }


        List<UserModel> proposersInfoList = userInfoService.getUserInfoList(userModelList);


        model.addAttribute("userModel", userInfo);
        model.addAttribute("userEntryModelList", proposersInfoList);

        return "/matching/proposers";
    }


    @PostMapping("/trysecondmatch")
    public String trysecondmatch(String id, Model model, HttpServletRequest request)throws Exception {


        UserModel user = (UserModel)request.getSession().getAttribute("userModel");

        UserModel userInfo = userInfoService.getUserInfo(user.getId());
        WindmillAndLadybirdModel windmillAndLadybirdModel = matchService.getWindmillAndLadybirdInfo(userInfo);

        //바람개비가 하나 이상일 때만 매칭을 시도한다.
        if(windmillAndLadybirdModel.getLadybirdCount()==0){
            return "/main/page";
        }

        //존재하는 상대방인지 확인 체크
        UserModel partnerInfo = userInfoService.getUserInfo(id);
        if(partnerInfo == null){
            throw new NullPointerException("존재하지 않는 사용자입니다.");
        }

        //바람개비가 하나 이상이면 -1을 한 후 상대방에게 메세지를 보낸다.
        windmillAndLadybirdModel.setLadybirdCount(windmillAndLadybirdModel.getLadybirdCount()-1);
        int rowCount = matchService.updateWindmillAndLadybird(windmillAndLadybirdModel);
        if(rowCount==0){
            throw new Exception();
        }

        //상대방의 실제 사진을 조회한다.
        



        return "/matching/proposerpicture";
    }

    @GetMapping("/yesornosecondmatching")
    public String yesornosecondmatching(int yesorno, String receiver, HttpServletRequest request) throws Exception {
        UserModel user = (UserModel)request.getSession().getAttribute("userModel");

        //no라면 -> 바로 전 페이지로 리턴 trysecondmatch
        if(yesorno==0){
            return "/trysecondmatch";
        }

        //yes라면 -> third 매치에 값 넣어주기
        if(yesorno==1){
            int rowCount = matchService.insertThirdMatchYesorNo(user.getId(),receiver);
        }


        return "/main/page";
    }


}
