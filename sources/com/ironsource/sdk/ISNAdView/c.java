package com.ironsource.sdk.ISNAdView;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.sdk.WPAD.b;
/* compiled from: ISNAdViewWebClient.java */
/* loaded from: classes2.dex */
public class c extends WebViewClient {
    private static final String b = c.class.getSimpleName();
    private final b.a a;

    public c(b.a aVar) {
        this.a = aVar;
    }

    private String a(String str, String str2) {
        return "ISNAdViewWebClient | External Adunit failed to load." + str + " Status code: " + str2;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        try {
            this.a.a(a("onReceivedError", String.valueOf(i2)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onReceivedError(webView, i2, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        try {
            this.a.a(a("onReceivedHttpError", Build.VERSION.SDK_INT >= 21 ? String.valueOf(webResourceResponse.getStatusCode()) : ""));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            String str = b;
            com.ironsource.sdk.utils.d.b(str, "Chromium process crashed - detail.didCrash():" + renderProcessGoneDetail.didCrash());
            this.a.b(renderProcessGoneDetail.didCrash() ? "Render process was observed to crash" : "Render process was killed by the system");
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            this.a.a(a("onReceivedErrorM", String.valueOf(webResourceError.getErrorCode())));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }
}
