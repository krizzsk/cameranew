package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class NativeExpressAdView extends BaseAdView {
    public NativeExpressAdView(Context context) {
        super(context, 1);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ AdListener getAdListener() {
        return super.getAdListener();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ AdSize getAdSize() {
        return super.getAdSize();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ String getAdUnitId() {
        return super.getAdUnitId();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    @Deprecated
    public final /* bridge */ /* synthetic */ String getMediationAdapterClassName() {
        return super.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    @Nullable
    public final /* bridge */ /* synthetic */ ResponseInfo getResponseInfo() {
        return super.getResponseInfo();
    }

    public final VideoController getVideoController() {
        return this.a.getVideoController();
    }

    public final VideoOptions getVideoOptions() {
        return this.a.getVideoOptions();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ boolean isLoading() {
        return super.isLoading();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    @RequiresPermission("android.permission.INTERNET")
    public final /* bridge */ /* synthetic */ void loadAd(AdRequest adRequest) {
        super.loadAd(adRequest);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void resume() {
        super.resume();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void setAdListener(AdListener adListener) {
        super.setAdListener(adListener);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void setAdSize(AdSize adSize) {
        super.setAdSize(adSize);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void setAdUnitId(String str) {
        super.setAdUnitId(str);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        super.setOnPaidEventListener(onPaidEventListener);
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.a.setVideoOptions(videoOptions);
    }

    public NativeExpressAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
    }

    public NativeExpressAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, 1);
    }
}
