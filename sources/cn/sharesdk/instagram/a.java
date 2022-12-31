package cn.sharesdk.instagram;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.c;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.AccessToken;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.HashMap;
/* compiled from: InstagramAuthorizeWebviewClient.java */
/* loaded from: classes.dex */
public class a extends c {
    private boolean a;

    public a(g gVar) {
        super(gVar);
    }

    @Override // cn.sharesdk.framework.authorize.c
    protected void onComplete(String str) {
        if (this.a) {
            return;
        }
        this.a = true;
        Bundle urlToBundle = ResHelper.urlToBundle(str);
        if (!urlToBundle.containsKey("code")) {
            AuthorizeListener authorizeListener = this.listener;
            if (authorizeListener != null) {
                authorizeListener.onError(new Throwable("code is null"));
                return;
            }
            return;
        }
        final String string = urlToBundle.getString("code");
        new Thread() { // from class: cn.sharesdk.instagram.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String str2;
                try {
                    str2 = b.a(((c) a.this).activity.a().getPlatform()).a(string);
                } catch (Throwable th) {
                    ((c) a.this).listener.onError(th);
                    str2 = null;
                }
                if (str2 == null) {
                    ((c) a.this).listener.onError(new Throwable("Authorize token is empty"));
                    return;
                }
                try {
                    HashMap fromJson = new Hashon().fromJson(str2);
                    Bundle bundle = new Bundle();
                    bundle.putString("access_token", String.valueOf(fromJson.get("access_token")));
                    if (ShareSDK.isFBInstagram()) {
                        bundle.putString(AccessToken.USER_ID_KEY, String.valueOf(fromJson.get(AccessToken.USER_ID_KEY)));
                        ((c) a.this).listener.onComplete(bundle);
                    } else {
                        HashMap hashMap = (HashMap) fromJson.get("user");
                        bundle.putString("username", String.valueOf(hashMap.get("username")));
                        bundle.putString("bio", String.valueOf(hashMap.get("bio")));
                        bundle.putString("website", String.valueOf(hashMap.get("website")));
                        bundle.putString("profile_picture", String.valueOf(hashMap.get("profile_picture")));
                        bundle.putString("full_name", String.valueOf(hashMap.get("full_name")));
                        bundle.putString(TapjoyAuctionFlags.AUCTION_ID, String.valueOf(hashMap.get(TapjoyAuctionFlags.AUCTION_ID)));
                        ((c) a.this).listener.onComplete(bundle);
                    }
                } catch (Throwable th2) {
                    NLog b = SSDKLog.b();
                    b.d("InstagramAuthorizeWebviewClient " + th2, new Object[0]);
                }
            }
        }.start();
    }

    @Override // cn.sharesdk.framework.g, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2 = this.redirectUri;
        if (str2 != null && str.startsWith(str2)) {
            webView.setVisibility(4);
            VdsAgent.onSetViewVisibility(webView, 4);
            webView.stopLoading();
            this.activity.finish();
            onComplete(str);
            return;
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // cn.sharesdk.framework.g, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = this.redirectUri;
        if (str2 != null && str.startsWith(str2)) {
            webView.setVisibility(4);
            VdsAgent.onSetViewVisibility(webView, 4);
            webView.stopLoading();
            this.activity.finish();
            onComplete(str);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
