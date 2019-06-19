package com.example.springboottest1.service;

import com.example.springboottest1.entity.User;
import com.example.springboottest1.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Component
public class UserService {

    @Autowired
    private userMapper usermapper;

    public User userLogin(String username, String password){
        return usermapper.userlogin(username,password);
    }

    public int adduser(String username,String password,int role){ return usermapper.adduser1(username,password,role); }

   // public List<Map<String,Object>> queryAllUser(){
//        return usermapper.queryAllUser();
//    }
//
    public User findUserByID(String id){return  usermapper.findUserByID(id);}
}
