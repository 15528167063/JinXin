package com.congda.tianjianxin.widget

import android.content.Context
import com.congda.tianjianxin.R
import com.congda.tianjianxin.adapter.ImageBannerAdapter
import com.youth.banner.Banner
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnBannerListener
import com.youth.banner.listener.OnPageChangeListener
import com.youth.banner.util.BannerUtils

/**
 * @author jinxin
 * 剑之所指，心之所向
 * @date 2020/5/12
 */
object BanneUtils {
    fun setBanner(banner: Banner<Any, ImageBannerAdapter>, context: Context?, imgs: List<String?>?, listener1: OnBannerListener<*>?, listener2: OnPageChangeListener?) {
        banner.setAdapter(ImageBannerAdapter(imgs))
            .setIndicator(CircleIndicator(context))
            .setIndicatorSelectedColorRes(R.color.color_666666)
            .setIndicatorNormalColorRes(R.color.color_f5f5f5)
            .setIndicatorGravity(IndicatorConfig.Direction.CENTER)
            .setIndicatorSpace(BannerUtils.dp2px(10f).toInt())
            .setIndicatorMargins(IndicatorConfig.Margins(BannerUtils.dp2px(5f).toInt()))
            .setIndicatorWidth(20, 20)
            .setOnBannerListener(listener1!!)
            .addOnPageChangeListener(listener2!!)
            .start()
    }
}