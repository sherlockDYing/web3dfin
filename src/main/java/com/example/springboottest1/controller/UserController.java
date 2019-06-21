package com.example.springboottest1.controller;

import com.example.springboottest1.entity.Comment;
import com.example.springboottest1.entity.User;
import com.example.springboottest1.response.ErrorResponse;
import com.example.springboottest1.response.SuccessResponse;
import com.example.springboottest1.service.CommentService;
import com.example.springboottest1.service.TokenService;
import com.example.springboottest1.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping(value = {"/user"})
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = {"/loginPage"})
    public String loginHtml() {
        return "userLogin";
    }

    @RequestMapping(value = {"/registerPage"})
    public String registerpage() {
        return "userRegister";
    }

    //    @UserLoginToken
    @RequestMapping(value = {"/personalPage"})
    public String personalinfo(HttpSession httpSession, Model model) {
        //根据session获取username userid；
        String username = (String) httpSession.getAttribute("username");
        if (username == null) {
            return "noLoginAlert";
        } else {
            List<Comment> comments = commentService.findCommentByUsername(username);
            User user = userService.findUserByUsername(username);
            model.addAttribute("comments", comments);
            model.addAttribute("user", user);
            return "personalPage";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/userByName")
    public Object getStatueByName(@Param("username") String username) {
        User user = userService.findUserByUsername(username);
        if (user != null) {
            return new SuccessResponse(user, "get user successfully");
        } else return new ErrorResponse("fail to get user");
    }


    @ResponseBody
    @RequestMapping(value = {"/userLogin"})
    public Object userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession httpSession) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            return "Please fill in all the empty block.";

        User user = userService.userLogin(username, password);
        if (user != null) {
//            String token = tokenService.getToken(user);

            httpSession.setAttribute("username", username);
            return new SuccessResponse("success");
        } else
            return new ErrorResponse("fail to login");
    }


    @ResponseBody
    @RequestMapping(value = {"/userRegister"})
    public void addUser(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("role") int role,
                        @RequestParam("gender") String gender,
                        @RequestParam("location") String location,
                        @RequestParam("workplace") String workplace,
                        @RequestParam("introduction") String introduction,
                        HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        String userimgsrc = "/img/player/player" + role + ".png";
        if(userService.findUserByUsername(username)!=null)
        {
            out.print("<script language=\"javascript\">alert('username already existed!');window.location.href='/user/loginPage'</script>");
            return;
        }

        if (userService.adduser(username, gender, location, introduction, workplace, role, password, userimgsrc) == 0) {
            out.print("<script language=\"javascript\">alert('Fail to register!');window.location.href='/user/registerPage'</script>");
            return;
        } else {
            out.print("<script language=\"javascript\">alert('Success！');window.location.href='/user/loginPage'</script>");
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/quit"})
    public Object quit(HttpSession httpSession) {
        httpSession.removeAttribute("username");
        return new SuccessResponse("退出成功");
    }
}
