package com.example.springboottest1.service;

import com.example.springboottest1.entity.User;
import com.example.springboottest1.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class UserService {

    @Autowired
    private userMapper usermapper;


    public User userLogin(String username, String password) {
        return usermapper.userlogin(username, password);
    }

    public int adduser(String username,
                       String gender,
                       String location,
                       String introduction,
                       String workplace,
                       int role,
                       String password) {
        return usermapper.adduser(
                username,
                gender,
                location,
                introduction,
                workplace,
                role,
                password);
    }

    public User findUserByID(String id) {
        return usermapper.findUserByID(id);
    }

    public User findUserByUsername(String username) {
        return usermapper.findUserByUsername(username);
    }

    public Boolean updateUser(User user) {
        return usermapper.updateUser(user);
    }
}
