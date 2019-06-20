package com.example.springboottest1.mapper;

import com.example.springboottest1.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface commentMapper {
    //新评论发表，向comment表中添加数据
    int addcomment(@Param("posttime") String posttime,
                   @Param("statuename") String statuename,
                   @Param("username") String username,
                   @Param("introduction") String introduction);

    //通过发表评论者查找
    List<Comment> findCommentByUsername(@Param("username") String username);

    //通过雕塑名查找
    List<Comment> findCommentByStatuename(@Param("statuename") String statuename);

}
