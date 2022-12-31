package com.pgadv.admob;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.MobileAds;
import d.g.c.d;
import d.g.d.f;
import java.util.Map;
import us.pinguo.advsdk.a.m;
import us.pinguo.advsdk.a.p;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGGoogleControl.java */
/* loaded from: classes3.dex */
public class a extends m {
    private String c;

    public a(Context context, boolean z, String str) {
        super(context, z);
        this.c = null;
        this.c = str;
    }

    @Override // us.pinguo.advsdk.a.m
    public us.pinguo.advsdk.a.a a(AdsItem adsItem) {
        if ("interstitial".equals(adsItem.displayFormat)) {
            return new f(adsItem, new d.g.a(false));
        }
        if ("banner".equals(adsItem.displayFormat)) {
            return new d(adsItem, new d.g.a(false));
        }
        if ("rewardVideo".equals(adsItem.displayFormat)) {
            return new d.g.g.b(adsItem, new d.g.a(false));
        }
        if ("launchScreen".equals(adsItem.displayFormat)) {
            return new d.g.e.b(adsItem, new d.g.a(false));
        }
        if ("interstitial_reward".equals(adsItem.displayFormat)) {
            return new d.g.f.b(adsItem, new d.g.a(false));
        }
        return new c(adsItem, new d.g.a(true));
    }

    @Override // us.pinguo.advsdk.a.m
    public String b() {
        return "2";
    }

    @Override // us.pinguo.advsdk.a.m
    public void c(Context context, Map<String, Object> map) {
    }

    @Override // us.pinguo.advsdk.a.m
    public void d(p pVar) {
        Context context;
        if (!TextUtils.isEmpty(this.c) && (context = this.b) != null) {
            MobileAds.initialize(context);
            h(pVar);
            us.pinguo.advsdk.utils.b.a("admob init success");
            return;
        }
        us.pinguo.advsdk.utils.b.a("admob init failed:appid is null or application is null");
        g(pVar);
    }

    @Override // us.pinguo.advsdk.a.m
    public boolean e() {
        return true;
    }
}
