package com.graduate.SmallSpace.retrofit;


import com.graduate.SmallSpace.bean.CommonBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SmallSpaceService {

    String  URL="http://192.168.1.102:8088/";

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("register")
    Observable<CommonBean> register(@Field("phone")String phone, @Field("userName")String userName, @Field("userPassWord")String userPassWord);

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("login")
    Observable<CommonBean> login(@Field("userAccount")String userAccount, @Field("userPassWord")String userPassWord);
}
