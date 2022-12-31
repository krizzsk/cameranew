package d.g.d;

import android.content.Context;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.a.h;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGFBInterstitialRequest.java */
/* loaded from: classes3.dex */
public class d extends us.pinguo.advsdk.a.d<c> {

    /* renamed from: j  reason: collision with root package name */
    private b f8600j;

    /* renamed from: k  reason: collision with root package name */
    private long f8601k;

    /* renamed from: l  reason: collision with root package name */
    d.g.d.a f8602l;

    /* compiled from: PGFBInterstitialRequest.java */
    /* loaded from: classes3.dex */
    class a implements d.g.d.a {
        a() {
        }

        @Override // d.g.d.a
        public void a() {
            if (((us.pinguo.advsdk.a.a) d.this).c != null) {
                ((us.pinguo.advsdk.a.a) d.this).c.onAdDestroy(new c(((us.pinguo.advsdk.a.a) d.this).f9034e, ((us.pinguo.advsdk.a.d) d.this).f9040h, d.this.f8600j));
            }
        }

        @Override // d.g.d.a
        public void b() {
            d dVar = d.this;
            dVar.s(new c(((us.pinguo.advsdk.a.a) dVar).f9034e, ((us.pinguo.advsdk.a.d) d.this).f9040h, d.this.f8600j));
        }

        @Override // d.g.d.a
        public void onAdClicked() {
            c cVar = new c(((us.pinguo.advsdk.a.a) d.this).f9034e, ((us.pinguo.advsdk.a.d) d.this).f9040h, d.this.f8600j);
            d.this.s(cVar);
            new us.pinguo.advsdk.network.c((Context) ((us.pinguo.advsdk.a.a) d.this).f9033d.get(), ((us.pinguo.advsdk.a.a) d.this).f9034e, cVar, PgAdvConstants$CountMode.NORMAL).execute();
        }

        @Override // d.g.d.a
        public void onAdLoaded() {
            d.this.z(false);
            d.this.E();
            d.this.A(System.currentTimeMillis() - d.this.f8601k);
            d dVar = d.this;
            dVar.x(new c(((us.pinguo.advsdk.a.a) dVar).f9034e, ((us.pinguo.advsdk.a.d) d.this).f9040h, d.this.f8600j));
        }

        @Override // d.g.d.a
        public void onError(String str) {
            d.this.z(false);
            d.this.t(str);
            d.this.B(str);
            us.pinguo.advsdk.network.f fVar = new us.pinguo.advsdk.network.f((Context) ((us.pinguo.advsdk.a.a) d.this).f9033d.get(), ((us.pinguo.advsdk.a.a) d.this).f9034e, ((us.pinguo.advsdk.a.d) d.this).f9040h);
            fVar.e("0", str);
            fVar.execute();
        }
    }

    public d(AdsItem adsItem, h hVar) {
        super(adsItem);
        this.f8601k = 0L;
        this.f8602l = new a();
        this.f8600j = new b();
        y(hVar);
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        this.f8601k = System.currentTimeMillis();
        D();
        this.f8600j.f(this.f9033d.get(), this.f9034e.placementId, this.f8602l);
        return false;
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        AdsItem adsItem = this.f9034e;
        if (adsItem == null) {
            return 0;
        }
        return adsItem.loadSDK;
    }
}
