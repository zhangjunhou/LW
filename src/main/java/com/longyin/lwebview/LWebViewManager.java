package com.longyin.lwebview;

import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by Terry on 2016/11/12.
 */
public class LWebViewManager extends SimpleViewManager<WebView> {
    @Override
    public String getName() {
        return "LWebView";
    }

    @Override
    protected WebView createViewInstance(ThemedReactContext reactContext) {

        WebView mWebView= new WebView(reactContext);

        WebSettings set = mWebView.getSettings();
        set.setJavaScriptEnabled(true);
        set.setUseWideViewPort(true);
        set.setLoadWithOverviewMode(true);
        set.setDomStorageEnabled(true);

        WebChromeClient wvcc = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        };
        // 创建WebViewClient对象
        WebViewClient wvc = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        };
        // 设置setWebChromeClient对象
        mWebView.setWebChromeClient(wvcc);
        mWebView.setWebViewClient(wvc);




        return mWebView;
    }

    @ReactProp(name = "url")
    public void setUrl(WebView view,@Nullable String url) {
        view.loadUrl(url);

    }
    @ReactProp(name="initscale")
    public void setInitScale(WebView view,@Nullable int initscale) {
        view.setInitialScale(initscale);
    }

}
