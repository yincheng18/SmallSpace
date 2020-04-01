package com.cxz.baselibs.bean;

import java.io.Serializable;

/**
 * @author chenxz
 * @date 2018/11/21
 * @desc
 */
public class BaseBean<T> implements Serializable {

    private int httpCode;

    private String httpMessage;

    private T data;

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpMessage() {
        return httpMessage;
    }

    public void setHttpMessage(String httpMessage) {
        this.httpMessage = httpMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
