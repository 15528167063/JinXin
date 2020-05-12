package com.congda.tianjianxin.ui.activity.mvp.model

import com.congda.baselibrary.mvp.BaseModel
import com.congda.baselibrary.net.TypeOneBaseHttpResult
import com.congda.tianjianxin.bean.BannerBean
import com.congda.tianjianxin.net.repository.RetrofitUtils
import com.congda.tianjianxin.ui.activity.mvp.contract.RecycleDemoContract
import io.reactivex.Observable

class RecycleDemoModel : BaseModel(), RecycleDemoContract.Model{


    override fun getBannList(): Observable<TypeOneBaseHttpResult<MutableList<BannerBean>>> {
        return RetrofitUtils.getHttpService().getBanner()
    }


}