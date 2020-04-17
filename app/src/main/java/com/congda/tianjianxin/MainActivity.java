package com.congda.tianjianxin;


import android.app.Activity;
import android.view.View;

import com.congda.baselibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import cc.shinichi.library.ImagePreview;
import cc.shinichi.library.bean.ImageInfo;
import cc.shinichi.library.view.listener.OnBigImageLongClickListener;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {

    }
    @Override
    protected void initListener() {
    }
    @Override
    protected void initData() {
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ImageInfo>imageInfoList=new ArrayList<>();
                ImageInfo imageInfo =new ImageInfo();
                imageInfo.setOriginUrl("http://47.244.137.17:9050/group1/M00/00/11/rB8eHF6Byd2AWUmzAAECP63pVyA18.jpeg");
                imageInfo.setThumbnailUrl("http://47.244.137.17:9050/group1/M00/00/11/rB8eHF6Byd2ATSIHAAAVM3MJdYM67.jpeg");
                imageInfoList.add(0, imageInfo);

                ImageInfo imageInfo1 =new ImageInfo();
                imageInfo1.setOriginUrl("http://47.244.137.17:9050/group1/M00/00/11/rB8eHF6Byd2ALyMTAAD328O0VTE12.jpeg");
                imageInfo1.setThumbnailUrl("http://47.244.137.17:9050/group1/M00/00/11/rB8eHF6Byd2AFbFgAAAPzOcoRi469.jpeg");
                imageInfoList.add(0, imageInfo1);

                ImageInfo imageInfo2 =new ImageInfo();
                imageInfo2.setOriginUrl("http://47.244.137.17:9050/group1/M00/00/11/rB8eHF6Byd2ARDhPAADDpOED4bk42.jpeg");
                imageInfo2.setThumbnailUrl("http://47.244.137.17:9050/group1/M00/00/11/rB8eHF6Byd2ARDACAAARD8fqdEI88.jpeg");
                imageInfoList.add(0, imageInfo2);

                ImageInfo imageInfo3 =new ImageInfo();
                imageInfo3.setOriginUrl("http://47.244.137.17:9050/group1/M00/00/11/rB8eHF6Byd2AJ1yQAADNV_mcurE76.jpeg");
                imageInfo3.setThumbnailUrl("http://47.244.137.17:9050/group1/M00/00/11/rB8eHF6Byd2ASeHlAAAPFoY5eMs66.jpeg");
                imageInfoList.add(0, imageInfo3);

                ImageInfo imageInfo4 =new ImageInfo();
                imageInfo4.setOriginUrl("http://47.244.137.17:9050/group1/M00/00/11/rB8eHF6Byd2AZgfmAAFnc0C7xH872.jpeg");
                imageInfo4.setThumbnailUrl("http://47.244.137.17:9050/group1/M00/00/11/rB8eHF6Byd2AHwWyAAAUdyLUDpg70.jpeg");
                imageInfoList.add(0, imageInfo4);

                ImagePreview.getInstance()
                        // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                        .setContext(MainActivity.this)

                        .setIndex(2)

                        .setLoadStrategy(ImagePreview.LoadStrategy.Default)
                        // 缩放动画时长，单位ms
                        .setZoomTransitionDuration(1000)
                        // 设置是否显示顶部的指示器（1/9）默认显示
                        .setShowIndicator(true)
                        // 长按回调(保存图片)
                        .setBigImageLongClickListener(new OnBigImageLongClickListener() {
                            @Override public boolean onLongClick(Activity activity, View view, int position) {
                                //              IMSavePictureUtils.downloadPicture(activity, datas.get(position).getOriginUrl());
                                return true;
                            }
                        })
                        .setImageInfoList(imageInfoList)
                        //设置是否显示下载按钮
                        .setShowDownButton(false)
                        // 开启预览
                        .start();

            }
        });
    }
}
