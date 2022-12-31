package com.pgadv.pangle.b;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGPangleInterstitialNative.java */
/* loaded from: classes3.dex */
public class a extends us.pinguo.advsdk.a.b {
    private AdsItem a;
    private us.pinguo.advsdk.bean.b b;
    private TTFullScreenVideoAd c;

    public a(AdsItem adsItem, us.pinguo.advsdk.bean.b bVar, TTFullScreenVideoAd tTFullScreenVideoAd) {
        this.a = adsItem;
        this.b = bVar;
        this.c = tTFullScreenVideoAd;
    }

    @Override // us.pinguo.advsdk.a.b
    public AdsItem a() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String b() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String c() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String d() {
        AdsItem adsItem = this.a;
        return adsItem != null ? adsItem.displayFormat : "";
    }

    @Override // us.pinguo.advsdk.a.b
    public String e() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String f() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String g() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public Object h() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String j() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String k() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public int l() {
        return 36;
    }

    @Override // us.pinguo.advsdk.a.b
    public String m() {
        return this.b.c;
    }

    @Override // us.pinguo.advsdk.a.b
    public void q(View view) {
    }

    @Override // us.pinguo.advsdk.a.b
    public void s(Activity activity) {
        super.s(activity);
        TTFullScreenVideoAd tTFullScreenVideoAd = this.c;
        if (tTFullScreenVideoAd == null) {
            return;
        }
        tTFullScreenVideoAd.showFullScreenVideoAd(activity);
    }
}
