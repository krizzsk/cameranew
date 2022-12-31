package com.google.android.gms.ads.admanager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzxl;
import com.google.android.gms.internal.ads.zzzm;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class AdManagerAdView extends ViewGroup {
    private final zzzm a;

    public AdManagerAdView(Context context) {
        super(context);
        this.a = new zzzm(this);
    }

    public final void destroy() {
        this.a.destroy();
    }

    public final AdListener getAdListener() {
        return this.a.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.a.getAdSize();
    }

    public final AdSize[] getAdSizes() {
        return this.a.getAdSizes();
    }

    public final String getAdUnitId() {
        return this.a.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.a.getAppEventListener();
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        return this.a.getResponseInfo();
    }

    public final VideoController getVideoController() {
        return this.a.getVideoController();
    }

    public final VideoOptions getVideoOptions() {
        return this.a.getVideoOptions();
    }

    public final boolean isLoading() {
        return this.a.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdManagerAdRequest adManagerAdRequest) {
        this.a.zza(adManagerAdRequest.zzds());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i6 = ((i4 - i2) - measuredWidth) / 2;
        int i7 = ((i5 - i3) - measuredHeight) / 2;
        childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i3) {
        int i4;
        int i5 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i2, i3);
            i5 = childAt.getMeasuredWidth();
            i4 = childAt.getMeasuredHeight();
        } else {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e2) {
                zzazk.zzc("Unable to retrieve ad size.", e2);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i4 = adSize.getHeightInPixels(context);
                i5 = widthInPixels;
            } else {
                i4 = 0;
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(i5, getSuggestedMinimumWidth()), i2), View.resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i3));
    }

    public final void pause() {
        this.a.pause();
    }

    public final void recordManualImpression() {
        this.a.recordManualImpression();
    }

    public final void resume() {
        this.a.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.a.setAdListener(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr != null && adSizeArr.length > 0) {
            this.a.zza(adSizeArr);
            return;
        }
        throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    }

    public final void setAdUnitId(String str) {
        this.a.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.a.setAppEventListener(appEventListener);
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.a.setManualImpressionsEnabled(z);
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.a.setVideoOptions(videoOptions);
    }

    public final boolean zza(zzxl zzxlVar) {
        return this.a.zza(zzxlVar);
    }

    public AdManagerAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new zzzm(this, attributeSet, true);
        q.k(context, "Context cannot be null");
    }

    public AdManagerAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new zzzm(this, attributeSet, true);
    }
}
