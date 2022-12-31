package com.google.android.gms.ads.rewardedinterstitial;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzawn;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class RewardedInterstitialAd {
    public static void load(@NonNull Context context, @NonNull String str, @NonNull AdRequest adRequest, @NonNull RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        q.k(context, "Context cannot be null.");
        q.k(str, "AdUnitId cannot be null.");
        q.k(adRequest, "AdRequest cannot be null.");
        q.k(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        new zzawn(context, str).zza(adRequest.zzds(), rewardedInterstitialAdLoadCallback);
    }

    @NonNull
    public abstract Bundle getAdMetadata();

    @NonNull
    public abstract String getAdUnitId();

    @Nullable
    public abstract FullScreenContentCallback getFullScreenContentCallback();

    @Nullable
    public abstract OnAdMetadataChangedListener getOnAdMetadataChangedListener();

    @Nullable
    public abstract OnPaidEventListener getOnPaidEventListener();

    @Nullable
    public abstract ResponseInfo getResponseInfo();

    @NonNull
    public abstract RewardItem getRewardItem();

    public abstract void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback);

    public abstract void setImmersiveMode(boolean z);

    public abstract void setOnAdMetadataChangedListener(@Nullable OnAdMetadataChangedListener onAdMetadataChangedListener);

    public abstract void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener);

    public abstract void setServerSideVerificationOptions(@Nullable ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void show(@Nullable Activity activity, @NonNull OnUserEarnedRewardListener onUserEarnedRewardListener);

    @Deprecated
    public static void load(@NonNull Context context, @NonNull String str, @NonNull PublisherAdRequest publisherAdRequest, @NonNull RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        q.k(context, "Context cannot be null.");
        q.k(str, "AdUnitId cannot be null.");
        q.k(publisherAdRequest, "PublisherAdRequest cannot be null.");
        q.k(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        new zzawn(context, str).zza(publisherAdRequest.zzds(), rewardedInterstitialAdLoadCallback);
    }

    public static void load(@NonNull Context context, @NonNull String str, @NonNull AdManagerAdRequest adManagerAdRequest, @NonNull RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        q.k(context, "Context cannot be null.");
        q.k(str, "AdUnitId cannot be null.");
        q.k(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        q.k(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        new zzawn(context, str).zza(adManagerAdRequest.zzds(), rewardedInterstitialAdLoadCallback);
    }
}
