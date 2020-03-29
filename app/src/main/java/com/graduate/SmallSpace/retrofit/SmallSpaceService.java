package com.graduate.SmallSpace.retrofit;

import com.cxz.baselibs.bean.BaseBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SmallSpaceService {

    String url="https://api.apiopen.top/";

    /**
     * ping百度
     */
    @GET("todayVideo")
    Observable<BaseBean> pingBaiDu();
}
