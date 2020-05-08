package com.congda.tianjianxin.ui.fragment.mvp.ui

import android.os.Bundle
import android.view.View
import com.congda.baselibrary.app.IMSConfig
import com.congda.baselibrary.base.BaseMvpFragment
import com.congda.baselibrary.utils.IMSavePhotoUtil
import com.congda.baselibrary.utils.glide.IMImageLoadUtil
import com.congda.baselibrary.widget.dialog.IMIosCommonDiglog
import com.congda.baselibrary.widget.dialog.IMSheetViewDialog
import com.congda.tianjianxin.R
import com.congda.tianjianxin.ui.activity.ComWebActivity
import com.congda.tianjianxin.ui.activity.mvp.ui.ComWebViewActivity
import com.congda.tianjianxin.ui.activity.mvp.ui.DemoActivity
import com.congda.tianjianxin.ui.fragment.mvp.contract.FirstContract
import com.congda.tianjianxin.ui.fragment.mvp.presenter.FirstPresenter
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.layout_common_title.*
import java.io.File

class FirstFragment : BaseMvpFragment<FirstPresenter>(), View.OnClickListener,FirstContract.View{
    override fun getLayoutId(): Int {
        return R.layout.fragment_first
    }

    override fun createPresenter(): FirstPresenter {
        return  FirstPresenter()
    }

    override fun initView() {
        tv_top_title.text="首页"
    }

    override fun initListener() {
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
    }

    override fun initData() {
    }

    override fun useEventBus(): Boolean {
        return false
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn1 -> {
                startActivity(DemoActivity::class.java,false)
            }
            R.id.btn2 -> {
                activity?.let { mPresenter.showBigImageView(it) }
            }
            R.id.btn3 -> {
                var bundle=Bundle();
                bundle.putString("url","http://baidu.com");
                startActivity(ComWebViewActivity::class.java,bundle,false)
            }
        }
    }
}
