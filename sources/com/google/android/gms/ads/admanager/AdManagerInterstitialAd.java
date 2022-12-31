package com.google.android.gms.ads.admanager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzakj;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class AdManagerInterstitialAd extends InterstitialAd {
    public static void load(@NonNull Context context, @NonNull String str, @NonNull AdManagerAdRequest adManagerAdRequest, @NonNull AdManagerInterstitialAdLoadCallback adManagerInterstitialAdLoadCallback) {
        q.k(context, "Context cannot be null.");
        q.k(str, "AdUnitId cannot be null.");
        q.k(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        q.k(adManagerInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        new zzakj(context, str).zza(adManagerAdRequest.zzds(), adManagerInterstitialAdLoadCallback);
    }

    @Nullable
    public abstract AppEventListener getAppEventListener();

    public abstract void setAppEventListener(@Nullable AppEventListener appEventListener);
}
