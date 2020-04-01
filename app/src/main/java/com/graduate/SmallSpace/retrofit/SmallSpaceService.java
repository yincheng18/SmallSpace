package com.graduate.SmallSpace.retrofit;

import com.graduate.SmallSpace.bean.WeiXinBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SmallSpaceService {

    String url="https://api.apiopen.top/";

    /**
     * ping百度
     */
    @GET("todayVideo")
    Observable<WeiXinBean> pingBaiDu();
}
