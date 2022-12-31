package us.pinguo.smaato.d;

import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.a.d;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.network.c;
import us.pinguo.advsdk.network.e;
import us.pinguo.advsdk.network.f;
import us.pinguo.smaatoapi.a;
import us.pinguo.smaatoapi.network.InsertitialLoader;
/* compiled from: PGSmaatoInterstitialRequest.java */
/* loaded from: classes6.dex */
public class b extends d<a> implements a.InterfaceC0444a {

    /* renamed from: j  reason: collision with root package name */
    private String f11974j;

    /* renamed from: k  reason: collision with root package name */
    private long f11975k;

    public b(AdsItem adsItem, String str) {
        super(adsItem);
        this.f11974j = str;
    }

    @Override // us.pinguo.smaatoapi.a.InterfaceC0444a
    public void a(us.pinguo.smaatoapi.a aVar) {
        z(false);
        a aVar2 = new a(this.f9034e, aVar, this.f9040h);
        E();
        A(System.currentTimeMillis() - this.f11975k);
        l(aVar2);
        x(o());
    }

    @Override // us.pinguo.smaatoapi.a.InterfaceC0444a
    public void b(us.pinguo.smaatoapi.a aVar) {
        AdsItem adsItem = this.f9034e;
        new e(this.f9033d.get(), adsItem, new a(adsItem, aVar, this.f9040h)).execute();
    }

    @Override // us.pinguo.smaatoapi.a.InterfaceC0444a
    public void d(String str) {
        z(false);
        B(str);
        t(str);
        f fVar = new f(this.f9033d.get(), this.f9034e, this.f9040h);
        fVar.e("0", str);
        fVar.execute();
    }

    @Override // us.pinguo.smaatoapi.a.InterfaceC0444a
    public void f(us.pinguo.smaatoapi.a aVar) {
        a aVar2 = new a(this.f9034e, aVar, this.f9040h);
        new c(this.f9033d.get(), this.f9034e, aVar2, PgAdvConstants$CountMode.NORMAL).execute();
        s(aVar2);
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        this.f11975k = System.currentTimeMillis();
        InsertitialLoader.b(this.f9033d.get()).c(this, this.f11974j, this.f9034e.placementId);
        return false;
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        return 35;
    }

    @Override // us.pinguo.smaatoapi.a.InterfaceC0444a
    public void onInterstitialDismissed() {
    }

    @Override // us.pinguo.smaatoapi.a.InterfaceC0444a
    public void onInterstitialImpression() {
    }
}
