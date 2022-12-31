package com.bytedance.sdk.openadsdk;
/* loaded from: classes.dex */
public interface TTFeedAd extends TTNativeAd {

    /* loaded from: classes.dex */
    public interface VideoAdListener {
        void onProgressUpdate(long j2, long j3);

        void onVideoAdComplete(TTFeedAd tTFeedAd);

        void onVideoAdContinuePlay(TTFeedAd tTFeedAd);

        void onVideoAdPaused(TTFeedAd tTFeedAd);

        void onVideoAdStartPlay(TTFeedAd tTFeedAd);

        void onVideoError(int i2, int i3);

        void onVideoLoad(TTFeedAd tTFeedAd);
    }

    double getVideoDuration();

    void setVideoAdListener(VideoAdListener videoAdListener);
}
