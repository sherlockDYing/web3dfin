package com.example.springboottest1.entity;

public class Comment {

    private String id;

    private String posttime;

    private String statuename;

    private String username;

    private String introduction;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getStatuename() {
        return statuename;
    }

    public void setStatuename(String statuename) {
        this.statuename = statuename;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }
}
