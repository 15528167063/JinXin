package com.congda.tianjianxin.ui.activity.mvp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.congda.baselibrary.base.BaseMvpActivity
import com.congda.baselibrary.net.TypeOneBaseHttpResult
import com.congda.baselibrary.utils.glide.IMRefreshUtils
import com.congda.tianjianxin.R
import com.congda.tianjianxin.adapter.ImageBannerAdapter
import com.congda.tianjianxin.adapter.RecycleDemodapter
import com.congda.tianjianxin.bean.BannerBean
import com.congda.tianjianxin.ui.activity.mvp.contract.RecycleDemoContract
import com.congda.tianjianxin.ui.activity.mvp.presenter.RecycleDemoPresenter
import com.congda.tianjianxin.widget.BanneUtils
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.youth.banner.Banner
import com.youth.banner.listener.OnBannerListener
import com.youth.banner.listener.OnPageChangeListener
import kotlinx.android.synthetic.main.activity_recycle.*


class RecycleDemoActivity : BaseMvpActivity<RecycleDemoPresenter>(), RecycleDemoContract.View, OnRefreshListener, OnBannerListener<Any>,
    ViewPager.OnPageChangeListener, OnPageChangeListener, OnLoadMoreListener, OnItemClickListener {
    lateinit var banner :Banner<Any,ImageBannerAdapter>
    lateinit var adapter:RecycleDemodapter
    private var datas: MutableList<String> = mutableListOf()
    private var bannerdatas: MutableList<BannerBean> = mutableListOf()
    override fun getLayoutId(): Int {
        return R.layout.activity_recycle
    }

    override fun createPresenter(): RecycleDemoPresenter {
        return RecycleDemoPresenter();
    }

    override fun initView() {
        IMRefreshUtils.initRefreshMore(refreshLayout,this,this)
        IMRefreshUtils.initVRecycle(this,recyclerView)
        adapter = RecycleDemodapter()
        adapter.setOnItemClickListener(this)
        recyclerView.adapter=adapter
        adapterAddView()
    }

    /**
     * 加入头部和空布局
     */
    private fun adapterAddView() {
        val viewHead: View = LayoutInflater.from(this).inflate(R.layout.layout_banner, null)
        val viewEmept: View = LayoutInflater.from(this).inflate(R.layout.layout_recycle_empty, null)
        banner = viewHead.findViewById(R.id.banner);
        adapter.addHeaderView(viewHead)
        adapter.setEmptyView(viewEmept)
    }

    override fun initData() {
        common_top.setTopTitle("列表")
        mPresenter.getBannerData()
        mPresenter.getListData()
    }

    /**
     * 上拉刷新
     */
    override fun onRefresh(refreshLayout: RefreshLayout) {
        refreshLayout.finishRefresh() //传入false表示刷新失败

    }
    override fun onLoadMore(refreshLayout: RefreshLayout) {
        refreshLayout.finishLoadMore()
    }

    /**
     * 处理banner数据
     */
    override fun hanedBannerData(bean: TypeOneBaseHttpResult<MutableList<BannerBean>>) {
        bannerdatas=bean.data
        val imgs: MutableList<String> = mutableListOf()
        for (i in bean.data.indices) {
            imgs.add(bean.data[i].imagePath)
        }
        BanneUtils.setBanner(banner,this,imgs,this,this)
    }

    override fun hanedListData(bean: MutableList<String>) {
        datas=bean
        adapter.setNewData(bean)
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
        var bundle=Bundle()
        bundle.putString("url", bannerdatas[position].url)
        startActivity(ComWebViewActivity::class.java,bundle,false)
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        showMessage(datas[position])
    }


}