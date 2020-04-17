package com.congda.tianjianxin.net.api

import SplashAdBean
import VersonBeanData
import com.congda.baselibrary.net.BaseHttpResult
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    /**
     * 检查当前版本
     */
    @POST("commons/check-update")
    fun getVersonBean(@Body body: RequestBody): Observable<BaseHttpResult<VersonBeanData>>

    /**
     * 获取广告
     */
    @POST("front-ads/get")
    fun httpGetAdJson(): Observable<BaseHttpResult<List<SplashAdBean>>>
}