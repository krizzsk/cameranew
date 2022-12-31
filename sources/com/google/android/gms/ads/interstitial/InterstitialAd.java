package com.google.android.gms.ads.interstitial;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzakj;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class InterstitialAd {
    public static void load(@NonNull Context context, @NonNull String str, @NonNull AdRequest adRequest, @NonNull InterstitialAdLoadCallback interstitialAdLoadCallback) {
        q.k(context, "Context cannot be null.");
        q.k(str, "AdUnitId cannot be null.");
        q.k(adRequest, "AdRequest cannot be null.");
        q.k(interstitialAdLoadCallback, "LoadCallback cannot be null.");
        new zzakj(context, str).zza(adRequest.zzds(), interstitialAdLoadCallback);
    }

    @NonNull
    public abstract String getAdUnitId();

    @Nullable
    public abstract FullScreenContentCallback getFullScreenContentCallback();

    @Nullable
    public abstract OnPaidEventListener getOnPaidEventListener();

    @Nullable
    public abstract ResponseInfo getResponseInfo();

    public abstract void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback);

    public abstract void setImmersiveMode(boolean z);

    public abstract void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener);

    public abstract void show(@NonNull Activity activity);
}
