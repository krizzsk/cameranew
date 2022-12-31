package cn.sharesdk.wechat.utils;

import android.os.Bundle;
/* compiled from: AuthResp.java */
/* loaded from: classes.dex */
public class a extends WechatResp {
    public String a;
    public String b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f310d;

    /* renamed from: e  reason: collision with root package name */
    public String f311e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f312f;

    public a(Bundle bundle) {
        super(bundle);
        this.f312f = false;
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    public int a() {
        return 1;
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = bundle.getString("_wxapi_sendauth_resp_token");
        this.b = bundle.getString("_wxapi_sendauth_resp_state");
        this.c = bundle.getString("_wxapi_sendauth_resp_url");
        this.f310d = bundle.getString("_wxapi_sendauth_resp_lang");
        this.f311e = bundle.getString("_wxapi_sendauth_resp_country");
        this.f312f = bundle.getBoolean("_wxapi_sendauth_resp_auth_result");
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    public void b(Bundle bundle) {
        super.b(bundle);
        bundle.putString("_wxapi_sendauth_resp_token", this.a);
        bundle.putString("_wxapi_sendauth_resp_state", this.b);
        bundle.putString("_wxapi_sendauth_resp_url", this.c);
        bundle.putString("_wxapi_sendauth_resp_lang", this.f310d);
        bundle.putString("_wxapi_sendauth_resp_country", this.f311e);
        bundle.putBoolean("_wxapi_sendauth_resp_auth_result", this.f312f);
    }
}
