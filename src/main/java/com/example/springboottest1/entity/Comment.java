package com.example.springboottest1.entity;

public class Comment {

    private String id;

    private String username;

    private String content;

    private String statue;

    private int likeNum;

    private String createDate;

    public Comment(String id,String username,String content,String statue,int likeNum,String createDate){
        this.id= id;
        this.username=username;
        this.content=content;
        this.statue=statue;
        this.likeNum=likeNum;
        this.createDate=createDate;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
