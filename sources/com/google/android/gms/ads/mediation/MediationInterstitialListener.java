package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface MediationInterstitialListener {
    void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter);

    @Deprecated
    void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i2);

    void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, @NonNull AdError adError);

    void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter);
}
