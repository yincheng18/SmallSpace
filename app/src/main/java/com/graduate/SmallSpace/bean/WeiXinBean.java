package com.graduate.SmallSpace.bean;

public class WeiXinBean<T> {


    private int code;

    private String message;

    private T result;

    public WeiXinBean() {

    }

    public WeiXinBean(int errorCode, String errorMsg, T data) {
        this.code = errorCode;
        this.message = errorMsg;
        this.result = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "errorCode=" + code +
                ", errorMsg='" + message + '\'' +
                ", data=" + result +
                '}';
    }


}
