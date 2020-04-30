package com.congda.tianjianxin.ui.activity.mvp.ui;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.congda.baselibrary.base.BaseMvpActivity;
import com.congda.baselibrary.utils.IMStatusBarUtil;
import com.congda.tianjianxin.R;
import com.congda.tianjianxin.ui.activity.mvp.contract.ComWebViewContract;
import com.congda.tianjianxin.ui.activity.mvp.presenter.ComWebViewPresenter;
import com.congda.tianjianxin.utils.AndroidInterface;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;


public class ComWebViewActivity extends BaseMvpActivity<ComWebViewPresenter> implements ComWebViewContract.View, View.OnClickListener {
    LinearLayout mllRoot;
    RelativeLayout mRlFinish;
    TextView mTvTitle;
    private String url;
    private String title;
    private AgentWeb mAgentWeb;
    private WebView webView;
    private AndroidInterface androidInterface;
    @Override
    protected ComWebViewPresenter createPresenter() {
        return null;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_common_web;
    }

    @Override
    protected void initView() {
        mllRoot=findViewById(R.id.ll_root);
        mRlFinish=findViewById(R.id.re_top_finish);
        mTvTitle=findViewById(R.id.tv_top_title);

        url="file:///android_asset/index.html";
        title=getIntent().getStringExtra("title");

//        if(!TextUtils.isEmpty(title)){
//            mRlTop.setVisibility(View.VISIBLE);
//            mTopTitle.setText(title);
//        }else{
//            mRlTop.setVisibility(View.VISIBLE);
//        }
    }


    @Override
    public void initStatusBar() {
        IMStatusBarUtil.setTranslucent(this, 0);
        IMStatusBarUtil.setLightMode(this);
    }
    @Override
    protected void initListener() {
        mRlFinish.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mllRoot, new LinearLayout.LayoutParams(-1, -1))
                .closeIndicator()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .createAgentWeb()
                .ready()
                .go(url);

        webView = mAgentWeb.getWebCreator().getWebView();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setAppCacheEnabled(true);
        // 设置允许JS弹窗
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        androidInterface = new AndroidInterface(mAgentWeb, this);
        mAgentWeb.getJsInterfaceHolder().addJavaObject("android", androidInterface);

    }


    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Log.e("----","shouldOverrideUrlLoading:"+request.getUrl());
            return false;

        }

        //页面加载开始
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.e("----","onPageStarted:"+url);
        }
        //页面加载完成
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.e("----","onPageFinished:"+url);
        }
    };
    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {

        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            return true;
        }

    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.re_top_finish :
                finish();
                break;
        }
    }
}
