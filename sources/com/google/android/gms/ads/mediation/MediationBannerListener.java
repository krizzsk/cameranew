package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface MediationBannerListener {
    void onAdClicked(MediationBannerAdapter mediationBannerAdapter);

    void onAdClosed(MediationBannerAdapter mediationBannerAdapter);

    @Deprecated
    void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i2);

    void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, @NonNull AdError adError);

    void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter);

    void onAdLoaded(MediationBannerAdapter mediationBannerAdapter);

    void onAdOpened(MediationBannerAdapter mediationBannerAdapter);

    void zza(MediationBannerAdapter mediationBannerAdapter, String str, String str2);
}
