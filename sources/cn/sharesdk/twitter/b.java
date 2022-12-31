package cn.sharesdk.twitter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.ResHelper;
/* compiled from: TwitterAuthorizeWebviewClient.java */
/* loaded from: classes.dex */
public class b extends cn.sharesdk.framework.authorize.c {
    private boolean a;

    public b(g gVar) {
        super(gVar);
    }

    @Override // cn.sharesdk.framework.authorize.c
    public void onComplete(String str) {
        if (this.a) {
            return;
        }
        this.a = true;
        String c = c.a(this.activity.a().getPlatform()).c(str);
        if (c != null && c.length() > 0) {
            String[] split = c.split("&");
            Bundle bundle = new Bundle();
            for (String str2 : split) {
                if (str2 != null) {
                    String[] split2 = str2.split("=");
                    if (split2.length >= 2) {
                        bundle.putString(split2[0], split2[1]);
                    }
                }
            }
            if (bundle.size() <= 0) {
                AuthorizeListener authorizeListener = this.listener;
                if (authorizeListener != null) {
                    authorizeListener.onError(new Throwable());
                    return;
                }
                return;
            }
            AuthorizeListener authorizeListener2 = this.listener;
            if (authorizeListener2 != null) {
                authorizeListener2.onComplete(bundle);
                return;
            }
            return;
        }
        AuthorizeListener authorizeListener3 = this.listener;
        if (authorizeListener3 != null) {
            authorizeListener3.onError(new Throwable());
        }
    }

    @Override // cn.sharesdk.framework.g, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2 = this.redirectUri;
        if (str2 != null && str.startsWith(str2)) {
            webView.stopLoading();
            this.activity.finish();
            final String valueOf = String.valueOf(ResHelper.urlToBundle(str).get("oauth_verifier"));
            new Thread() { // from class: cn.sharesdk.twitter.b.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        b.this.onComplete(valueOf);
                    } catch (Throwable th) {
                        SSDKLog.b().d(th);
                    }
                }
            }.start();
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // cn.sharesdk.framework.g, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = this.redirectUri;
        if (str2 != null && str.startsWith(str2)) {
            webView.stopLoading();
            this.activity.finish();
            final String valueOf = String.valueOf(ResHelper.urlToBundle(str).get("oauth_verifier"));
            new Thread() { // from class: cn.sharesdk.twitter.b.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        b.this.onComplete(valueOf);
                    } catch (Throwable th) {
                        SSDKLog.b().d(th);
                    }
                }
            }.start();
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
