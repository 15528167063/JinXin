package com.congda.tianjianxin.ui.fragment.mvp.ui

import com.congda.baselibrary.base.BaseMvpFragment
import com.congda.tianjianxin.R
import com.congda.tianjianxin.ui.fragment.mvp.contract.ListScondContract
import com.congda.tianjianxin.ui.fragment.mvp.contract.SecondContract
import com.congda.tianjianxin.ui.fragment.mvp.presenter.ListScondPresenter
import com.congda.tianjianxin.ui.fragment.mvp.presenter.SecondPresenter

class ListSecondFragment : BaseMvpFragment<ListScondPresenter>(), ListScondContract.View{
    override fun getLayoutId(): Int {
        return R.layout.fragment_recycle_scound
    }

    override fun createPresenter(): ListScondPresenter {
        return   ListScondPresenter()
    }

    override fun initView() {
    }

    override fun initListener() {
    }

    override fun initData() {
    }

    override fun useEventBus(): Boolean {
        return false
    }
}
