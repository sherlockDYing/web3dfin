package com.example.springboottest1.entity;

public class Statue {

    private String sid;

    private String descrip;

    private String auther;

    public String getId() {
        return sid;
    }

    public void setId(String sid) {
        this.sid = sid;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }
}
