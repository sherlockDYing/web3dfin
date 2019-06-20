package com.example.springboottest1.entity;

public class Statue {

    private String statuename;
    private String introduction;
    private String author;
    private String authorintro;
    private int likenumber;


    public String getStatuename() {
        return statuename;
    }

    public void setStatuename(String statuename) {
        this.statuename = statuename;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorintro() {
        return authorintro;
    }

    public void setAuthorintro(String authorintro) {
        this.authorintro = authorintro;
    }

    public int getLikenumber() {
        return likenumber;
    }

    public void setLikenumber(int likenumber) {
        this.likenumber = likenumber;
    }
}
