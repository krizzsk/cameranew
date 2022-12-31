package us.pinguo.smaato.d;

import android.app.Activity;
import android.view.View;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGSmaatoInterstitialNative.java */
/* loaded from: classes6.dex */
public class a extends us.pinguo.advsdk.a.b {
    private us.pinguo.smaatoapi.a a;
    private AdsItem b;
    private us.pinguo.advsdk.bean.b c;

    public a(AdsItem adsItem, us.pinguo.smaatoapi.a aVar, us.pinguo.advsdk.bean.b bVar) {
        this.b = adsItem;
        this.c = bVar;
        this.a = aVar;
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
        AdsItem adsItem = this.b;
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
        return 35;
    }

    @Override // us.pinguo.advsdk.a.b
    public String m() {
        return this.c.c;
    }

    @Override // us.pinguo.advsdk.a.b
    public void q(View view) {
    }

    @Override // us.pinguo.advsdk.a.b
    public void s(Activity activity) {
        super.s(activity);
        us.pinguo.smaatoapi.a aVar = this.a;
        if (aVar == null) {
            return;
        }
        aVar.b();
    }
}
