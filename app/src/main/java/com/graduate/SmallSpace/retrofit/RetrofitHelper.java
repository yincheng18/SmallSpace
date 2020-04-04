package com.graduate.SmallSpace.retrofit;

import com.cxz.baselibs.http.RetrofitManager;

public class RetrofitHelper {

    /**
     * 获取 RetrofitService
     */
    public static SmallSpaceService getRetrofitService() {
        return RetrofitManager.getInstance().obtainRetrofitService(SmallSpaceService.URL, SmallSpaceService.class);
    }
}
