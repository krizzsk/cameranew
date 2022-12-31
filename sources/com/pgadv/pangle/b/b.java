package com.pgadv.pangle.b;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.a.d;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.network.c;
import us.pinguo.advsdk.network.e;
import us.pinguo.advsdk.network.f;
/* compiled from: PGPangleInterstitialRequest.java */
/* loaded from: classes3.dex */
public class b extends d<com.pgadv.pangle.b.a> {

    /* renamed from: j  reason: collision with root package name */
    private long f5976j;

    /* compiled from: PGPangleInterstitialRequest.java */
    /* loaded from: classes3.dex */
    class a implements TTAdNative.FullScreenVideoAdListener {

        /* compiled from: PGPangleInterstitialRequest.java */
        /* renamed from: com.pgadv.pangle.b.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0228a implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
            final /* synthetic */ TTFullScreenVideoAd a;

            C0228a(TTFullScreenVideoAd tTFullScreenVideoAd) {
                this.a = tTFullScreenVideoAd;
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClose() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdShow() {
                new e((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, new com.pgadv.pangle.b.a(((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h, this.a)).execute();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() {
                com.pgadv.pangle.b.a aVar = new com.pgadv.pangle.b.a(((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h, this.a);
                new c((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, aVar, PgAdvConstants$CountMode.NORMAL).execute();
                b.this.s(aVar);
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoComplete() {
            }
        }

        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i2, String str) {
            b.this.z(false);
            b.this.B(str);
            b.this.t(str);
            f fVar = new f((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h);
            fVar.e(i2 + "", str);
            fVar.execute();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            b.this.z(false);
            com.pgadv.pangle.b.a aVar = new com.pgadv.pangle.b.a(((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h, tTFullScreenVideoAd);
            b.this.E();
            b.this.A(System.currentTimeMillis() - b.this.f5976j);
            b.this.l(aVar);
            b bVar = b.this;
            bVar.x(bVar.o());
            tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new C0228a(tTFullScreenVideoAd));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
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
        this.f5976j = System.currentTimeMillis();
        TTAdSdk.getAdManager().createAdNative(this.f9033d.get()).loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.f9034e.placementId).setSupportDeepLink(true).setAdCount(1).setOrientation(1).build(), new a());
        return false;
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        return 0;
    }
}
