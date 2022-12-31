package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.webkit.WebView;
/* loaded from: classes3.dex */
public final class dt extends ds {
    @SuppressLint({"SetJavaScriptEnabled"})
    public dt(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
