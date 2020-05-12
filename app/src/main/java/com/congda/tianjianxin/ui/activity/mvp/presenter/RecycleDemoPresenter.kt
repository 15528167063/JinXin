package com.congda.tianjianxin.ui.activity.mvp.presenter

import com.congda.baselibrary.mvp.BasePresenter
import com.congda.baselibrary.net.TypeOneBaseHttpResult
import com.congda.baselibrary.net.TypeOneBaseObserve
import com.congda.baselibrary.rx.RxSchedulers
import com.congda.tianjianxin.bean.BannerBean
import com.congda.tianjianxin.ui.activity.mvp.contract.RecycleDemoContract
import com.congda.tianjianxin.ui.activity.mvp.model.RecycleDemoModel
import com.trello.rxlifecycle2.android.ActivityEvent

class RecycleDemoPresenter : BasePresenter<RecycleDemoContract.Model, RecycleDemoContract.View>(){

    override fun createModel(): RecycleDemoContract.Model {
        return RecycleDemoModel()
    }

    /**
     * 获取banner
     */
    fun getBannerData() {
        model.getBannList()
            .compose(RxSchedulers.applySchedulers(getLifecycleProvider<ActivityEvent>()))
            .subscribe(object : TypeOneBaseObserve<MutableList<BannerBean>>(view,false) {
                override fun onFailure(code: String, errMsg: String, isNetError: Boolean) {
                    view.showToast(errMsg)
                }

                override fun onSuccess(baseHttpResult: TypeOneBaseHttpResult<MutableList<BannerBean>>) {
                    if(baseHttpResult==null){
                        return
                    }
                    view.hanedBannerSucces(baseHttpResult)
                }
            })
    }

}



