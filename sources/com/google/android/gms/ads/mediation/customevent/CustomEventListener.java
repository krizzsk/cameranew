package com.google.android.gms.ads.mediation.customevent;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface CustomEventListener {
    void onAdClicked();

    void onAdClosed();

    @Deprecated
    void onAdFailedToLoad(int i2);

    void onAdFailedToLoad(@NonNull AdError adError);

    void onAdLeftApplication();

    void onAdOpened();
}
