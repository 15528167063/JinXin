package com.congda.tianjianxin.ui.fragment.mvp.presenter

import com.congda.baselibrary.mvp.BasePresenter
import com.congda.tianjianxin.ui.fragment.mvp.contract.ListFirstContract
import com.congda.tianjianxin.ui.fragment.mvp.contract.ListScondContract
import com.congda.tianjianxin.ui.fragment.mvp.contract.SecondContract
import com.congda.tianjianxin.ui.fragment.mvp.model.ListFirstModel
import com.congda.tianjianxin.ui.fragment.mvp.model.ListScondModel
import com.congda.tianjianxin.ui.fragment.mvp.model.SecondModel

class ListScondPresenter : BasePresenter<ListScondContract.Model, ListScondContract.View>(){

    override fun createModel(): ListScondContract.Model {
        return ListScondModel()
    }
}


