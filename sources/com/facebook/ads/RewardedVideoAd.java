package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.facebook.ads.Ad;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.internal.api.AdCompanionView;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;
@Keep
@UiThread
/* loaded from: classes.dex */
public class RewardedVideoAd implements FullScreenAd {
    public static final int UNSET_VIDEO_DURATION = -1;
    private final RewardedVideoAdApi mRewardedVideoAdApi;

    @Keep
    /* loaded from: classes.dex */
    public interface RewardedVideoAdLoadConfigBuilder extends Ad.LoadConfigBuilder {
        @Override // com.facebook.ads.Ad.LoadConfigBuilder
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoLoadAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withAdCompanionView(boolean z);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withAdExperience(AdExperienceType adExperienceType);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withAdListener(RewardedVideoAdListener rewardedVideoAdListener);

        @Override // com.facebook.ads.Ad.LoadConfigBuilder
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withBid(String str);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withFailOnCacheFailureEnabled(boolean z);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withRewardData(RewardData rewardData);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface RewardedVideoAdShowConfigBuilder extends FullScreenAd.ShowConfigBuilder {
        @Override // com.facebook.ads.FullScreenAd.ShowConfigBuilder
        RewardedVideoShowAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdShowConfigBuilder withAppOrientation(int i2);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface RewardedVideoLoadAdConfig extends Ad.LoadAdConfig {
    }

    @Keep
    /* loaded from: classes.dex */
    public interface RewardedVideoShowAdConfig extends FullScreenAd.ShowAdConfig {
    }

    @Benchmark
    public RewardedVideoAd(Context context, String str) {
        this.mRewardedVideoAdApi = DynamicLoaderFactory.makeLoader(context).createRewardedVideoAd(context, str, this);
    }

    @Override // com.facebook.ads.Ad
    public void destroy() {
        this.mRewardedVideoAdApi.destroy();
    }

    @Override // com.facebook.ads.Ad
    public String getPlacementId() {
        return this.mRewardedVideoAdApi.getPlacementId();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public int getVideoDuration() {
        return this.mRewardedVideoAdApi.getVideoDuration();
    }

    @Override // com.facebook.ads.Ad
    public boolean isAdInvalidated() {
        return this.mRewardedVideoAdApi.isAdInvalidated();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mRewardedVideoAdApi.isAdLoaded();
    }

    @Override // com.facebook.ads.Ad
    public void loadAd() {
        this.mRewardedVideoAdApi.loadAd();
    }

    public void registerAdCompanionView(AdCompanionView adCompanionView) {
        Preconditions.checkIsOnMainThread();
        this.mRewardedVideoAdApi.registerAdCompanionView(adCompanionView);
    }

    @Override // com.facebook.ads.Ad
    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mRewardedVideoAdApi.setExtraHints(extraHints);
    }

    @Override // com.facebook.ads.FullScreenAd
    public boolean show() {
        return this.mRewardedVideoAdApi.show();
    }

    public void unregisterAdCompanionView() {
        Preconditions.checkIsOnMainThread();
        this.mRewardedVideoAdApi.unregisterAdCompanionView();
    }

    @Override // com.facebook.ads.FullScreenAd
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public RewardedVideoAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mRewardedVideoAdApi.buildLoadAdConfig();
    }

    @Override // com.facebook.ads.FullScreenAd
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public RewardedVideoAdShowConfigBuilder buildShowAdConfig() {
        return this.mRewardedVideoAdApi.buildShowAdConfig();
    }

    @Benchmark
    public void loadAd(RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig) {
        this.mRewardedVideoAdApi.loadAd(rewardedVideoLoadAdConfig);
    }

    @Benchmark
    public boolean show(RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        return this.mRewardedVideoAdApi.show(rewardedVideoShowAdConfig);
    }
}
