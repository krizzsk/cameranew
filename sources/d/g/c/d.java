package d.g.c;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.a.h;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.network.e;
import us.pinguo.advsdk.network.f;
/* compiled from: PGGoogleBannerRequest.java */
/* loaded from: classes3.dex */
public class d extends us.pinguo.advsdk.a.d<c> {

    /* renamed from: j  reason: collision with root package name */
    private long f8597j;

    /* renamed from: k  reason: collision with root package name */
    private AdView f8598k;

    /* compiled from: PGGoogleBannerRequest.java */
    /* loaded from: classes3.dex */
    class a extends AdListener {
        a() {
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzvc
        public void onAdClicked() {
            d dVar = d.this;
            dVar.s(new c(((us.pinguo.advsdk.a.a) dVar).f9034e, ((us.pinguo.advsdk.a.d) d.this).f9040h, d.this.f8598k));
            new us.pinguo.advsdk.network.c((Context) ((us.pinguo.advsdk.a.a) d.this).f9033d.get(), ((us.pinguo.advsdk.a.a) d.this).f9034e, new c(((us.pinguo.advsdk.a.a) d.this).f9034e, ((us.pinguo.advsdk.a.d) d.this).f9040h, d.this.f8598k), PgAdvConstants$CountMode.NORMAL).execute();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(int i2) {
            d.this.z(false);
            d.this.t(String.valueOf(i2));
            d.this.B(String.valueOf(i2));
            f fVar = new f((Context) ((us.pinguo.advsdk.a.a) d.this).f9033d.get(), ((us.pinguo.advsdk.a.a) d.this).f9034e, ((us.pinguo.advsdk.a.d) d.this).f9040h);
            fVar.e("0", String.valueOf(i2));
            fVar.execute();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            new e((Context) ((us.pinguo.advsdk.a.a) d.this).f9033d.get(), ((us.pinguo.advsdk.a.a) d.this).f9034e, new c(((us.pinguo.advsdk.a.a) d.this).f9034e, ((us.pinguo.advsdk.a.d) d.this).f9040h, d.this.f8598k)).execute();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            d.this.z(false);
            d.this.E();
            d.this.A(System.currentTimeMillis() - d.this.f8597j);
            d dVar = d.this;
            dVar.x(new c(((us.pinguo.advsdk.a.a) dVar).f9034e, ((us.pinguo.advsdk.a.d) d.this).f9040h, d.this.f8598k));
        }
    }

    public d(AdsItem adsItem, h hVar) {
        super(adsItem);
        this.f8597j = 0L;
        y(hVar);
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        this.f8597j = System.currentTimeMillis();
        D();
        if (this.f9033d.get() == null) {
            return true;
        }
        AdView adView = new AdView(this.f9033d.get());
        this.f8598k = adView;
        adView.setAdSize(AdSize.SMART_BANNER);
        this.f8598k.setAdUnitId(this.f9034e.placementId);
        this.f8598k.setAdListener(new a());
        this.f8598k.loadAd(new AdRequest.Builder().build());
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
