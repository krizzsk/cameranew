package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzzm;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class SearchAdView extends ViewGroup {
    private final zzzm a;

    public SearchAdView(Context context) {
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

    public final String getAdUnitId() {
        return this.a.getAdUnitId();
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(SearchAdRequest searchAdRequest) {
        this.a.zza(searchAdRequest.a());
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

    public final void resume() {
        this.a.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.a.setAdListener(adListener);
    }

    public final void setAdSize(AdSize adSize) {
        this.a.setAdSizes(adSize);
    }

    public final void setAdUnitId(String str) {
        this.a.setAdUnitId(str);
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (AdSize.SEARCH.equals(getAdSize())) {
            this.a.zza(dynamicHeightSearchAdRequest.a());
            return;
        }
        throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
    }

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new zzzm(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new zzzm(this, attributeSet, false);
    }
}
