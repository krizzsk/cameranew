package com.google.android.gms.ads.rewarded;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public abstract class RewardedAdCallback {
    public static final int ERROR_CODE_AD_REUSED = 1;
    public static final int ERROR_CODE_APP_NOT_FOREGROUND = 3;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_MEDIATION_SHOW_ERROR = 4;
    public static final int ERROR_CODE_NOT_READY = 2;

    public void onRewardedAdClosed() {
    }

    @Deprecated
    public void onRewardedAdFailedToShow(int i2) {
    }

    public void onRewardedAdFailedToShow(AdError adError) {
    }

    public void onRewardedAdOpened() {
    }

    public abstract void onUserEarnedReward(@NonNull RewardItem rewardItem);
}
