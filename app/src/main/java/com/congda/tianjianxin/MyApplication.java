package com.congda.tianjianxin;

import android.content.Context;

import com.congda.baselibrary.app.BaseApplication;

public class MyApplication extends BaseApplication {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        this.context=getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}