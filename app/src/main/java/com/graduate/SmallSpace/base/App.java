package com.graduate.SmallSpace.base;

import android.content.Context;

import com.graduate.SmallSpace.utils.LogUtils;


public class App extends com.cxz.baselibs.app.BaseApp {

    public static Context mCtx;

    @Override
    public void onCreate() {
        super.onCreate();
        mCtx=getApplicationContext();
        LogUtils.isDebug(true);
    }
}
