package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzavb extends zzaux {
    @Nullable
    private RewardedVideoAdListener zzckz;

    public zzavb(@Nullable RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzckz = rewardedVideoAdListener;
    }

    @Nullable
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        return this.zzckz;
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoAdClosed() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoAdFailedToLoad(int i2) {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdFailedToLoad(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoAdLeftApplication() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoAdLoaded() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoAdOpened() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoCompleted() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoCompleted();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void onRewardedVideoStarted() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoStarted();
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzckz = rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void zza(zzauk zzaukVar) {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzckz;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewarded(new zzauz(zzaukVar));
        }
    }
}
