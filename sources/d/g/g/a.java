package d.g.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
/* compiled from: PGAdmobRewardVideoNative.java */
/* loaded from: classes3.dex */
public class a extends us.pinguo.advsdk.a.b {
    private AdsItem a;
    private us.pinguo.advsdk.bean.b b;
    private c c;

    public a(AdsItem adsItem, us.pinguo.advsdk.bean.b bVar, c cVar) {
        this.a = adsItem;
        this.b = bVar;
        this.c = cVar;
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
        c cVar = this.c;
        if (cVar != null) {
            return cVar.a();
        }
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
        return 2;
    }

    @Override // us.pinguo.advsdk.a.b
    public String m() {
        us.pinguo.advsdk.bean.b bVar = this.b;
        if (bVar != null) {
            return bVar.c;
        }
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public void q(View view) {
    }

    @Override // us.pinguo.advsdk.a.b
    public void r(Context context, ViewGroup viewGroup) {
        super.r(context, viewGroup);
        c cVar = this.c;
        if (cVar != null) {
            cVar.c();
        }
        PgAdvManager.getInstance().i().d();
        us.pinguo.advsdk.statistic.b.a.a(new d.g.a(false).a(), m());
        us.pinguo.advsdk.statistic.a.a.c("third_req_show", this.a.source, m());
    }
}
