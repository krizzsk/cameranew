package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface MediationNativeListener {
    void onAdClicked(MediationNativeAdapter mediationNativeAdapter);

    void onAdClosed(MediationNativeAdapter mediationNativeAdapter);

    @Deprecated
    void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i2);

    void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, @NonNull AdError adError);

    void onAdImpression(MediationNativeAdapter mediationNativeAdapter);

    void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter);

    @Deprecated
    void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper);

    void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper);

    void onAdOpened(MediationNativeAdapter mediationNativeAdapter);

    void onVideoEnd(MediationNativeAdapter mediationNativeAdapter);

    void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd);

    void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str);
}
