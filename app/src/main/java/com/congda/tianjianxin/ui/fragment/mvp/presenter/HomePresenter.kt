package com.congda.tianjianxin.ui.fragment.mvp.presenter

import SplashAdBean
import android.content.Context
import android.content.DialogInterface
import com.congda.baselibrary.mvp.BasePresenter
import com.congda.baselibrary.net.BaseHttpResult
import com.congda.baselibrary.net.BaseObserver
import com.congda.baselibrary.rx.RxSchedulers
import com.congda.baselibrary.utils.glide.IMChooseUtils
import com.congda.baselibrary.widget.dialog.IMSheetDialog
import com.congda.tianjianxin.ui.activity.mvp.contract.SplashContract
import com.congda.tianjianxin.ui.activity.mvp.model.SplashModel
import com.congda.tianjianxin.ui.fragment.mvp.contract.HomeContract
import com.congda.tianjianxin.ui.fragment.mvp.model.HomeModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_splash.*

class HomePresenter : BasePresenter<HomeContract.Model, HomeContract.View>() {

    override fun createModel(): HomeContract.Model {
        return HomeModel()
    }
    fun showSheetView(context: Context) {
        IMSheetDialog.Builder(context)
            .addSheet("拍照", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            .addSheet("选择图片", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
                IMChooseUtils.choosePhotoForResult(context,10001,9)
            })
            .create().show()
    }
}


