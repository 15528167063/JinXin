package com.congda.tianjianxin.ui.activity.mvp.contract

import com.congda.baselibrary.mvp.IModel
import com.congda.baselibrary.mvp.IView
import com.congda.baselibrary.net.TypeOneBaseHttpResult
import com.congda.tianjianxin.bean.BannerBean
import io.reactivex.Observable

interface RecycleDemoContract {
    interface View : IView{
        fun hanedBannerSucces(baseHttpResult: TypeOneBaseHttpResult<MutableList<BannerBean>>)
    }

    interface Model : IModel{
        fun  getBannList(): Observable<TypeOneBaseHttpResult<MutableList<BannerBean>>>
    }
}