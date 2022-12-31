package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.InterstitialAd;
@Keep
@UiThread
/* loaded from: classes.dex */
public interface InterstitialAdApi extends FullScreenAd {
    @Override // com.facebook.ads.FullScreenAd
    InterstitialAd.InterstitialAdLoadConfigBuilder buildLoadAdConfig();

    @Override // com.facebook.ads.FullScreenAd
    InterstitialAd.InterstitialAdShowConfigBuilder buildShowAdConfig();

    boolean isAdLoaded();

    void loadAd(InterstitialAd.InterstitialLoadAdConfig interstitialLoadAdConfig);

    void registerAdCompanionView(AdCompanionView adCompanionView);

    @Override // com.facebook.ads.Ad
    @Deprecated
    void setExtraHints(ExtraHints extraHints);

    @Override // com.facebook.ads.FullScreenAd
    boolean show();

    boolean show(InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig);

    void unregisterAdCompanionView();
}
