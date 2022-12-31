package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzvc;
import com.google.android.gms.internal.ads.zzzo;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class InterstitialAd {
    private final zzzo a;

    public InterstitialAd(Context context) {
        this.a = new zzzo(context);
        q.k(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.a.getAdListener();
    }

    public final Bundle getAdMetadata() {
        return this.a.getAdMetadata();
    }

    public final String getAdUnitId() {
        return this.a.getAdUnitId();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.a.getMediationAdapterClassName();
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
    public final void loadAd(AdRequest adRequest) {
        this.a.zza(adRequest.zzds());
    }

    public final void setAdListener(AdListener adListener) {
        this.a.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzvc)) {
            this.a.zza((zzvc) adListener);
        } else if (adListener == null) {
            this.a.zza((zzvc) null);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.a.setAdMetadataListener(adMetadataListener);
    }

    public final void setAdUnitId(String str) {
        this.a.setAdUnitId(str);
    }

    public final void setImmersiveMode(boolean z) {
        this.a.setImmersiveMode(z);
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.a.setOnPaidEventListener(onPaidEventListener);
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.a.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void show() {
        this.a.show();
    }

    public final void zzd(boolean z) {
        this.a.zzd(true);
    }
}
