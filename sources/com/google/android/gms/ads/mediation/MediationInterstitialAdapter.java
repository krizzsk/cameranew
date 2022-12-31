package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface MediationInterstitialAdapter extends MediationAdapter {
    void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2);

    void showInterstitial();
}
