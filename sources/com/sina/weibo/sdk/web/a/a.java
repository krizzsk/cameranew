package com.sina.weibo.sdk.web.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.common.UiError;
/* loaded from: classes3.dex */
public final class a extends b {
    public a(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        super(activity, aVar, bVar);
    }

    private boolean l(String str) {
        Bundle g2;
        AuthInfo a = this.aF.x().a();
        return (a == null || !str.startsWith(a.getRedirectUrl()) || (g2 = e.g(str)) == null || TextUtils.isEmpty(g2.getString("access_token"))) ? false : true;
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        AuthInfo a = this.aF.x().a();
        if (a == null || !str.startsWith(a.getRedirectUrl())) {
            return;
        }
        String u = this.aF.x().u();
        if (!TextUtils.isEmpty(u)) {
            WbAuthListener a2 = this.aC.a(u);
            this.aG = a2;
            if (a2 != null) {
                Bundle g2 = e.g(str);
                if (g2 != null) {
                    String string = g2.getString("error");
                    String string2 = g2.getString("error_code");
                    String string3 = g2.getString("error_description");
                    if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                        Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(g2);
                        AccessTokenHelper.writeAccessToken(this.aD, parseAccessToken);
                        this.aG.onComplete(parseAccessToken);
                    } else {
                        this.aG.onError(new UiError(-1, string2, string3));
                    }
                } else {
                    this.aG.onError(new UiError(-1, "bundle is null", "parse url error"));
                }
                this.aC.b(u);
            }
        }
        com.sina.weibo.sdk.web.a aVar = this.aE;
        if (aVar != null) {
            aVar.t();
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            return l(webResourceRequest.getUrl().toString());
        }
        return false;
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void t() {
        super.t();
        String u = this.aF.x().u();
        if (!TextUtils.isEmpty(u)) {
            WbAuthListener a = this.aC.a(u);
            this.aG = a;
            if (a != null) {
                a.onCancel();
            }
            this.aC.b(u);
        }
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

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return l(str);
    }
}
