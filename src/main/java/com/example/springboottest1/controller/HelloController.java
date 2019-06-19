package com.example.springboottest1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    //    @RequestMapping("/hello")
//    public String index(ModelMap map){
//        //单个数据
//        map.put("username", "入门案例");
//        return "hello";
//    }
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "hello";
    }

}



