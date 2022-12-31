package us.pinguo.advsdk.a;

import android.content.Context;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: AbsRequestModel.java */
/* loaded from: classes3.dex */
public abstract class c {
    protected List<AdsItem> a;
    protected j b;
    protected k c;

    /* renamed from: e  reason: collision with root package name */
    protected us.pinguo.advsdk.bean.b f9037e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9038f = false;

    /* renamed from: d  reason: collision with root package name */
    protected AtomicBoolean f9036d = new AtomicBoolean(false);

    public c(j jVar, k kVar) {
        this.b = jVar;
        this.c = kVar;
    }

    public String c(AdsItem adsItem) {
        return adsItem.loadSDK + "_" + adsItem.placementId + adsItem.offerId;
    }

    public boolean g(AdsItem adsItem) {
        return adsItem != null && adsItem.mask == 1;
    }

    public boolean h() {
        return this.f9038f;
    }

    public void i(Context context, List<AdsItem> list, us.pinguo.advsdk.bean.b bVar) {
        this.a = list;
        this.f9037e = bVar;
        this.f9038f = false;
        this.f9036d.set(true);
    }

    public void j(b bVar) {
        k kVar = this.c;
        if (kVar != null) {
            kVar.d(bVar);
        }
    }

    public void k(b bVar) {
        k kVar = this.c;
        if (kVar != null) {
            kVar.onAdDestroy(bVar);
        }
    }

    public void l(AdsItem adsItem, String str) {
        k kVar;
        this.f9036d.set(false);
        if (h() || (kVar = this.c) == null) {
            return;
        }
        kVar.e(adsItem, str);
    }

    public void m(b bVar) {
        k kVar = this.c;
        if (kVar != null) {
            kVar.onRewardVideoClose(bVar);
        }
    }

    public void n(b bVar) {
        k kVar = this.c;
        if (kVar != null) {
            kVar.f(bVar);
        }
    }

    public void o(b bVar, boolean z) {
        k kVar = this.c;
        if (kVar != null) {
            if (z) {
                kVar.a(bVar);
            } else {
                kVar.f(bVar);
            }
        }
    }

    public void p(AdsItem adsItem, b bVar) {
        k kVar;
        this.f9036d.set(false);
        if (h() || (kVar = this.c) == null) {
            return;
        }
        kVar.b(adsItem, bVar);
    }
}
