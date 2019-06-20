package com.example.springboottest1.service;

import com.example.springboottest1.entity.Comment;
import com.example.springboottest1.mapper.commentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
public class CommentService {


    @Autowired
    private commentMapper commentMapper;

    public int addcomment(String posttime,
                          String statuename,
                          String username,
                          String introduction) {
        return commentMapper.addcomment(posttime, statuename, username, introduction);
    }

    public List<Comment> findCommentByUsername(String username) {
        return commentMapper.findCommentByUsername(username);
    }

    public List<Comment> findCommentByStatuename(String statuename) {
        return commentMapper.findCommentByStatuename(statuename);
    }
}
