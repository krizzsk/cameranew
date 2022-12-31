package cn.sharesdk.douyin;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
/* compiled from: DouyinAuthorizeWebviewClient.java */
/* loaded from: classes.dex */
public class a extends cn.sharesdk.framework.authorize.c {
    private boolean a;

    public a(g gVar) {
        super(gVar);
    }

    @Override // cn.sharesdk.framework.authorize.c
    protected void onComplete(String str) {
        AuthorizeListener authorizeListener;
        if (this.a) {
            return;
        }
        this.a = true;
        Bundle urlToBundle = ResHelper.urlToBundle(str);
        String string = urlToBundle.getString(SocialConstants.PARAM_COMMENT);
        if (string != null && (authorizeListener = this.listener) != null) {
            authorizeListener.onError(new Throwable(urlToBundle.toString()));
        }
        if (string != null || this.listener == null) {
            return;
        }
        final String string2 = urlToBundle.getString("code");
        if (!TextUtils.isEmpty(string2)) {
            new Thread() { // from class: cn.sharesdk.douyin.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    String str2;
                    try {
                        str2 = c.a().a(string2, c.a().c(), c.a().d());
                    } catch (Throwable th) {
                        if (((cn.sharesdk.framework.authorize.c) a.this).listener != null) {
                            ((cn.sharesdk.framework.authorize.c) a.this).listener.onError(th);
                        }
                        str2 = null;
                    }
                    if (str2 == null && ((cn.sharesdk.framework.authorize.c) a.this).listener != null) {
                        ((cn.sharesdk.framework.authorize.c) a.this).listener.onError(new Throwable("Authorize token is empty"));
                        return;
                    }
                    HashMap fromJson = new Hashon().fromJson(str2);
                    HashMap hashMap = (HashMap) fromJson.get("data");
                    String valueOf = String.valueOf(fromJson.get("message"));
                    if (valueOf.equals(FirebaseAnalytics.Param.SUCCESS)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("access_token", String.valueOf(hashMap.get("access_token")));
                        bundle.putString("expires_in", String.valueOf(hashMap.get("expires_in")));
                        bundle.putString("refresh_token", String.valueOf(hashMap.get("refresh_token")));
                        bundle.putString("open_id", String.valueOf(hashMap.get("open_id")));
                        bundle.putString("scope", String.valueOf(hashMap.get("scope")));
                        bundle.putString("error_code", String.valueOf(hashMap.get("error_code")));
                        ((cn.sharesdk.framework.authorize.c) a.this).listener.onComplete(bundle);
                    } else if (valueOf.equals("error")) {
                        String valueOf2 = String.valueOf(hashMap.get(SocialConstants.PARAM_COMMENT));
                        String valueOf3 = String.valueOf(hashMap.get("error_code"));
                        AuthorizeListener authorizeListener2 = ((cn.sharesdk.framework.authorize.c) a.this).listener;
                        authorizeListener2.onError(new Throwable("error_code" + valueOf3 + " errorDesc " + valueOf2));
                    }
                }
            }.start();
        } else {
            this.listener.onError(new Throwable(str));
        }
    }

    @Override // cn.sharesdk.framework.g, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith("https://open.douyin.com/oauth/authorize/callback/")) {
            webView.stopLoading();
            this.activity.finish();
            onComplete(str);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
