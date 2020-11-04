package com.groupsale.Lootlo;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static String data;
    private WebView web2;
    public static final String USER_AGENT_FAKE = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";




    protected static void mainlink(String link) {
        data=link;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        web2 = findViewById(R.id.web_home);
        web2.setWebViewClient(new callback() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                boolean overrideUrlLoading = false;

                if (url != null && url.startsWith("whatsapp://")) {

                    view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

                    overrideUrlLoading = true;

            } else {

                    view.loadUrl(url);
                }

                return overrideUrlLoading;

            }


        });
        web2.loadUrl("https://www.lootllo.com");
        // javascript enable
        WebSettings webSettings = web2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web2.getSettings().setUserAgentString(USER_AGENT_FAKE);



        web2.addJavascriptInterface(new WebAppInterface(this), "Android");





    }


    public class callback extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            https:
//www.facebook.com/dialog/permissions.request
            //actually  works for me, but I put the URL you say is coming up
            //blank in there instead, whatever works for you:
            if (url.startsWith("https://www.lootllo.com/index.php/sociallogin/account/login/type/")) {
                String redirectUrl = "http://www.lootllo.com/";
                view.loadUrl(redirectUrl);
                return;
            }
            super.onPageFinished(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            boolean overrideUrlLoading = false;

            if (url != null && url.startsWith("whatsapp://")) {

                view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

                overrideUrlLoading = true;

            } else {

                view.loadUrl(url);
            }

            return overrideUrlLoading;

        }

        }
    @Override
    public void onBackPressed() {
        if (web2.canGoBack()) {
            web2.goBack();
        } else {
            super.onBackPressed();
        }
    }


}