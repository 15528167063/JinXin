package com.congda.baselibrary.app;

import android.content.Context;

/**
 * @author jinxin
 * 剑之所指，心之所向
 * @date 2019/8/11
 */
public class BaseManager {

    private Context context;
    private static BaseManager instance;

    public static BaseManager getInstance() {
        if (instance == null) {
            throw new RuntimeException("必须先调用静态方法init(Context context)");
        }
        return instance;
    }

    public static void init(Context context) {
        if (context == null) {
            throw new NullPointerException("context不能为空");
        }
        if(instance == null)
            synchronized (BaseManager.class) {
                if(instance == null)
                    instance = new BaseManager(context.getApplicationContext());
            }
    }

    /**
     * 初始化module里面的部分属性，并且开启认证身份和开启接受消息的服务
     */
    public BaseManager(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

}
