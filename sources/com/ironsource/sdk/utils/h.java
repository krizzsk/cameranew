package com.ironsource.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: WebViewUtils.java */
/* loaded from: classes2.dex */
public class h {
    private static String a = "h";

    public static FrameLayout a(Context context, View view) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout2.setVisibility(8);
        VdsAgent.onSetViewVisibility(frameLayout2, 8);
        FrameLayout frameLayout3 = new FrameLayout(context);
        frameLayout3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout3.addView(view);
        frameLayout.addView(frameLayout2, layoutParams);
        frameLayout.addView(frameLayout3);
        return frameLayout;
    }

    private static void b(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT > 11) {
            webSettings.setDisplayZoomControls(false);
        }
    }

    @SuppressLint({"NewApi"})
    private static void c(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
    }

    public static void d(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");
        settings.setDomStorageEnabled(true);
        try {
            b(settings);
            c(settings);
        } catch (Throwable th) {
            String str = a;
            d.b(str, "setWebSettings - " + th.toString());
        }
    }
}
