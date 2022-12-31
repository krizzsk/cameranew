package com.sina.weibo.sdk.web.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.c.e;
/* loaded from: classes3.dex */
public final class d extends b {
    public d(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        super(activity, aVar, bVar);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void p(String str) {
        n(str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        Bundle h2 = e.h(str);
        if (h2 != null) {
            String string = h2.getString("code");
            String string2 = h2.getString("msg");
            if ("0".equals(string)) {
                m(string2);
            } else {
                n(string2);
            }
        } else {
            n("bundle is null!!!");
        }
        com.sina.weibo.sdk.web.a aVar = this.aE;
        if (aVar != null) {
            aVar.t();
            return true;
        }
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void t() {
        o("cancel share!!!");
        com.sina.weibo.sdk.web.a aVar = this.aE;
        if (aVar != null) {
            aVar.t();
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final boolean v() {
        t();
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    @TargetApi(21)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (TextUtils.isEmpty(uri) || !uri.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        Bundle h2 = e.h(uri);
        if (h2 != null) {
            String string = h2.getString("code");
            String string2 = h2.getString("msg");
            if (TextUtils.isEmpty(string)) {
                o("code is null!!!");
            } else if ("0".equals(string)) {
                m(string2);
            } else {
                n(string2);
            }
        } else {
            n("bundle is null!!!");
        }
        com.sina.weibo.sdk.web.a aVar = this.aE;
        if (aVar != null) {
            aVar.t();
            return true;
        }
        return true;
    }
}
