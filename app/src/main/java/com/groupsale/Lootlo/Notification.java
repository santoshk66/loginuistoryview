package com.groupsale.Lootlo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Notification extends AppCompatActivity {
    private WebView webView;



    Intent intent = getIntent();
    String action = intent.getAction();
    Uri uri = intent.getData();

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);
                if (key.equals("click_action")) {
                    //perform the action you want to do with the key.
                }
            }
        }

        if (uri != null) {
            List<String> param = uri.getPathSegments();


            webView = (WebView) findViewById(R.id.web_Notification);
            webView.setWebViewClient(new WebViewClient());
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl(uri.toString());

        }


    }

    }
