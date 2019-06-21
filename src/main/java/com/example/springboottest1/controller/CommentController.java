package com.example.springboottest1.controller;

import com.example.springboottest1.entity.Comment;
import com.example.springboottest1.entity.User;
import com.example.springboottest1.response.ErrorResponse;
import com.example.springboottest1.response.SuccessResponse;
import com.example.springboottest1.service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/addComment")
    public Object addComment(@Param("newcomment") String newcomment, @Param("statuename") String statuename, HttpSession httpSession){
        String username = (String) httpSession.getAttribute("username");
        if (username == null) {
            return "noLoginAlert";
        } else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String posttime = df.format(new Date());// new Date()为获取当前系统时间
//            Comment comment = new Comment();
//            comment.setIntroduction(newcomment);
//            comment.setStatuename(statuename);
//            comment.setUsername(username);
           if( commentService.addcomment(posttime,statuename,username, newcomment)>0){
               return new SuccessResponse("评论成功");
           }else return new ErrorResponse("评论失败");
        }
    }

    @RequestMapping(value = {"/findCommentByStatuename"})
    public String findCommentByStatuename(@Param("statuename") String statuename,Model model){
        List<Comment>  commentsByStatue=commentService.findCommentByStatuename(statuename);
        System.out.println(commentsByStatue.size());
            model.addAttribute("commentsByStatue",commentsByStatue);
            return "VR::comment";
    }

    @RequestMapping(value = "/findCommentByUsername")
    public String findCommentByUsername(@Param("username") String username,Model model){
        List<Comment> commentsByUser = commentService.findCommentByUsername(username);
        System.out.println("username comment"+commentsByUser.size());
        model.addAttribute("commentsByUser",commentsByUser);
        return "VR::personnalComment";
    }


}
