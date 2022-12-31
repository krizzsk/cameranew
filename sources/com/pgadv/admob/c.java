package com.pgadv.admob;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.a.d;
import us.pinguo.advsdk.a.h;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.network.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PGGoogleRequest.java */
/* loaded from: classes3.dex */
public class c extends d<com.pgadv.admob.b> {

    /* renamed from: j  reason: collision with root package name */
    private long f5970j;

    /* renamed from: k  reason: collision with root package name */
    private com.pgadv.admob.b f5971k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PGGoogleRequest.java */
    /* loaded from: classes3.dex */
    public class a implements UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {
        a() {
        }

        @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
        public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            c.this.z(false);
            c cVar = c.this;
            cVar.f5971k = new com.pgadv.admob.b(((us.pinguo.advsdk.a.a) cVar).f9034e, unifiedNativeAd, ((d) c.this).f9040h);
            c cVar2 = c.this;
            cVar2.l(cVar2.f5971k);
            c.this.A(System.currentTimeMillis() - c.this.f5970j);
            c cVar3 = c.this;
            cVar3.x(cVar3.o());
            c.this.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PGGoogleRequest.java */
    /* loaded from: classes3.dex */
    public class b extends AdListener {
        private b() {
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzvc
        public void onAdClicked() {
            new us.pinguo.advsdk.network.c((Context) ((us.pinguo.advsdk.a.a) c.this).f9033d.get(), ((us.pinguo.advsdk.a.a) c.this).f9034e, c.this.f5971k, PgAdvConstants$CountMode.NORMAL).execute();
            c cVar = c.this;
            cVar.s(cVar.f5971k);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(int i2) {
            String str;
            c.this.z(false);
            if (i2 == 0) {
                str = "GOOGLE error:内部出现问题。例如，从广告服务器中收到无效响应";
            } else if (i2 == 1) {
                str = "GOOGLE error:广告请求无效。例如，广告单元 ID 不正确";
            } else if (i2 == 2) {
                str = "GOOGLE error:广告请求因网络连接而未成功";
            } else if (i2 == 3) {
                str = "GOOGLE error:广告请求已成功，但因缺少广告库存而未返回广告";
            } else {
                us.pinguo.advsdk.utils.b.a(c.this.q() + "GOOGLE error:" + i2);
                str = "";
            }
            us.pinguo.advsdk.utils.b.a(c.this.q() + str);
            c.this.t(str);
            c cVar = c.this;
            cVar.B(i2 + ":" + str);
            f fVar = new f((Context) ((us.pinguo.advsdk.a.a) c.this).f9033d.get(), ((us.pinguo.advsdk.a.a) c.this).f9034e, ((d) c.this).f9040h);
            fVar.e(String.valueOf(i2), str);
            fVar.execute();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            c.this.z(false);
        }

        /* synthetic */ b(c cVar, a aVar) {
            this();
        }
    }

    public c(AdsItem adsItem, h hVar) {
        super(adsItem);
        this.f5970j = 0L;
        y(hVar);
    }

    public void b0() {
        us.pinguo.advsdk.utils.b.a(q() + "Placementid = " + this.f9034e.placementId);
        D();
        this.f5970j = System.currentTimeMillis();
        b bVar = new b(this, null);
        new AdLoader.Builder(this.f9033d.get(), this.f9034e.placementId).forUnifiedNativeAd(new a()).withAdListener(bVar).withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build()).build().loadAd(new AdRequest.Builder().build());
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        b0();
        return false;
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        return 2;
    }
}
