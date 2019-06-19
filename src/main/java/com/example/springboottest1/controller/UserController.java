package com.example.springboottest1.controller;

import com.example.springboottest1.entity.User;
import com.example.springboottest1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = {"/user"})
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/loginPage"})
    public String loginHtml() {
        return "userLogin";
    }

    @RequestMapping(value = {"/registerPage"})
    public String registerpage() {
        return "userRegister";
    }

    @RequestMapping(value = {"/personalPage"})
    public String personalPage(){return "personalPage";}
//    public String userInfo(Model model) {
//        List<Comment> commets = new ArrayList<>();
//        commets.add(new Comment("1", "q", "haokan", "ren", 111, "201901"));
//        commets.add(new Comment("2", "r", "nankan", "rabbit", 222, "201902"));
//        model.addAttribute("commets", commets);
//        return "personalPage";
//    }
    @ResponseBody
    @RequestMapping(value = {"/userLogin"})
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpServletRequest request) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            return "Please fill in all the empty block.";


        User user = userService.userLogin(username, password);

        if (user != null)
            return "login successful";
        else
            return "Fail to log in! Please check your username or password.";
    }

    @ResponseBody
    @RequestMapping(value = {"/userRegister"})
    public void addUser(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("password2") String password2,
                        @RequestParam("role") int role,
                        HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        System.out.println("role" + role);
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(password2) || role == 0) {
            out.print("<script language=\"javascript\">alert('Please fill in all the empty block.');window.location.href='/user/registerPage'</script>");
            return;
        }

        if (!password.equals(password2)) {
            out.print("<script language=\"javascript\">alert('Please check your password.');window.location.href='/user/registerPage'</script>");
            return;
        }

        if (userService.adduser(username, password, role) == 0) {
            out.print("<script language=\"javascript\">alert('Fail to register!');window.location.href='/user/registerPage'</script>");
            return;
        } else {
            out.print("<script language=\"javascript\">alert('Success！');window.location.href='/user/loginPage'</script>");
        }
    }

}
