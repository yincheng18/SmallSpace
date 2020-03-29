package com.graduate.SmallSpace.retrofit;

public class ResultBean<T> {

    private T data;

    private String adIndex;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getAdIndex() {
        return adIndex;
    }

    public void setAdIndex(String adIndex) {
        this.adIndex = adIndex;
    }
}
