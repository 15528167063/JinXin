package com.congda.tianjianxin.ui.fragment.mvp.ui

import android.content.DialogInterface
import android.view.View
import com.congda.baselibrary.base.BaseFragment
import com.congda.baselibrary.base.BaseMvpFragment
import com.congda.baselibrary.utils.glide.IMChooseUtils
import com.congda.baselibrary.utils.glide.IMImageLoadUtil
import com.congda.baselibrary.widget.dialog.IMIosCommonDiglog
import com.congda.baselibrary.widget.dialog.IMSheetDialog
import com.congda.baselibrary.widget.dialog.IMSheetViewDialog
import com.congda.tianjianxin.R
import com.congda.tianjianxin.ui.fragment.mvp.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseMvpFragment<HomePresenter>(), View.OnClickListener, IMSheetViewDialog.Callback {
    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun createPresenter(): HomePresenter {
        return  HomePresenter()
    }

    override fun initView() {
    }

    override fun initListener() {
        iv1.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
    }

    override fun initData() {
        activity?.let { IMImageLoadUtil.CommonImageLineCircleLoad(it, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1585564389613&di=59413e2550ba181876cd2aab46d0ecab&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fd62a6059252dd42a1c362a29033b5bb5c9eab870.jpg", iv1) }
    }

    override fun useEventBus(): Boolean {
        return false
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn1 -> {
                showLoadingDialog()
                btn2.postDelayed({ dissLoadingDialog()},2000)
            }
            R.id.btn2 -> {
                activity?.let { mPresenter.showSheetView(it) }
            }
            R.id.btn3 -> {
                IMSheetViewDialog().shows(activity?.supportFragmentManager,this)
            }
            R.id.btn4 -> {
                val diglog = IMIosCommonDiglog(activity)
                diglog.showCommonDiglog("测试测试 心情好"){
                    showToast("测试测试 心情好")
                    diglog.dismissCommonDiglog()
                }
            }
            R.id.btn5 -> {
                activity?.let { mPresenter.showBigImageView(it) }
            }
        }
    }




    override fun onClick(position: Int) {
        when(position){
            0->{
                showToast("0")
            }
            1->{
                showToast("1")
            }
            2->{
                showToast("2")
            }
        }
    }


}
