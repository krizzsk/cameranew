package d.g.d;

import android.app.Activity;
import android.view.View;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
/* compiled from: PGFBInterstitialNative.java */
/* loaded from: classes3.dex */
public class c extends us.pinguo.advsdk.a.b {
    AdsItem a;
    private us.pinguo.advsdk.bean.b b;
    private b c;

    public c(AdsItem adsItem, us.pinguo.advsdk.bean.b bVar, b bVar2) {
        this.a = adsItem;
        this.b = bVar;
        this.c = bVar2;
    }

    @Override // us.pinguo.advsdk.a.b
    public AdsItem a() {
        return this.a;
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
        return String.valueOf(System.currentTimeMillis());
    }

    @Override // us.pinguo.advsdk.a.b
    public String g() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public Object h() {
        return this.c.c();
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
        return 1;
    }

    @Override // us.pinguo.advsdk.a.b
    public String m() {
        us.pinguo.advsdk.bean.b bVar = this.b;
        if (bVar == null) {
            return null;
        }
        return bVar.c;
    }

    @Override // us.pinguo.advsdk.a.b
    public void q(View view) {
    }

    @Override // us.pinguo.advsdk.a.b
    public void s(Activity activity) {
        super.s(activity);
        b bVar = this.c;
        if (bVar != null) {
            bVar.e();
        }
        PgAdvManager.getInstance().i().d();
        us.pinguo.advsdk.statistic.b.a.a(new d.g.b(false).a(), m());
        us.pinguo.advsdk.statistic.a.a.c("third_req_show", this.a.source, m());
        new us.pinguo.advsdk.network.e(activity, this.a, this).execute();
    }
}
