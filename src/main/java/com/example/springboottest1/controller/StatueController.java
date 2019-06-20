package com.example.springboottest1.controller;

import com.example.springboottest1.entity.Statue;
import com.example.springboottest1.response.ErrorResponse;
import com.example.springboottest1.response.SuccessResponse;
import com.example.springboottest1.service.StatueService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/statue")
public class StatueController {

    @Autowired
    StatueService statueService;

    @ResponseBody
    @RequestMapping(value = "/statueByName")
    public Object getStatueByName(@Param("statuename") String statuename){
        Statue statue = statueService.findStatuerByStatuename(statuename);
        if(statue!=null) {
            return new SuccessResponse(statue,"get statue successfully");
        }else return new ErrorResponse("fail to get statue");
    }
}
