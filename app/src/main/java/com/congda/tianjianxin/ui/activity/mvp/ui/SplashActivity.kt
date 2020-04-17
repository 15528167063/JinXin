package com.congda.tianjianxin.ui.activity.mvp.ui

import android.content.Intent
import com.congda.baselibrary.app.IMSConfig
import com.congda.baselibrary.base.BaseMvpActivity
import com.congda.baselibrary.utils.IMCutTimeDownView
import com.congda.baselibrary.utils.IMPreferenceUtil
import com.congda.tianjianxin.R
import com.congda.tianjianxin.ui.activity.GuideActivity
import com.congda.tianjianxin.ui.activity.MainActivity
import com.congda.tianjianxin.ui.activity.mvp.presenter.SplashPresenter
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseMvpActivity<SplashPresenter>(), IMCutTimeDownView.OnFinishListener {

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun createPresenter(): SplashPresenter {
        return SplashPresenter();
    }

    override fun initData() {
        if(isFirstOpen()){
            return
        }
        skipTv.setOnFinishListener(this)
        skipTv.setTotalTime(3000)
    }

    /**
     * 判断是不是第一次进去app
     */
    private fun isFirstOpen(): Boolean {
        if (IMPreferenceUtil.getPreference_Boolean(IMSConfig.FIRST_OPEN, true)) {
            IMPreferenceUtil.setPreference_Boolean(IMSConfig.FIRST_OPEN, false)
            startActivity(GuideActivity::class.java,true)
            return  true
        }
        return false
    }

    override fun setOnFinishListener() {
        startActivity(MainActivity::class.java,true)
    }
}