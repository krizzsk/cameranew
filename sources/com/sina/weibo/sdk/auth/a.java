package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.sina.weibo.sdk.c.a;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.net.h;
import com.sina.weibo.sdk.web.WebActivity;
import com.tencent.stat.DeviceInfo;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<Activity> f7171g;

    /* renamed from: h  reason: collision with root package name */
    public WbAuthListener f7172h;

    public a(Activity activity) {
        this.f7171g = new WeakReference<>(activity);
    }

    public final void d() {
        c.a("WBSsoTag", "startClientAuth()");
        try {
            Activity activity = this.f7171g.get();
            a.C0256a c = com.sina.weibo.sdk.c.a.c(activity);
            Intent intent = new Intent();
            if (c == null) {
                intent.setClassName("com.sina.weibo", "com.sina.weibo.SSOActivity");
            } else {
                intent.setClassName(c.packageName, c.al);
            }
            AuthInfo a = com.sina.weibo.sdk.a.a();
            intent.putExtra("appKey", a.getAppKey());
            intent.putExtra("redirectUri", a.getRedirectUrl());
            intent.putExtra("scope", a.getScope());
            intent.putExtra("packagename", a.getPackageName());
            intent.putExtra("key_hash", a.getHash());
            intent.putExtra("_weibo_command_type", 3);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            intent.putExtra("_weibo_transaction", sb.toString());
            Activity activity2 = this.f7171g.get();
            if (activity2 == null) {
                this.f7172h.onError(new UiError(-1, "activity is null", ""));
            } else if (com.sina.weibo.sdk.c.a.a(activity, intent)) {
                intent.putExtra(DeviceInfo.TAG_ANDROID_ID, e.f(activity2, a.getAppKey()));
                activity2.startActivityForResult(intent, 32973);
                c.a("WBSsoTag", "start SsoActivity ");
            } else {
                this.f7172h.onError(new UiError(-2, "your app is illegal", ""));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c.b("WBSsoTag", e2.getMessage());
            this.f7172h.onError(new UiError(-3, "occur exception", e2.getMessage()));
        }
    }

    public final void e() {
        Activity activity = this.f7171g.get();
        h hVar = new h();
        AuthInfo a = com.sina.weibo.sdk.a.a();
        if (a == null) {
            return;
        }
        hVar.put("client_id", a.getAppKey());
        hVar.put(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, a.getRedirectUrl());
        hVar.put("scope", a.getScope());
        hVar.put("packagename", a.getPackageName());
        hVar.put("key_hash", a.getHash());
        hVar.put(ParamKeyConstants.WebViewConstants.QUERY_RESPONSE_TYPE, "code");
        hVar.put("version", "0041005000");
        hVar.put("luicode", "10000360");
        hVar.put("lfid", "OP_" + a.getAppKey());
        Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
        if (readAccessToken != null) {
            String accessToken = readAccessToken.getAccessToken();
            if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                hVar.put("trans_token", accessToken);
                hVar.put("trans_access_token", accessToken);
            }
        }
        String f2 = e.f(activity, a.getAppKey());
        if (!TextUtils.isEmpty(f2)) {
            hVar.put(DeviceInfo.TAG_ANDROID_ID, f2);
        }
        String str = "https://open.weibo.cn/oauth2/authorize?" + hVar.k();
        if (this.f7172h != null) {
            b f3 = b.f();
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            String sb2 = sb.toString();
            f3.a(sb2, this.f7172h);
            Intent intent = new Intent(activity, WebActivity.class);
            com.sina.weibo.sdk.web.b.a aVar = new com.sina.weibo.sdk.web.b.a(a, str, sb2);
            Bundle bundle = new Bundle();
            aVar.writeToBundle(bundle);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }
}
