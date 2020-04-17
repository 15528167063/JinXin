package com.congda.baselibrary.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.congda.baselibrary.mvp.BasePresenter;
import com.congda.baselibrary.mvp.IView;

/**
 * @author xuhao
 * @date 2018/6/9 17:12
 * @desc 基类 BaseMvpActivity
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements IView {
    protected T mPresenter;
    protected abstract T createPresenter();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void showLoading() {
        showLoadingDialog();
    }

    @Override
    public void hideLoading() {
        dissLoadingDialog();
    }
    @Override
    public void showError(String msg) {
        showToast(msg);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {

    }
}
