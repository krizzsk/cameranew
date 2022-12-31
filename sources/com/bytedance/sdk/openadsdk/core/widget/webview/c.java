package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.n;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: TTWebViewClient.java */
/* loaded from: classes.dex */
public class c extends WebViewClient {
    protected final v b;
    protected final Context c;

    /* renamed from: d  reason: collision with root package name */
    protected final String f1932d;

    /* renamed from: e  reason: collision with root package name */
    protected j f1933e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f1934f = true;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f1935g = true;

    public c(Context context, v vVar, String str, j jVar) {
        this.c = context;
        this.b = vVar;
        this.f1932d = str;
        this.f1933e = jVar;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (o.a()) {
            o.a("WebChromeClient", "onPageFinished " + str);
        }
        j jVar = this.f1933e;
        if (jVar != null) {
            jVar.a(webView, str);
        }
        if (webView != null && this.f1934f) {
            try {
                String a = a.a(com.bytedance.sdk.openadsdk.core.o.h().g(), this.f1932d);
                if (!TextUtils.isEmpty(a)) {
                    n.a(webView, a);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        j jVar = this.f1933e;
        if (jVar != null) {
            jVar.a(webView, str, bitmap);
        }
        if (this.f1935g) {
            a.a(this.c).a(Build.VERSION.SDK_INT >= 19).a(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        j jVar = this.f1933e;
        if (jVar != null) {
            jVar.a(webView, i2, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        j jVar = this.f1933e;
        if (jVar == null || webResourceResponse == null) {
            return;
        }
        jVar.a(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.f1933e != null) {
            int i2 = 0;
            String str = "SslError: unknown";
            if (sslError != null) {
                try {
                    i2 = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                } catch (Throwable unused2) {
                }
            }
            this.f1933e.a(webView, i2, str, null);
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        j jVar = this.f1933e;
        if (jVar != null) {
            jVar.a(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse;
        o.b("WebChromeClient", "shouldOverrideUrlLoading " + str);
        try {
            parse = Uri.parse(str);
        } catch (Exception e2) {
            o.b("WebChromeClient", "shouldOverrideUrlLoading", e2);
            v vVar = this.b;
            if (vVar != null && vVar.a()) {
                return true;
            }
        }
        if ("bytedance".equals(parse.getScheme().toLowerCase())) {
            l.a(parse, this.b);
            return true;
        }
        if (!q.a(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            this.c.startActivity(intent);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        j jVar = this.f1933e;
        if (jVar == null || webResourceError == null) {
            return;
        }
        jVar.a(webView, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), null);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }
}
