package com.congda.tianjianxin.ui.activity.mvp.ui

import com.congda.baselibrary.base.BaseMvpActivity
import com.congda.tianjianxin.R
import com.congda.tianjianxin.ui.activity.mvp.contract.RecycleDemoContract
import com.congda.tianjianxin.ui.activity.mvp.presenter.RecycleDemoPresenter
import kotlinx.android.synthetic.main.activity_recycle.*

class RecycleDemoActivity : BaseMvpActivity<RecycleDemoPresenter>(), RecycleDemoContract.View{

    override fun getLayoutId(): Int {
        return R.layout.activity_recycle
    }

    override fun createPresenter(): RecycleDemoPresenter {
        return RecycleDemoPresenter();
    }

    override fun initData() {
        common_top.setTopTitle("列表")
    }


}