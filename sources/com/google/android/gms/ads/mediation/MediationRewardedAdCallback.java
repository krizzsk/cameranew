package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.rewarded.RewardItem;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface MediationRewardedAdCallback extends MediationAdCallback {
    void onAdFailedToShow(@NonNull AdError adError);

    @Deprecated
    void onAdFailedToShow(String str);

    void onUserEarnedReward(RewardItem rewardItem);

    void onVideoComplete();

    void onVideoStart();
}
