package com.example.max.mybrowser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by max on 2017/4/11.
 */

public class BrowserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView()
    {
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        if(TextUtils.isEmpty((url)))
        {
            url="http://www.bing.com";
        }
        WebView mWebView=(WebView)findViewById(R.id.myWebView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setBlockNetworkImage(false);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url)
            {
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.loadUrl(url);
    }

}
