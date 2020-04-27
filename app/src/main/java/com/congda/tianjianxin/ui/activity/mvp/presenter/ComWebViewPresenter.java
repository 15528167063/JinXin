package com.congda.tianjianxin.ui.activity.mvp.presenter;


import com.congda.baselibrary.mvp.BasePresenter;
import com.congda.tianjianxin.ui.activity.mvp.contract.ComWebViewContract;
import com.congda.tianjianxin.ui.activity.mvp.model.ComWebViewModel;

/**
 * @author xuhao
 * @date 2018/6/12 22:57
 * @desc
 */
public class ComWebViewPresenter extends BasePresenter<ComWebViewContract.Model,ComWebViewContract.View> {
    @Override
    protected ComWebViewContract.Model createModel() {
        return new ComWebViewModel();
    }


    public void requestData(){
//        getModel().getGankData()
//                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
//                .subscribe(new BaseObserver<Object>(getView()) {
//                    @Override
//                    public void onSuccess(BaseHttpResult<Object> result) {
//                        if (result != null) {
//                            getView().showData(result.toString());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(String code, String errMsg, boolean isNetError) {
//                        getView().showError(errMsg);
//                    }
//
//                });
    }
}
