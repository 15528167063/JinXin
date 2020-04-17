package com.congda.baselibrary.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.congda.baselibrary.mvp.BasePresenter;
import com.congda.baselibrary.mvp.IView;


public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements IView {
    /**
     * 将代理类通用行为抽出来
     */
    protected T mPresenter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPresenter =createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract T createPresenter();

}
