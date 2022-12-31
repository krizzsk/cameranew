package com.bytedance.sdk.openadsdk.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebView;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: LoadUrlUtils.java */
/* loaded from: classes.dex */
public class n {
    private static final a a;

    /* compiled from: LoadUrlUtils.java */
    /* loaded from: classes.dex */
    private static class a {
        private a() {
        }

        public void a(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
                VdsAgent.loadUrl(webView, str);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: LoadUrlUtils.java */
    @TargetApi(19)
    /* loaded from: classes.dex */
    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.bytedance.sdk.openadsdk.utils.n.a
        public void a(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            boolean z = false;
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    z = true;
                } catch (Throwable th) {
                    boolean z2 = th instanceof IllegalStateException;
                }
            }
            if (z) {
                return;
            }
            try {
                webView.loadUrl(str);
                VdsAgent.loadUrl(webView, str);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static void a(WebView webView, String str) {
        a.a(webView, str);
    }
}
