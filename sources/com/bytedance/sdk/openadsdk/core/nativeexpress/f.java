package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
/* compiled from: ExpressClient.java */
/* loaded from: classes.dex */
public class f extends com.bytedance.sdk.openadsdk.core.widget.webview.c {
    private com.bytedance.sdk.openadsdk.core.d.h a;

    public f(Context context, v vVar, com.bytedance.sdk.openadsdk.core.d.h hVar, com.bytedance.sdk.openadsdk.c.j jVar) {
        super(context, vVar, hVar.J(), jVar);
        this.a = hVar;
    }

    private WebResourceResponse a(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.d.g gVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e.a a = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
        if (a != e.a.IMAGE) {
            Iterator<com.bytedance.sdk.openadsdk.core.d.g> it = this.a.B().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.bytedance.sdk.openadsdk.core.d.g next = it.next();
                if (!TextUtils.isEmpty(next.a()) && !TextUtils.isEmpty(str)) {
                    String a2 = next.a();
                    if (a2.startsWith("https")) {
                        a2 = a2.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(a2)) {
                        gVar = next;
                        break;
                    }
                }
            }
        }
        if (a != e.a.IMAGE && gVar == null) {
            return com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(str, a);
        }
        return a(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f1934f = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f1935g = false;
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            o.c("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            WebResourceResponse a = a(webView, str);
            a(currentTimeMillis, System.currentTimeMillis(), str, a != null ? 1 : 2);
            if (a != null) {
                return a;
            }
        } catch (Throwable th) {
            o.c("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    private WebResourceResponse a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File a = com.bytedance.sdk.openadsdk.g.a.a.a().a(com.bytedance.sdk.openadsdk.g.a.a.a().a(str, 0, 0, null));
            if (a == null || !a.exists() || a.length() <= 0) {
                return null;
            }
            return new WebResourceResponse(e.a.IMAGE.a(), "utf-8", new FileInputStream(a));
        } catch (Throwable th) {
            o.c("ExpressClient", "get image WebResourceResponse error", th);
            return null;
        }
    }

    private void a(long j2, long j3, String str, int i2) {
        com.bytedance.sdk.openadsdk.c.j jVar = this.f1933e;
        if (jVar == null || jVar.a() == null) {
            return;
        }
        e.a a = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
        if (a == e.a.HTML) {
            this.f1933e.a().a(str, j2, j3, i2);
        } else if (a == e.a.JS) {
            this.f1933e.a().b(str, j2, j3, i2);
        }
    }
}
