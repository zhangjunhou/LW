package com.longyin.lwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView=(WebView) findViewById(R.id.WebView);

        setWebView();
       // mWebView.setInitialScale(128);
        mWebView.loadUrl("http://118.192.148.209/addons/pk10/index.html");



    }


    private void setWebView(){
        WebSettings set = mWebView.getSettings();
        set.setJavaScriptEnabled(true);
        set.setUseWideViewPort(true);
        set.setLoadWithOverviewMode(true);

        WebChromeClient wvcc = new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.e("this", "TITLE=" + title);
            }
        };
        // 创建WebViewClient对象
        WebViewClient wvc = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWebView.loadUrl(url);
                return true;
            }
        };
        // 设置setWebChromeClient对象
        mWebView.setWebChromeClient(wvcc);
        mWebView.setWebViewClient(wvc);
    }
}
