package com.congda.tianjianxin.ui.activity.mvp.presenter

import com.congda.baselibrary.mvp.BasePresenter
import com.congda.tianjianxin.ui.activity.mvp.contract.RecycleDemoContract
import com.congda.tianjianxin.ui.activity.mvp.model.RecycleDemoModel

class RecycleDemoPresenter : BasePresenter<RecycleDemoContract.Model, RecycleDemoContract.View>(){

    override fun createModel(): RecycleDemoContract.Model {
        return RecycleDemoModel()
    }

}


