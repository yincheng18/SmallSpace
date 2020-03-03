package com.graduate.SmallSpace.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**
     * 字符串转换成日期
     * @param str
     * @return date
     */
    public static String StrToMDate(String str) {

        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        long lt = new Long(str);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 时间戳转换成时间
     * @param s 传入的时间戳
     * @return 返回格式化时间
     */
    public static String timeStampToTime(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        String res = simpleDateFormat.format(date);
        return res;
    }
    /**
     * 时间戳转换成时间
     * @param s 传入的时间戳
     * @return 返回格式化时间
     */
    public static String timeStampToTime2(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        String res = simpleDateFormat.format(date);
        return res;
    }
    /**
     * 时间戳转换成时间
     * @param s 传入的时间戳
     * @return 返回格式化时间
     */
    public static String timeStampToTime3(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM");
        long lt = new Long(s);
        Date date = new Date(lt);
        String res = simpleDateFormat.format(date);
        return res;
    }
    /**
     * 时间戳转换成时间
     * @param s 传入的时间戳
     * @return 返回格式化时间
     */
    public static String timeStampToTime4(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        long lt = new Long(s);
        Date date = new Date(lt);
        String res = simpleDateFormat.format(date);
        return res;
    }
}
