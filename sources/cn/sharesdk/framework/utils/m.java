package cn.sharesdk.framework.utils;

import android.os.Build;
import android.webkit.WebView;
/* compiled from: WebViewUtils.java */
/* loaded from: classes.dex */
public class m {
    public static void a(WebView webView, boolean z) {
        if (webView == null) {
            return;
        }
        try {
            webView.getSettings().setAllowFileAccess(z);
            if (Build.VERSION.SDK_INT >= 16) {
                webView.getSettings().setAllowFileAccessFromFileURLs(z);
                webView.getSettings().setAllowUniversalAccessFromFileURLs(z);
            }
        } catch (Throwable unused) {
        }
    }
}
