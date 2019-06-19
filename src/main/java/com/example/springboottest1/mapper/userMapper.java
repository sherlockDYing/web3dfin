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
    int adduser1(@Param("username") String username, @Param("password") String password, @Param("role") int role);


//    List<Map<String,Object>> queryAllUser();

     User findUserByID(@Param("id") String id);

}