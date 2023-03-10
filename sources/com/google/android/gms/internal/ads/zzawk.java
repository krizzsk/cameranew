package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzawk extends zzavx {
    private final RewardedInterstitialAdLoadCallback zzdzs;
    private final zzawn zzdzt;

    public zzawk(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzawn zzawnVar) {
        this.zzdzs = rewardedInterstitialAdLoadCallback;
        this.zzdzt = zzawnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void onRewardedAdFailedToLoad(int i2) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdzs;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void onRewardedAdLoaded() {
        zzawn zzawnVar;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdzs;
        if (rewardedInterstitialAdLoadCallback == null || (zzawnVar = this.zzdzt) == null) {
            return;
        }
        rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdLoaded(zzawnVar);
        this.zzdzs.onAdLoaded(this.zzdzt);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzj(zzvg zzvgVar) {
        if (this.zzdzs != null) {
            LoadAdError zzqc = zzvgVar.zzqc();
            this.zzdzs.onRewardedInterstitialAdFailedToLoad(zzqc);
            this.zzdzs.onAdFailedToLoad(zzqc);
        }
    }
}
