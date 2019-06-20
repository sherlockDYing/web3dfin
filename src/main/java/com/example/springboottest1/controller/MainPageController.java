package com.example.springboottest1.controller;

import com.example.springboottest1.entity.Comment;
import com.example.springboottest1.entity.Statue;
import com.example.springboottest1.entity.User;
import com.example.springboottest1.service.StatueService;
import com.example.springboottest1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    private UserService userService;
    @Autowired
    private StatueService statueService;

    @RequestMapping(value = {"/mainPage"})
    public String mainPage(HttpSession httpSession,Model model) {
        //根据session获取username userid；
        String username = (String) httpSession.getAttribute("username");
        if (username == null) {
            return "noLoginAlert";
        } else {
            User user = userService.findUserByUsername(username);
            model.addAttribute("user", user);
            return "VR";
        }
    }


}
