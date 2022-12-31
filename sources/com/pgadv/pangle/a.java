package com.pgadv.pangle;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.pgadv.pangle.b.b;
import java.util.Map;
import us.pinguo.advsdk.a.m;
import us.pinguo.advsdk.a.p;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGPangleControl.java */
/* loaded from: classes3.dex */
public class a extends m {
    private Application c;

    /* renamed from: d  reason: collision with root package name */
    private String f5974d;

    /* renamed from: e  reason: collision with root package name */
    private String f5975e;

    public a(Application application, boolean z, String str, String str2) {
        super(application, z);
        this.c = application;
        this.f5974d = str;
        this.f5975e = str2;
    }

    @Override // us.pinguo.advsdk.a.m
    public us.pinguo.advsdk.a.a a(AdsItem adsItem) {
        String str = adsItem.displayFormat;
        str.hashCode();
        if (!str.equals("interstitial")) {
            return new b(adsItem);
        }
        return new b(adsItem);
    }

    @Override // us.pinguo.advsdk.a.m
    public String b() {
        return "36";
    }

    @Override // us.pinguo.advsdk.a.m
    public void c(Context context, Map<String, Object> map) {
    }

    @Override // us.pinguo.advsdk.a.m
    public void d(p pVar) {
        TTAdSdk.init(this.c, new TTAdConfig.Builder().appId(this.f5974d).titleBarTheme(-1).allowShowPageWhenScreenLock(true).debug(false).appName(this.f5975e).supportMultiProcess(false).coppa(0).setGDPR(0).build());
        h(pVar);
    }
}
