package com.congda.tianjianxin.ui.activity.mvp.presenter;


import com.congda.baselibrary.mvp.BasePresenter;
import com.congda.tianjianxin.ui.activity.mvp.contract.SplashContract;
import com.congda.tianjianxin.ui.activity.mvp.model.SplashModel;

public class SplashPresenter extends BasePresenter<SplashContract.Model,SplashContract.View> {

    @Override
    protected SplashContract.Model createModel() {
        return new SplashModel();
    }




}
