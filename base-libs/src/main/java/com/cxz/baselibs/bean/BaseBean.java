package com.cxz.baselibs.bean;

import java.io.Serializable;

/**
 * @author chenxz
 * @date 2018/11/21
 * @desc
 */
public class BaseBean<T> implements Serializable {


    private int code;

    private String message;

    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
