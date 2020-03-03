package com.graduate.SmallSpace.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class CacheUtil {

    public static <T> void setListData(Context context, List<T> list, String name) {
        File file = context.getCacheDir();
        File Cache = null;
        Cache = new File(file, name);
        if (Cache.exists()) {
            Cache.delete();
        }
        try {
            ObjectOutputStream outputStream =
                    new ObjectOutputStream(new FileOutputStream(Cache));
            outputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取list数据
     *
     * @param context
     * @param name
     * @param <T>
     * @return
     */
    public static <T> List<T> getListData(Context context, String name) {
        File file = context.getCacheDir();
        File cache;
        List<T> list = null;
        cache = new File(file, name);
        if (!cache.exists()) {
            return null;
        }
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(cache));
            list = (List<T>) inputStream.readObject();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 保存Javabean
     *
     * @param context
     * @param data
     * @param name
     * @param <T>
     */
    public static <T> void setData(Context context, T data, String name) {
        File file = context.getCacheDir();
        File Cache = null;
        Cache = new File(file, name);
        if (Cache.exists()) {
            Cache.delete();
        }
        try {
            ObjectOutputStream outputStream =
                    new ObjectOutputStream(new FileOutputStream(Cache));
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T getData(Context context, String name) {
        File file = context.getCacheDir();
        File cache;
        T data = null;
        cache = new File(file, name);
        if (!cache.exists()) {
            return null;
        }
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(cache));
            data = (T) inputStream.readObject();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 清除缓存
     *
     * @param context
     */
    public static void clearAllCache(Context context) {
        deleteDir(context.getCacheDir());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            deleteDir(context.getExternalCacheDir());
        }
    }

    private static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
