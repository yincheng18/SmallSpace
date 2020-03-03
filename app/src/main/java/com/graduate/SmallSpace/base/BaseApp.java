package com.graduate.SmallSpace.base;

import android.app.Application;
import android.content.Context;

import com.graduate.SmallSpace.utils.LogUtils;
import com.raizlabs.android.dbflow.config.FlowManager;

public class BaseApp extends Application {

    public static Context mCtx;

    @Override
    public void onCreate() {
        super.onCreate();
        mCtx=getApplicationContext();
        FlowManager.init(this);
        LogUtils.isDebug(true);
    }
}
