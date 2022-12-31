package us.pinguo.advsdk.manager;

import android.content.Context;
import java.util.List;
import us.pinguo.advsdk.bean.AdsItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SerializeRequestController.java */
/* loaded from: classes3.dex */
public class l extends us.pinguo.advsdk.a.c implements us.pinguo.advsdk.a.k {

    /* renamed from: g  reason: collision with root package name */
    private int f9081g;

    /* renamed from: h  reason: collision with root package name */
    private Context f9082h;

    public l(f fVar, us.pinguo.advsdk.a.k kVar) {
        super(fVar, kVar);
        this.f9081g = -1;
    }

    private boolean q() {
        List<AdsItem> list = this.a;
        return list == null || list.size() == 0 || this.f9081g == this.a.size() - 1;
    }

    private void r() {
        int i2 = this.f9081g + 1;
        this.f9081g = i2;
        if (i2 >= this.a.size()) {
            l(null, "failed");
            return;
        }
        us.pinguo.advsdk.a.a c = this.b.c(this.a.get(this.f9081g));
        if (c == null) {
            r();
            return;
        }
        c.k(this.f9082h, this, this.f9037e, this.a.get(this.f9081g));
        c.i();
    }

    @Override // us.pinguo.advsdk.a.k
    public void a(us.pinguo.advsdk.a.b bVar) {
        o(bVar, true);
    }

    @Override // us.pinguo.advsdk.a.k
    public void b(AdsItem adsItem, us.pinguo.advsdk.a.b bVar) {
        if (g(adsItem)) {
            r();
            return;
        }
        this.f9081g = -1;
        p(adsItem, bVar);
    }

    @Override // us.pinguo.advsdk.a.k
    public void d(us.pinguo.advsdk.a.b bVar) {
        j(bVar);
    }

    @Override // us.pinguo.advsdk.a.k
    public void e(AdsItem adsItem, String str) {
        if (q()) {
            l(adsItem, str);
        } else {
            r();
        }
    }

    @Override // us.pinguo.advsdk.a.k
    public void f(us.pinguo.advsdk.a.b bVar) {
        o(bVar, false);
    }

    @Override // us.pinguo.advsdk.a.c
    public void i(Context context, List<AdsItem> list, us.pinguo.advsdk.bean.b bVar) {
        super.i(context, list, bVar);
        this.f9081g = -1;
        this.f9082h = context;
        List<AdsItem> list2 = this.a;
        if (list2 != null && list2.size() != 0) {
            r();
        } else {
            l(null, "waterfall is empty");
        }
    }

    @Override // us.pinguo.advsdk.a.k
    public void onAdDestroy(us.pinguo.advsdk.a.b bVar) {
        k(bVar);
    }

    @Override // us.pinguo.advsdk.a.k
    public void onRewardVideoClose(us.pinguo.advsdk.a.b bVar) {
        m(bVar);
    }
}
