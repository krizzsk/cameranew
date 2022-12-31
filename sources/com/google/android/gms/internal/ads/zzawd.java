package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzawd extends zzavq {
    @Nullable
    private FullScreenContentCallback zzbuw;
    @Nullable
    private RewardedAdCallback zzdzp;

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedAdClosed() {
        RewardedAdCallback rewardedAdCallback = this.zzdzp;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
        FullScreenContentCallback fullScreenContentCallback = this.zzbuw;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedAdFailedToShow(int i2) {
        RewardedAdCallback rewardedAdCallback = this.zzdzp;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedAdOpened() {
        RewardedAdCallback rewardedAdCallback = this.zzdzp;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
        FullScreenContentCallback fullScreenContentCallback = this.zzbuw;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbuw = fullScreenContentCallback;
    }

    public final void zza(RewardedAdCallback rewardedAdCallback) {
        this.zzdzp = rewardedAdCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzi(zzvg zzvgVar) {
        AdError zzqb = zzvgVar.zzqb();
        RewardedAdCallback rewardedAdCallback = this.zzdzp;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(zzqb);
        }
        FullScreenContentCallback fullScreenContentCallback = this.zzbuw;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzqb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zza(zzavl zzavlVar) {
        RewardedAdCallback rewardedAdCallback = this.zzdzp;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzawa(zzavlVar));
        }
    }
}
