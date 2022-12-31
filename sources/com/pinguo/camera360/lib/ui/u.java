package com.pinguo.camera360.lib.ui;

import android.text.TextUtils;
import android.webkit.WebView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Locale;
/* compiled from: WebErrorLoad.java */
/* loaded from: classes3.dex */
public final class u {
    private static String a(Locale locale) {
        String language = locale.getLanguage();
        return "zh".equals(language) ? "CN".equals(locale.getCountry()) ? "zh_CN" : "zh" : "ja".equals(language) ? "ja" : "th".equals(language) ? "th" : "es".equals(language) ? "es" : "";
    }

    public static void b(WebView webView) {
        String a = a(us.pinguo.foundation.utils.v.a());
        if (TextUtils.isEmpty(a)) {
            webView.loadUrl("file:///android_asset/www/error.html");
            VdsAgent.loadUrl(webView, "file:///android_asset/www/error.html");
            return;
        }
        String str = "file:///android_asset/www/error-" + a + ".html";
        webView.loadUrl(str);
        VdsAgent.loadUrl(webView, str);
    }
}
