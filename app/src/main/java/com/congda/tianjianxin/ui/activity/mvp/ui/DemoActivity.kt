package com.congda.tianjianxin.ui.activity.mvp.ui

import android.os.Bundle
import android.view.View
import com.congda.baselibrary.app.IMSConfig
import com.congda.baselibrary.base.BaseMvpActivity
import com.congda.baselibrary.utils.IMSavePhotoUtil
import com.congda.baselibrary.widget.dialog.IMIosCommonDiglog
import com.congda.baselibrary.widget.dialog.IMSheetViewDialog
import com.congda.tianjianxin.R
import com.congda.tianjianxin.ui.activity.mvp.contract.DemoContract
import com.congda.tianjianxin.ui.activity.mvp.presenter.DemoPresenter
import kotlinx.android.synthetic.main.activity_demo.*
import kotlinx.android.synthetic.main.layout_common_title.*
import java.io.File

class DemoActivity : BaseMvpActivity<DemoPresenter>(), DemoContract.View, View.OnClickListener,
    IMSheetViewDialog.Callback {

    override fun getLayoutId(): Int {
        return R.layout.activity_demo
    }

    override fun createPresenter(): DemoPresenter {
        return DemoPresenter();
    }

    override fun initData() {

    }

    override fun initView() {
        tv_top_title.text="Demo界面"
    }
    override fun initListener() {
        iv1.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn1 -> {
                showLoadingDialog()
                btn2.postDelayed({ dissLoadingDialog()},2000)
            }
            R.id.btn2 -> {
                mPresenter.showSheetView(this)
            }
            R.id.btn3 -> {
                IMSheetViewDialog().shows(supportFragmentManager,this)
            }
            R.id.btn4 -> {
                val diglog = IMIosCommonDiglog(this)
                diglog.showCommonDiglog("测试测试 心情好"){
                    showToast("测试测试 心情好")
                    diglog.dismissCommonDiglog()

                }
            }
            R.id.btn5 -> {
                mPresenter.showBigImageView(this)
            }
            R.id.btn6 -> {
                var bundle= Bundle();
                bundle.putString("url","http://baidu.com");
                startActivity(ComWebViewActivity::class.java,bundle,false)
            }
            R.id.btn7 -> {
                if(!File(IMSConfig.PICTURI_PATH+"app_logo.jpg").exists()){
                    IMSavePhotoUtil.saveDrawableIcon(R.mipmap.app_logo,"app_logo")
                }else{
                    showMessage("本地已有图片，不保存")
                }
            }
            R.id.iv1 -> {
                mPresenter.showSheetView(this)
            }
        }
    }

    override fun onClick(position: Int) {
        when (position) {
            0 -> {
                showToast("0")
            }
            1 -> {
                showToast("1")
            }
            2 -> {
                showToast("2")
            }
        }
    }
    }