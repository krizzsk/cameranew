package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzzo;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class PublisherInterstitialAd {
    private final zzzo a;

    public PublisherInterstitialAd(Context context) {
        this.a = new zzzo(context, this);
        q.k(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.a.getAdListener();
    }

    public final String getAdUnitId() {
        return this.a.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.a.getAppEventListener();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.a.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.a.getOnCustomRenderedAdLoadedListener();
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        return this.a.getResponseInfo();
    }

    public final boolean isLoaded() {
        return this.a.isLoaded();
    }

    public final boolean isLoading() {
        return this.a.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.a.zza(publisherAdRequest.zzds());
    }

    public final void setAdListener(AdListener adListener) {
        this.a.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.a.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.a.setAppEventListener(appEventListener);
    }

    @Deprecated
    public final void setCorrelator(Correlator correlator) {
    }

    public final void setImmersiveMode(boolean z) {
        this.a.setImmersiveMode(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.a.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void show() {
        this.a.show();
    }
}
