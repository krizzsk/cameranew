package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzawe extends zzavx {
    private final RewardedAdLoadCallback zzdzq;
    private final RewardedAd zzdzr;

    public zzawe(RewardedAdLoadCallback rewardedAdLoadCallback, RewardedAd rewardedAd) {
        this.zzdzq = rewardedAdLoadCallback;
        this.zzdzr = rewardedAd;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void onRewardedAdFailedToLoad(int i2) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdzq;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void onRewardedAdLoaded() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdzq;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdLoaded();
            this.zzdzq.onAdLoaded(this.zzdzr);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzj(zzvg zzvgVar) {
        if (this.zzdzq != null) {
            LoadAdError zzqc = zzvgVar.zzqc();
            this.zzdzq.onRewardedAdFailedToLoad(zzqc);
            this.zzdzq.onAdFailedToLoad(zzqc);
        }
    }
}
