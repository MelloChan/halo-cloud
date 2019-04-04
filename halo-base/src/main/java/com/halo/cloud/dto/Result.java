package com.halo.cloud.dto;

/**
 * @Author: mellochan[陈文铭]
 * @Date: 2019/3/14 22:54
 * @Version 1.0
 */
public class Result<T> {
    private String code;
    private String message;
    private T data;

    public Result(){

    }

    public Result(String code,String message){
        this.code=code;
        this.message=message;
    }

    public static Result success(){
        return new Result("0","SUCCESS");
    }

    public static Result error(){
        return new Result("50001","ERROR");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
