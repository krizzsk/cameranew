package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.ads.zzazk;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@KeepName
/* loaded from: classes2.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {

    /* renamed from: e  reason: collision with root package name */
    private static final AdError f3556e = new AdError(0, "Could not instantiate custom event adapter", MobileAds.ERROR_DOMAIN);
    private View a;
    private CustomEventBanner b;
    private CustomEventInterstitial c;

    /* renamed from: d  reason: collision with root package name */
    private CustomEventNative f3557d;

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view) {
        this.a = view;
    }

    private static <T> T c(String str) {
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

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.a;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        CustomEventBanner customEventBanner = this.b;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.f3557d;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        CustomEventBanner customEventBanner = this.b;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.f3557d;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        CustomEventBanner customEventBanner = this.b;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.c;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.f3557d;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        CustomEventBanner customEventBanner = (CustomEventBanner) c(bundle.getString("class_name"));
        this.b = customEventBanner;
        if (customEventBanner == null) {
            mediationBannerListener.onAdFailedToLoad(this, f3556e);
            return;
        }
        this.b.requestBannerAd(context, new a(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) c(bundle.getString("class_name"));
        this.c = customEventInterstitial;
        if (customEventInterstitial == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, f3556e);
            return;
        }
        this.c.requestInterstitialAd(context, new c(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        CustomEventNative customEventNative = (CustomEventNative) c(bundle.getString("class_name"));
        this.f3557d = customEventNative;
        if (customEventNative == null) {
            mediationNativeListener.onAdFailedToLoad(this, f3556e);
            return;
        }
        this.f3557d.requestNativeAd(context, new b(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.c.showInterstitial();
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    static final class a implements CustomEventBannerListener {
        private final CustomEventAdapter a;
        private final MediationBannerListener b;

        public a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.a = customEventAdapter;
            this.b = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzazk.zzdy("Custom event adapter called onAdClicked.");
            this.b.onAdClicked(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzazk.zzdy("Custom event adapter called onAdClosed.");
            this.b.onAdClosed(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i2) {
            zzazk.zzdy("Custom event adapter called onAdFailedToLoad.");
            this.b.onAdFailedToLoad(this.a, i2);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzazk.zzdy("Custom event adapter called onAdLeftApplication.");
            this.b.onAdLeftApplication(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
        public final void onAdLoaded(View view) {
            zzazk.zzdy("Custom event adapter called onAdLoaded.");
            this.a.a(view);
            this.b.onAdLoaded(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzazk.zzdy("Custom event adapter called onAdOpened.");
            this.b.onAdOpened(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(AdError adError) {
            zzazk.zzdy("Custom event adapter called onAdFailedToLoad.");
            this.b.onAdFailedToLoad(this.a, adError);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    static class b implements CustomEventNativeListener {
        private final CustomEventAdapter a;
        private final MediationNativeListener b;

        public b(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.a = customEventAdapter;
            this.b = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzazk.zzdy("Custom event adapter called onAdClicked.");
            this.b.onAdClicked(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzazk.zzdy("Custom event adapter called onAdClosed.");
            this.b.onAdClosed(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i2) {
            zzazk.zzdy("Custom event adapter called onAdFailedToLoad.");
            this.b.onAdFailedToLoad(this.a, i2);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdImpression() {
            zzazk.zzdy("Custom event adapter called onAdImpression.");
            this.b.onAdImpression(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzazk.zzdy("Custom event adapter called onAdLeftApplication.");
            this.b.onAdLeftApplication(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzazk.zzdy("Custom event adapter called onAdLoaded.");
            this.b.onAdLoaded(this.a, nativeAdMapper);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzazk.zzdy("Custom event adapter called onAdOpened.");
            this.b.onAdOpened(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(AdError adError) {
            zzazk.zzdy("Custom event adapter called onAdFailedToLoad.");
            this.b.onAdFailedToLoad(this.a, adError);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
            zzazk.zzdy("Custom event adapter called onAdLoaded.");
            this.b.onAdLoaded(this.a, unifiedNativeAdMapper);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    class c implements CustomEventInterstitialListener {
        private final CustomEventAdapter a;
        private final MediationInterstitialListener b;

        public c(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.a = customEventAdapter;
            this.b = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzazk.zzdy("Custom event adapter called onAdClicked.");
            this.b.onAdClicked(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzazk.zzdy("Custom event adapter called onAdClosed.");
            this.b.onAdClosed(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i2) {
            zzazk.zzdy("Custom event adapter called onFailedToReceiveAd.");
            this.b.onAdFailedToLoad(this.a, i2);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzazk.zzdy("Custom event adapter called onAdLeftApplication.");
            this.b.onAdLeftApplication(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
        public final void onAdLoaded() {
            zzazk.zzdy("Custom event adapter called onReceivedAd.");
            this.b.onAdLoaded(CustomEventAdapter.this);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzazk.zzdy("Custom event adapter called onAdOpened.");
            this.b.onAdOpened(this.a);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(AdError adError) {
            zzazk.zzdy("Custom event adapter called onFailedToReceiveAd.");
            this.b.onAdFailedToLoad(this.a, adError);
        }
    }
}
