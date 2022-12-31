package com.pgadv.ironsource.b;

import android.app.Activity;
import android.content.Context;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.n0.l;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.a.d;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.network.c;
import us.pinguo.advsdk.network.e;
import us.pinguo.advsdk.network.f;
/* compiled from: PGIronSourceInterstitialRequest.java */
/* loaded from: classes3.dex */
public class b extends d<com.pgadv.ironsource.b.a> {

    /* renamed from: j  reason: collision with root package name */
    private long f5973j;

    /* compiled from: PGIronSourceInterstitialRequest.java */
    /* loaded from: classes3.dex */
    class a implements l {
        a() {
        }

        @Override // com.ironsource.mediationsdk.n0.l
        public void a(com.ironsource.mediationsdk.logger.b bVar) {
            b.this.z(false);
            b.this.B(bVar.toString());
            b.this.t(bVar.toString());
            f fVar = new f((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h);
            fVar.e("0", bVar.toString());
            fVar.execute();
        }

        @Override // com.ironsource.mediationsdk.n0.l
        public void c() {
            b.this.z(false);
            com.pgadv.ironsource.b.a aVar = new com.pgadv.ironsource.b.a(((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h);
            b.this.E();
            b.this.A(System.currentTimeMillis() - b.this.f5973j);
            b.this.l(aVar);
            b bVar = b.this;
            bVar.x(bVar.o());
        }

        @Override // com.ironsource.mediationsdk.n0.l
        public void e(com.ironsource.mediationsdk.logger.b bVar) {
        }

        @Override // com.ironsource.mediationsdk.n0.l
        public void f() {
        }

        @Override // com.ironsource.mediationsdk.n0.l
        public void g() {
            com.pgadv.ironsource.b.a aVar = new com.pgadv.ironsource.b.a(((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h);
            new c((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, aVar, PgAdvConstants$CountMode.NORMAL).execute();
            b.this.s(aVar);
        }

        @Override // com.ironsource.mediationsdk.n0.l
        public void h() {
        }

        @Override // com.ironsource.mediationsdk.n0.l
        public void j() {
            new e((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, new com.pgadv.ironsource.b.a(((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h)).execute();
        }
    }

    public b(AdsItem adsItem) {
        super(adsItem);
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        IronSource.a((Activity) this.f9033d.get(), com.pgadv.ironsource.a.f5972d, IronSource.AD_UNIT.INTERSTITIAL);
        IronSource.d(new a());
        this.f5973j = System.currentTimeMillis();
        IronSource.c();
        return false;
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        return 34;
    }
}
