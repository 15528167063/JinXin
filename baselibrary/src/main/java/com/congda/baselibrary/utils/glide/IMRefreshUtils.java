package com.congda.baselibrary.utils.glide;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

public class IMRefreshUtils {
    /**
     * 主要上下滑动的弹性
     */
    public static void initNoRefreshAndMore(RefreshLayout refreshLayout) {
        refreshLayout.setEnableRefresh(false);//是否启用下拉刷新功能
        refreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        refreshLayout.setEnablePureScrollMode(true);//是否启用纯滚动模式
        refreshLayout.setEnableOverScrollBounce(true);//是否启用越界回弹
        refreshLayout.setEnableOverScrollDrag(true);//是否启用越界拖动（仿苹果效果）1.0.4
    }

    /**
     * 主要下拉刷新
     */
    public static void initRefresh(RefreshLayout refreshLayout, OnRefreshListener listener) {
        refreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        refreshLayout.setEnableLoadMore(false);//是否启用上拉加载功能
        refreshLayout.setReboundDuration(100);
        refreshLayout.setOnRefreshListener(listener);
        refreshLayout.setEnableOverScrollDrag(true);
    }

    /**
     * 主要下拉下拉
     */
    public static void initRefreshMore(RefreshLayout refreshLayout, OnRefreshListener listener1, OnLoadMoreListener listener2) {
        refreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        refreshLayout.setEnableLoadMore(true);//是否启用上拉加载功能
        refreshLayout.setReboundDuration(100);
        refreshLayout.setOnRefreshListener(listener1);
        refreshLayout.setOnLoadMoreListener(listener2);
        refreshLayout.setEnableOverScrollDrag(true);
    }
}
