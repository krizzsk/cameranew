package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.d;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.ads.zzazk;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@KeepName
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, c>, MediationInterstitialAdapter<CustomEventExtras, c> {
    private View a;
    private CustomEventBanner b;
    private CustomEventInterstitial c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes.dex */
    public class a implements com.google.ads.mediation.customevent.b {
        public a(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, d dVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes.dex */
    public static final class b implements com.google.ads.mediation.customevent.a {
        public b(CustomEventAdapter customEventAdapter, com.google.ads.mediation.c cVar) {
        }
    }

    private static <T> T a(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzazk.zzex(sb.toString());
            return null;
        }
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter, com.google.ads.mediation.b
    public final void destroy() {
        CustomEventBanner customEventBanner = this.b;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.c;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter, com.google.ads.mediation.b
    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.a;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter, com.google.ads.mediation.b
    public final Class<c> getServerParametersType() {
        return c.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(com.google.ads.mediation.c cVar, Activity activity, c cVar2, com.google.ads.a aVar, com.google.ads.mediation.a aVar2, CustomEventExtras customEventExtras) {
        CustomEventBanner customEventBanner = (CustomEventBanner) a(cVar2.b);
        this.b = customEventBanner;
        if (customEventBanner == null) {
            cVar.onFailedToReceiveAd(this, AdRequest$ErrorCode.INTERNAL_ERROR);
            return;
        }
        this.b.requestBannerAd(new b(this, cVar), activity, cVar2.a, cVar2.c, aVar, aVar2, customEventExtras == null ? null : customEventExtras.getExtra(cVar2.a));
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(d dVar, Activity activity, c cVar, com.google.ads.mediation.a aVar, CustomEventExtras customEventExtras) {
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) a(cVar.b);
        this.c = customEventInterstitial;
        if (customEventInterstitial == null) {
            dVar.onFailedToReceiveAd(this, AdRequest$ErrorCode.INTERNAL_ERROR);
            return;
        }
        this.c.requestInterstitialAd(new a(this, this, dVar), activity, cVar.a, cVar.c, aVar, customEventExtras == null ? null : customEventExtras.getExtra(cVar.a));
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.c.showInterstitial();
    }
}
