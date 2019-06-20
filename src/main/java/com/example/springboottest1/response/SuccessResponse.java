package com.example.springboottest1.response;

public class SuccessResponse {
    private int code = 200;
    private Object data;
    private String msg;
    public SuccessResponse(Object data){
        this.data = data;
    }
    public SuccessResponse(Object data, String msg){
        this.data = data;
        this.msg = msg;
    }
    public  SuccessResponse(String msg){
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
