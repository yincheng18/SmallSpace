package com.graduate.SmallSpace.utils;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.graduate.SmallSpace.R;
import com.graduate.SmallSpace.base.BaseApp;

public class ToastUtil {

    private static Toast toast;//实现不管我们触发多少次Toast调用，都只会持续一次Toast显示的时长

    /**
     * 短时间显示Toast【居下】
     * @param msg 显示的内容-字符串*/
    public static void showShortToast(String msg) {
        if(BaseApp.mCtx != null){
            if (toast == null) {
                toast = Toast.makeText(BaseApp.mCtx, msg, Toast.LENGTH_SHORT);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }
    /**
     * 短时间显示Toast【居中】
     * @param msg 显示的内容-字符串*/
    public static void showShortToastCenter(String msg){
        if(BaseApp.mCtx  != null) {
            if (toast == null) {
                toast = Toast.makeText(BaseApp.mCtx , msg, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }

    /**
     * 短时间显示Toast【居上】
     * @param msg 显示的内容-字符串*/
    public static void showShortToastTop(String msg){
        if(BaseApp.mCtx  != null) {
            if (toast == null) {
                toast = Toast.makeText(BaseApp.mCtx , msg, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }

    /**
     * 长时间显示Toast【居下】
     * @param msg 显示的内容-字符串*/
    public static void showLongToast(String msg) {
        if(BaseApp.mCtx  != null) {
            if (toast == null) {
                toast = Toast.makeText(BaseApp.mCtx , msg, Toast.LENGTH_LONG);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }
    /**
     * 长时间显示Toast【居中】
     * @param msg 显示的内容-字符串*/
    public static void showLongToastCenter(String msg){
        if(BaseApp.mCtx  != null) {
            if (toast == null) {
                toast = Toast.makeText(BaseApp.mCtx , msg, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }
    /**
     * 长时间显示Toast【居上】
     * @param msg 显示的内容-字符串*/
    public static void showLongToastTop(String msg){
        if(BaseApp.mCtx  != null) {
            if (toast == null) {
                toast = Toast.makeText(BaseApp.mCtx , msg, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 0, 0);
            } else {
                toast.setText(msg);
            }
            toast.show();
        }
    }
}
