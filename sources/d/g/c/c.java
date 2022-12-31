package d.g.c;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdView;
import java.util.List;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.network.e;
/* compiled from: PGGoogleBannerNative.java */
/* loaded from: classes3.dex */
public class c extends us.pinguo.advsdk.a.b {
    private AdsItem a;
    private us.pinguo.advsdk.bean.b b;
    private AdView c;

    public c(AdsItem adsItem, us.pinguo.advsdk.bean.b bVar, AdView adView) {
        this.a = adsItem;
        this.b = bVar;
        this.c = adView;
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
        return 2;
    }

    @Override // us.pinguo.advsdk.a.b
    public String m() {
        return this.b.c;
    }

    @Override // us.pinguo.advsdk.a.b
    public void o(View view, List<View> list, ViewGroup viewGroup) {
        List<String> list2;
        super.o(view, list, viewGroup);
        viewGroup.addView(this.c);
        AdsItem adsItem = this.a;
        if (adsItem == null || (list2 = adsItem.impression) == null || list2.size() == 0) {
            return;
        }
        new e(view.getContext(), this.a, this).execute();
        PgAdvManager.getInstance().i().d();
        us.pinguo.advsdk.statistic.b.a.a(new d.g.a(true).a(), m());
        us.pinguo.advsdk.statistic.a.a.c("third_req_show", this.a.source, m());
    }

    @Override // us.pinguo.advsdk.a.b
    public void q(View view) {
    }
}
