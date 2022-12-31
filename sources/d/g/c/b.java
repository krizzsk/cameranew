package d.g.c;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.a.h;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.network.f;
/* compiled from: PGFBBannerRequest.java */
/* loaded from: classes3.dex */
public class b extends us.pinguo.advsdk.a.d<d.g.c.a> {

    /* renamed from: j  reason: collision with root package name */
    private long f8594j;

    /* renamed from: k  reason: collision with root package name */
    private AdView f8595k;

    /* renamed from: l  reason: collision with root package name */
    AdListener f8596l;

    /* compiled from: PGFBBannerRequest.java */
    /* loaded from: classes3.dex */
    class a implements AdListener {
        a() {
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            b bVar = b.this;
            bVar.s(new d.g.c.a(((us.pinguo.advsdk.a.a) bVar).f9034e, ((us.pinguo.advsdk.a.d) b.this).f9040h));
            new us.pinguo.advsdk.network.c((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, new d.g.c.a(((us.pinguo.advsdk.a.a) b.this).f9034e, ((us.pinguo.advsdk.a.d) b.this).f9040h), PgAdvConstants$CountMode.NORMAL).execute();
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            b.this.z(false);
            b.this.E();
            b.this.A(System.currentTimeMillis() - b.this.f8594j);
            b bVar = b.this;
            bVar.x(new d.g.c.a(((us.pinguo.advsdk.a.a) bVar).f9034e, ((us.pinguo.advsdk.a.d) b.this).f9040h));
            ViewGroup viewGroup = (ViewGroup) b.this.g("container");
            viewGroup.removeAllViews();
            viewGroup.addView(b.this.f8595k);
            viewGroup.setVisibility(0);
            VdsAgent.onSetViewVisibility(viewGroup, 0);
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, AdError adError) {
            b.this.z(false);
            b.this.t(adError.getErrorMessage());
            b.this.B(adError.getErrorMessage());
            f fVar = new f((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, ((us.pinguo.advsdk.a.d) b.this).f9040h);
            fVar.e("0", adError.getErrorMessage());
            fVar.execute();
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
            b bVar = b.this;
            bVar.s(new d.g.c.a(((us.pinguo.advsdk.a.a) bVar).f9034e, ((us.pinguo.advsdk.a.d) b.this).f9040h));
        }
    }

    public b(AdsItem adsItem, h hVar) {
        super(adsItem);
        this.f8594j = 0L;
        this.f8596l = new a();
        y(hVar);
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        this.f8594j = System.currentTimeMillis();
        D();
        if (this.f9033d.get() == null) {
            return true;
        }
        AdView adView = new AdView(this.f9033d.get(), this.f9034e.placementId, AdSize.BANNER_HEIGHT_50);
        this.f8595k = adView;
        adView.loadAd(adView.buildLoadAdConfig().withAdListener(this.f8596l).build());
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
