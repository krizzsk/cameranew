package com.google.android.gms.ads.instream;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MediaAspectRatio;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzakf;
import com.google.android.gms.internal.ads.zzakg;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class InstreamAd {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static abstract class InstreamAdLoadCallback {
        @Deprecated
        public void onInstreamAdFailedToLoad(int i2) {
        }

        public void onInstreamAdFailedToLoad(LoadAdError loadAdError) {
        }

        public void onInstreamAdLoaded(InstreamAd instreamAd) {
        }
    }

    public static void load(Context context, String str, AdRequest adRequest, @MediaAspectRatio int i2, InstreamAdLoadCallback instreamAdLoadCallback) {
        q.b(i2 == 2 || i2 == 3, "Instream ads only support Landscape and Portrait media aspect ratios");
        new zzakg(context, str).zza(instreamAdLoadCallback).zza(new zzakf(i2)).zzui().loadAd(adRequest);
    }

    public abstract void destroy();

    @Deprecated
    public abstract float getAspectRatio();

    public abstract MediaContent getMediaContent();

    @Deprecated
    public abstract VideoController getVideoController();

    @Deprecated
    public abstract float getVideoCurrentTime();

    @Deprecated
    public abstract float getVideoDuration();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zza(InstreamAdView instreamAdView);

    public static void load(Context context, String str, InstreamAdLoadCallback instreamAdLoadCallback) {
        new zzakg(context, "").zza(instreamAdLoadCallback).zza(new zzakf(str)).zzui().loadAd(new PublisherAdRequest.Builder().build());
    }
}
