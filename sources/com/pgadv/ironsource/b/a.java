package com.pgadv.ironsource.b;

import android.app.Activity;
import android.view.View;
import com.ironsource.mediationsdk.IronSource;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGIronSourceInterstitialNative.java */
/* loaded from: classes3.dex */
public class a extends us.pinguo.advsdk.a.b {
    private AdsItem a;
    private us.pinguo.advsdk.bean.b b;

    public a(AdsItem adsItem, us.pinguo.advsdk.bean.b bVar) {
        this.a = adsItem;
        this.b = bVar;
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
        return 34;
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
        try {
            if (IronSource.b()) {
                IronSource.e(this.a.placementId);
            }
        } catch (Exception e2) {
            us.pinguo.advsdk.utils.b.a(e2.getMessage());
        }
    }
}
