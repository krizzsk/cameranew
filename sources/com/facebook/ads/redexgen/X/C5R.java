package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
/* renamed from: com.facebook.ads.redexgen.X.5R  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5R implements RewardedVideoAd.RewardedVideoAdLoadConfigBuilder, RewardedVideoAd.RewardedVideoLoadAdConfig {
    @Nullable
    public AdExperienceType A00;
    public C5Q A01;
    @Nullable
    public String A02;
    public boolean A03;
    public boolean A04;

    public C5R(C5Q c5q) {
        this.A01 = c5q;
    }

    public final void A00() {
        this.A01.A04(this.A02, this.A00, this.A03, this.A04);
    }

    @Override // com.facebook.ads.RewardedVideoAd.RewardedVideoAdLoadConfigBuilder, com.facebook.ads.Ad.LoadConfigBuilder
    public final RewardedVideoAd.RewardedVideoLoadAdConfig build() {
        return this;
    }

    @Override // com.facebook.ads.RewardedVideoAd.RewardedVideoAdLoadConfigBuilder
    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withAdCompanionView(boolean z) {
        this.A04 = z;
        return this;
    }

    @Override // com.facebook.ads.RewardedVideoAd.RewardedVideoAdLoadConfigBuilder
    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withAdExperience(AdExperienceType adExperienceType) {
        this.A00 = adExperienceType;
        return this;
    }

    @Override // com.facebook.ads.RewardedVideoAd.RewardedVideoAdLoadConfigBuilder
    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.A01.A03(rewardedVideoAdListener);
        return this;
    }

    @Override // com.facebook.ads.RewardedVideoAd.RewardedVideoAdLoadConfigBuilder, com.facebook.ads.Ad.LoadConfigBuilder
    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withBid(String str) {
        this.A02 = str;
        return this;
    }

    @Override // com.facebook.ads.RewardedVideoAd.RewardedVideoAdLoadConfigBuilder
    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withFailOnCacheFailureEnabled(boolean z) {
        this.A03 = z;
        return this;
    }

    @Override // com.facebook.ads.RewardedVideoAd.RewardedVideoAdLoadConfigBuilder
    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder withRewardData(RewardData rewardData) {
        this.A01.A02(rewardData);
        return this;
    }
}
