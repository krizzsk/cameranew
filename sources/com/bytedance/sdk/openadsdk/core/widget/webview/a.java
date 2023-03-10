package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.utils.o;
import java.lang.ref.WeakReference;
/* compiled from: SSWebSettings.java */
/* loaded from: classes.dex */
public class a {
    private WeakReference<Context> a;
    private boolean b = true;
    private boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1911d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1912e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1913f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1914g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1915h = true;

    private a(Context context) {
        this.a = new WeakReference<>(context);
    }

    public static a a(Context context) {
        return new a(context);
    }

    public a b(boolean z) {
        this.c = z;
        return this;
    }

    private void b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            o.b(th.toString());
        }
    }

    public a a(boolean z) {
        this.f1915h = z;
        return this;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void a(WebView webView) {
        if (webView == null || this.a.get() == null) {
            return;
        }
        b(webView);
        WebSettings settings = webView.getSettings();
        a(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.c) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.f1911d);
        settings.setDomStorageEnabled(this.f1912e);
        settings.setAllowFileAccess(this.f1913f);
        settings.setBlockNetworkImage(true ^ this.f1914g);
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 11 && !this.f1915h) {
                webView.setLayerType(0, null);
            } else if (i2 >= 16 && this.f1915h) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            o.b(th.toString());
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        String replace = str.replace("{{ad_id}}", str2);
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + replace + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
    }
}
