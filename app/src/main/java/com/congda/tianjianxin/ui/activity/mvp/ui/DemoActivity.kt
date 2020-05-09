package com.congda.tianjianxin.ui.activity.mvp.ui

import android.os.Bundle
import android.view.View
import com.bigkoo.pickerview.view.OptionsPickerView
import com.bigkoo.pickerview.view.TimePickerView
import com.congda.baselibrary.app.IMSConfig
import com.congda.baselibrary.base.BaseMvpActivity
import com.congda.baselibrary.utils.IMSavePhotoUtil
import com.congda.baselibrary.utils.TimePickerUtils
import com.congda.baselibrary.widget.dialog.IMIosCommonDiglog
import com.congda.baselibrary.widget.dialog.IMSheetViewDialog
import com.congda.tianjianxin.R
import com.congda.tianjianxin.ui.activity.mvp.contract.DemoContract
import com.congda.tianjianxin.ui.activity.mvp.presenter.DemoPresenter
import kotlinx.android.synthetic.main.activity_demo.*
import kotlinx.android.synthetic.main.layout_common_title.*
import java.io.File


class DemoActivity : BaseMvpActivity<DemoPresenter>(), DemoContract.View, View.OnClickListener, IMSheetViewDialog.Callback {
    lateinit  var pvTime: TimePickerView
    lateinit  var pvOptions: OptionsPickerView<Any>
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
        //初始化时间选择器
        pvTime= TimePickerUtils.getPickView(this);
        pvOptions= TimePickerUtils.getOptionsPickerView(this);
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
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn1 -> {
                btn1OnClick()
            }
            R.id.btn2 -> {
                btn2OnClick()
            }
            R.id.btn3 -> {
                btn3OnClick()
            }
            R.id.btn4 -> {
                btn4OnClick()
            }
            R.id.btn5 -> {
                btn5OnClick()
            }
            R.id.btn6 -> {
                btn6OnClick()
            }
            R.id.btn7 -> {
                btn7OnClick()
            }
            R.id.btn8 -> {
                btn8OnClick()
            }
            R.id.btn9 -> {
                btn9OnClick()
            }
            R.id.iv1 -> {
                mPresenter.showSheetView(this)
            }
        }
    }

    /**
     * 点击处理
     */
    private fun btn1OnClick() {
        showLoadingDialog()
        btn2.postDelayed({ dissLoadingDialog()},2000)
    }

    private fun btn2OnClick() {
        mPresenter.showSheetView(this)
    }

    private fun btn3OnClick() {
        IMSheetViewDialog().shows(supportFragmentManager,this)
    }

    private fun btn4OnClick() {
        val diglog = IMIosCommonDiglog(this)
        diglog.showCommonDiglog("测试测试 心情好"){
            showToast("测试测试 心情好")
            diglog.dismissCommonDiglog()

        }
    }

    private fun btn5OnClick() {
        mPresenter.showBigImageView(this)
    }

    private fun btn6OnClick() {
        var bundle= Bundle();
        bundle.putString("url","http://baidu.com");
        startActivity(ComWebViewActivity::class.java,bundle,false)
    }

    private fun btn7OnClick() {
        if(!File(IMSConfig.PICTURI_PATH+"app_logo.jpg").exists()){
            IMSavePhotoUtil.saveDrawableIcon(R.mipmap.app_logo,"app_logo")
        }else{
            showMessage("本地已有图片，不保存")
        }
    }
    private fun btn8OnClick() {
        pvTime.show(btn8)
    }
    private fun btn9OnClick() {
        pvOptions.show() //弹出条件选择器
    }
    /**
     * btn2_SheetView内部点击时间
     */
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