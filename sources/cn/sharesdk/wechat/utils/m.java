package cn.sharesdk.wechat.utils;

import android.os.Bundle;
/* compiled from: WechatReq.java */
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: e  reason: collision with root package name */
    public String f323e;

    /* renamed from: f  reason: collision with root package name */
    public String f324f;

    public abstract int a();

    public void a(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", a());
        bundle.putString("_wxapi_basereq_transaction", this.f323e);
        bundle.putString("_wxapi_basereq_openid", this.f324f);
    }

    public abstract boolean a(boolean z);
}
