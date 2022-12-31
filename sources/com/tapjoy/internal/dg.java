package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.autoburry.VdsAgent;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class dg {
    private static dg a = new dg();

    private dg() {
    }

    public static dg a() {
        return a;
    }

    @VisibleForTesting
    private static void a(StringBuilder sb, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                sb.append('\"');
            } else {
                if (obj instanceof String) {
                    String obj2 = obj.toString();
                    if (obj2.startsWith("{")) {
                        sb.append(obj2);
                    } else {
                        sb.append('\"');
                        sb.append(obj2);
                    }
                } else {
                    sb.append(obj);
                }
                sb.append(",");
            }
            sb.append('\"');
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
    }

    public static boolean a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "javascript: " + str;
        webView.loadUrl(str2);
        VdsAgent.loadUrl(webView, str2);
        return true;
    }

    public final void a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            a(webView, "publishVideoEvent", str, jSONObject);
        } else {
            a(webView, "publishVideoEvent", str);
        }
    }

    @VisibleForTesting
    public final void a(final WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            a(sb, objArr);
            sb.append(")}");
            final String sb2 = sb.toString();
            Handler handler = webView.getHandler();
            if (handler != null && Looper.myLooper() != handler.getLooper()) {
                handler.post(new Runnable() { // from class: com.tapjoy.internal.dg.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebView webView2 = webView;
                        String str2 = sb2;
                        webView2.loadUrl(str2);
                        VdsAgent.loadUrl(webView2, str2);
                    }
                });
                return;
            }
            webView.loadUrl(sb2);
            VdsAgent.loadUrl(webView, sb2);
        }
    }

    public final void b(WebView webView, String str) {
        a(webView, "setNativeViewHierarchy", str);
    }
}
