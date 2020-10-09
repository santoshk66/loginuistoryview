package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
   private WebView web2;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        web2 = (WebView) findViewById(R.id.web_home);
        web2.setWebViewClient(new WebViewClient());
        web2.loadUrl("https://www.lootllo.com/index.php/");
        WebSettings webSettings = web2.getSettings();
        webSettings.setJavaScriptEnabled(true);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        return false;

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.main_notification_icon) {
            //startActivity(new Intent(MainActivity.this,NotificationActivity.class));
            return true;
        } else if (id == R.id.main_cart_icon) {
          /*  if (currentUser == null) {
                signInDialog.show();
            } else {
                gotoFragment("My Cart", new MyCartFragment(), CART_FRAGMENT);
            }*/

            return true;
        } else if (id == android.R.id.home) {
           /* if (showCart) {
                mainActivity = null;
                showCart = false;
                finish();
                return true;
            }*/
        }
        return super.onOptionsItemSelected(item);
    }

    private class callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
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