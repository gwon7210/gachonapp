package com.simplify.sample.db.myroom.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyRoomController {

    //myroom page
    @GetMapping("/myroom")
    public String myRoom(){
        return "/myroom";
    }

    //star page
    @GetMapping("/showstar")
    public String star(){
        return "/star";
    }

    //macaroon page
    @GetMapping("/showmacaroon")
    public String macaroon(){
        return "/macaroon";
    }

    //matching start
    @GetMapping("/matchingstart")
    public String matchingStart(){
        return "/matchingstart";
    }



}
