package com.pgadv.facebook;

import android.content.Context;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.a.d;
import us.pinguo.advsdk.a.h;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.network.f;
/* compiled from: PGFacebookRequest.java */
/* loaded from: classes3.dex */
class c extends d<b> {

    /* compiled from: PGFacebookRequest.java */
    /* loaded from: classes3.dex */
    private class a implements NativeAdListener {
        private long a;
        private long b;

        public a(long j2) {
            this.a = 0L;
            this.b = 0L;
            this.b = System.currentTimeMillis();
            this.a = j2;
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            if (((us.pinguo.advsdk.a.a) c.this).f9033d == null) {
                us.pinguo.advsdk.utils.b.a(c.this.q() + " click context isnull");
                return;
            }
            NativeAd nativeAd = (NativeAd) ad;
            new us.pinguo.advsdk.network.c((Context) ((us.pinguo.advsdk.a.a) c.this).f9033d.get(), ((us.pinguo.advsdk.a.a) c.this).f9034e, new b(((us.pinguo.advsdk.a.a) c.this).f9034e, nativeAd, ((d) c.this).f9040h), PgAdvConstants$CountMode.NORMAL).execute();
            c cVar = c.this;
            cVar.s(new b(((us.pinguo.advsdk.a.a) cVar).f9034e, nativeAd, ((d) c.this).f9040h));
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            us.pinguo.advsdk.utils.b.a(c.this.q() + "success:");
            c cVar = c.this;
            cVar.l(new b(((us.pinguo.advsdk.a.a) cVar).f9034e, (NativeAd) ad, ((d) c.this).f9040h));
            if (this.a != ((d) c.this).f9039g) {
                return;
            }
            c.this.A(System.currentTimeMillis() - this.b);
            c.this.E();
            c.this.z(false);
            c cVar2 = c.this;
            cVar2.x(cVar2.o());
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, AdError adError) {
            if (this.a != ((d) c.this).f9039g) {
                return;
            }
            c.this.z(false);
            us.pinguo.advsdk.utils.b.a(c.this.q() + "error:" + adError.getErrorMessage());
            c.this.t(adError.getErrorMessage());
            if (adError != null) {
                c.this.B(adError.getErrorMessage());
                f fVar = new f((Context) ((us.pinguo.advsdk.a.a) c.this).f9033d.get(), ((us.pinguo.advsdk.a.a) c.this).f9034e, ((d) c.this).f9040h);
                fVar.e(String.valueOf(adError.getErrorCode()), adError.getErrorMessage());
                fVar.execute();
            }
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
        }

        @Override // com.facebook.ads.NativeAdListener
        public void onMediaDownloaded(Ad ad) {
        }
    }

    public c(AdsItem adsItem, h hVar) {
        super(adsItem);
        y(hVar);
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return false;
        }
        NativeAd nativeAd = new NativeAd(this.f9033d.get(), this.f9034e.placementId);
        D();
        nativeAd.loadAd(nativeAd.buildLoadAdConfig().withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withAdListener(new a(this.f9039g)).build());
        return true;
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        return 1;
    }
}
