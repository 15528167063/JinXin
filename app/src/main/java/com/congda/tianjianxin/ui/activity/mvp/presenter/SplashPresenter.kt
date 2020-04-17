package com.congda.tianjianxin.ui.activity.mvp.presenter

import SplashAdBean
import com.congda.baselibrary.mvp.BasePresenter
import com.congda.baselibrary.net.BaseHttpResult
import com.congda.baselibrary.net.BaseObserver
import com.congda.baselibrary.rx.RxSchedulers
import com.congda.tianjianxin.ui.activity.mvp.contract.SplashContract
import com.congda.tianjianxin.ui.activity.mvp.model.SplashModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SplashPresenter : BasePresenter<SplashContract.Model, SplashContract.View>() {

    override fun createModel(): SplashContract.Model {
        return SplashModel()
    }

    fun getSplashData() {
        model.getGetAdJson()
//            .compose(RxSchedulers.applySchedulers(getLifecycleProvider<Any>()))

            .subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())

            .subscribe(object : BaseObserver<List<SplashAdBean>>(view) {
                override fun onFailure(code: String, errMsg: String, isNetError: Boolean) {
                    view.showError(errMsg)
                }

                override fun onSuccess(result: BaseHttpResult<List<SplashAdBean>>) {
                    if(result==null){
                        return
                    }
                    view.setSplashData(result)
                }

            })
    }
}


