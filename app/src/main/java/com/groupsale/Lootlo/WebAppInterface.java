package com.groupsale.Lootlo;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class WebAppInterface extends Fragment {
    Context mContext;
    String link;

    
    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /**
     * Show a toast from the web page
     */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show(); //sku-Lootllo803

    }

    public WebAppInterface(Deal deal) {
    }

    public void sharelink(String link1) {
        link = link1;
        Toast.makeText(mContext, link1, Toast.LENGTH_SHORT).show();


    }

    public void datapass(int a, int b, int c) {

        Toast.makeText(mContext, String.valueOf(a), Toast.LENGTH_SHORT).show();
        Toast.makeText(mContext, String.valueOf(b), Toast.LENGTH_SHORT).show();
        Toast.makeText(mContext, String.valueOf(c), Toast.LENGTH_SHORT).show();


    }

}



