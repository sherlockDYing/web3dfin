package com.example.springboottest1.mapper;

import com.example.springboottest1.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface userMapper {

    //用户登录
    User userlogin(@Param("username") String username, @Param("password") String password);

    //新用户注册，向user表中添加数据
    int adduser(@Param("username") String username,
                @Param("gender") String gender,
                @Param("location") String location,
                @Param("introduction") String introduction,
                @Param("workplace") String workplace,
                @Param("role") int role,
                @Param("password") String password,
                @Param("userimgsrc") String userimgsrc);

    //通过id查找
    User findUserByID(@Param("id") String id);

    //通过name查找
    User findUserByUsername(@Param("username") String username);

    Boolean updateUser(User user);
}