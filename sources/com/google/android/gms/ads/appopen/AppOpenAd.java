package com.google.android.gms.ads.appopen;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzsq;
import com.google.android.gms.internal.ads.zzsw;
import com.google.android.gms.internal.ads.zzxl;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class AppOpenAd {
    public static final int APP_OPEN_AD_ORIENTATION_LANDSCAPE = 2;
    public static final int APP_OPEN_AD_ORIENTATION_PORTRAIT = 1;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static abstract class AppOpenAdLoadCallback extends AdLoadCallback<AppOpenAd> {
        @Deprecated
        public void onAppOpenAdFailedToLoad(int i2) {
        }

        @Deprecated
        public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
        }

        @Deprecated
        public void onAppOpenAdLoaded(AppOpenAd appOpenAd) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public @interface AppOpenAdOrientation {
    }

    public static void load(Context context, String str, AdRequest adRequest, @AppOpenAdOrientation int i2, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        q.k(context, "Context cannot be null.");
        q.k(str, "adUnitId cannot be null.");
        q.k(adRequest, "AdRequest cannot be null.");
        new zzsw(context, str, adRequest.zzds(), i2, appOpenAdLoadCallback).zzmu();
    }

    @NonNull
    public abstract String getAdUnitId();

    @Nullable
    public abstract FullScreenContentCallback getFullScreenContentCallback();

    public abstract ResponseInfo getResponseInfo();

    public abstract void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback);

    public abstract void setImmersiveMode(boolean z);

    public abstract void show(@NonNull Activity activity);

    @Deprecated
    public abstract void show(Activity activity, FullScreenContentCallback fullScreenContentCallback);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zza(zzsq zzsqVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzxl zzdx();

    @Deprecated
    public static void load(Context context, String str, PublisherAdRequest publisherAdRequest, @AppOpenAdOrientation int i2, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        q.k(context, "Context cannot be null.");
        q.k(str, "adUnitId cannot be null.");
        q.k(publisherAdRequest, "PublisherAdRequest cannot be null.");
        new zzsw(context, str, publisherAdRequest.zzds(), i2, appOpenAdLoadCallback).zzmu();
    }

    public static void load(Context context, String str, AdManagerAdRequest adManagerAdRequest, @AppOpenAdOrientation int i2, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        q.k(context, "Context cannot be null.");
        q.k(str, "adUnitId cannot be null.");
        q.k(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        new zzsw(context, str, adManagerAdRequest.zzds(), i2, appOpenAdLoadCallback).zzmu();
    }
}
