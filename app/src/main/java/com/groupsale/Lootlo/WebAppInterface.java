package com.groupsale.Lootlo;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface extends MainActivity {
    Context mContext;
    String link;

    
    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }



    public void sharelink(String link1)
    {
        link=link1;
        Toast.makeText(mContext, link1, Toast.LENGTH_SHORT).show();


    }
}



