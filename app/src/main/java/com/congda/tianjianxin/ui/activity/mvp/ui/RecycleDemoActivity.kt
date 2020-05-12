package com.congda.tianjianxin.ui.activity.mvp.ui

import android.view.LayoutInflater
import android.view.View
import com.congda.baselibrary.base.BaseMvpActivity
import com.congda.baselibrary.net.TypeOneBaseHttpResult
import com.congda.baselibrary.utils.glide.IMRefreshUtils
import com.congda.tianjianxin.R
import com.congda.tianjianxin.adapter.ImageBannerAdapter
import com.congda.tianjianxin.adapter.RecycleDemodapter
import com.congda.tianjianxin.bean.BannerBean
import com.congda.tianjianxin.ui.activity.mvp.contract.RecycleDemoContract
import com.congda.tianjianxin.ui.activity.mvp.presenter.RecycleDemoPresenter
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.youth.banner.Banner
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnBannerListener
import com.youth.banner.listener.OnPageChangeListener
import com.youth.banner.util.BannerUtils
import kotlinx.android.synthetic.main.activity_recycle.*


class RecycleDemoActivity : BaseMvpActivity<RecycleDemoPresenter>(), RecycleDemoContract.View, OnRefreshListener, OnBannerListener<Any>, OnPageChangeListener {
    lateinit var banner :Banner<Any,ImageBannerAdapter>;
    override fun getLayoutId(): Int {
        return R.layout.activity_recycle
    }

    override fun createPresenter(): RecycleDemoPresenter {
        return RecycleDemoPresenter();
    }

    override fun initView() {
        IMRefreshUtils.initRefresh(refreshLayout,this)
        val view: View = LayoutInflater.from(this).inflate(R.layout.layout_banner, null)
        banner = view.findViewById(R.id.banner);
        ll_root.addView(view)
    }

    override fun initData() {
        common_top.setTopTitle("列表")
        mPresenter.getBannerData()
        recyclerView.adapter=RecycleDemodapter(this,R.layout.layout_common_title,null)
    }

    /**
     * 上拉刷新
     */
    override fun onRefresh(refreshLayout: RefreshLayout) {

    }

    override fun hanedBannerSucces(bean: TypeOneBaseHttpResult<MutableList<BannerBean>>) {
        if(bean.data==null){
            return
        }
        val imgs: MutableList<String> = mutableListOf()
        for (i in bean.data.indices) {
            imgs.add(bean.data.get(i).imagePath)
        }

        banner.setAdapter(ImageBannerAdapter(imgs) )
        banner.indicator = CircleIndicator(this)
        banner.setIndicatorSelectedColorRes(R.color.colorPrimary)
        banner.setIndicatorNormalColorRes(R.color.color_666666)
        banner.setIndicatorGravity(IndicatorConfig.Direction.LEFT)
        banner.setIndicatorSpace(BannerUtils.dp2px(20f).toInt())
        banner.setIndicatorMargins(IndicatorConfig.Margins(BannerUtils.dp2px(10f).toInt()))
        banner.setIndicatorWidth(10, 20)
        banner.setOnBannerListener(this)
        banner.addOnPageChangeListener(this)
        banner.start()

    }

    override fun onResume() {
        super.onResume()
        banner.start();
    }

    override fun onPause() {
        super.onPause()
        banner.stop();
    }


    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
    }

    override fun OnBannerClick(data: Any?, position: Int) {
    }


}