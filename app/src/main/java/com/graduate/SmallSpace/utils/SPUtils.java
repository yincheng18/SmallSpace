package com.graduate.SmallSpace.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.graduate.SmallSpace.base.BaseApp;

public class SPUtils {

    private static SharedPreferences SP;

    /**
     * 清空数据
     *
     * @return true 成功
     */
    public static boolean clear(String key) {
        SP = BaseApp.mCtx.getSharedPreferences(BaseApp.mCtx.getPackageName(), Context.MODE_PRIVATE);
        return SP.edit().remove(key).commit();
    }

    /**
     * 保存数据
     *
     * @param key   key
     * @param value value
     */
    public static boolean put(String key, String value) {
        SP = BaseApp.mCtx.getSharedPreferences(BaseApp.mCtx.getPackageName(), Context.MODE_PRIVATE);
        return SP.edit().putString(key, value).commit();
    }

    /**
     * 获取保存的数据
     *
     * @param key      键
     * @param defValue 默认返回的value
     * @return value
     */
    public static String get(String key, String defValue) {
        SP = BaseApp.mCtx.getSharedPreferences(BaseApp.mCtx.getPackageName(), Context.MODE_PRIVATE);
        return SP.getString(key, defValue);
    }

    /**
     * 保存数据
     *
     * @param key   key
     * @param value value
     */
    public static boolean put(String key, boolean value) {
        SP = BaseApp.mCtx.getSharedPreferences(BaseApp.mCtx.getPackageName(), Context.MODE_PRIVATE);
        return SP.edit().putBoolean(key, value).commit();
    }

    /**
     * 获取保存的数据
     *
     * @param key      键
     * @param defValue 默认返回的value
     * @return value
     */
    public static boolean get(String key, boolean defValue) {
        SP = BaseApp.mCtx.getSharedPreferences(BaseApp.mCtx.getPackageName(), Context.MODE_PRIVATE);
        return SP.getBoolean(key, defValue);
    }

    /**
     * 保存数据
     *
     * @param key   key
     * @param value value
     */
    public static boolean put(String key, int value) {
        SP = BaseApp.mCtx.getSharedPreferences(BaseApp.mCtx.getPackageName(), Context.MODE_PRIVATE);
        return SP.edit().putInt(key, value).commit();
    }

    /**
     * 获取保存的数据
     *
     * @param key      键
     * @param defValue 默认返回的value
     * @return value
     */
    public static int get(String key, int defValue) {
        SP = BaseApp.mCtx.getSharedPreferences(BaseApp.mCtx.getPackageName(), Context.MODE_PRIVATE);
        return SP.getInt(key, defValue);
    }

    /**
     * 保存数据
     *
     * @param key   key
     * @param value value
     */
    public static boolean put(String key, long value) {
        SP = BaseApp.mCtx.getSharedPreferences(BaseApp.mCtx.getPackageName(), Context.MODE_PRIVATE);
        return SP.edit().putLong(key, value).commit();
    }

    /**
     * 获取保存的数据
     *
     * @param key      键
     * @param defValue 默认返回的value
     * @return value
     */
    public static long get(String key, long defValue) {
        SP = BaseApp.mCtx.getSharedPreferences(BaseApp.mCtx.getPackageName(), Context.MODE_PRIVATE);
        return SP.getLong(key, defValue);
    }

    /**
     * 清除数据
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(BaseApp.mCtx.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
}
