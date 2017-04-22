package com.example.max.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Boolean.FALSE;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private String URL;
    private EditText mEditText;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView=new WebView(this);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mEditText=(EditText)findViewById(R.id.editText) ;
        mButton=(Button)findViewById(R.id.button) ;
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL=mEditText.getText().toString();
                Intent mIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                if(URL.equals("")==FALSE){
                    //                mWebView.loadUrl(URL);
                    mIntent.putExtra("url",URL);
                    startActivity(mIntent);
                }
            }
        });



    }
}
