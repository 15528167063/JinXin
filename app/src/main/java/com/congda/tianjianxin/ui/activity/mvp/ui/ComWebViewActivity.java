package com.congda.tianjianxin.ui.activity.mvp.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.congda.baselibrary.base.BaseMvpActivity;
import com.congda.tianjianxin.R;
import com.congda.tianjianxin.ui.activity.mvp.contract.ComWebViewContract;
import com.congda.tianjianxin.ui.activity.mvp.presenter.ComWebViewPresenter;

import butterknife.BindView;

public class ComWebViewActivity extends BaseMvpActivity<ComWebViewPresenter> implements ComWebViewContract.View, View.OnClickListener {
    @BindView(R.id.ll_root)
    LinearLayout mllRoot;
    @BindView(R.id.re_top_finish)
    RelativeLayout mRlFinish;
    @BindView(R.id.tv_top_title)
    TextView mTvTitle;
    @Override
    protected ComWebViewPresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_common_web;
    }

    @Override
    protected void initData() {

    }
    @Override
    protected void initListener() {
        mRlFinish.setOnClickListener(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.re_top_finish :
                finish();
                break;
        }
    }
}
