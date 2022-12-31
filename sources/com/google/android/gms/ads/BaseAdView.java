package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzvc;
import com.google.android.gms.internal.ads.zzzm;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class BaseAdView extends ViewGroup {
    protected final zzzm a;

    public BaseAdView(Context context, int i2) {
        super(context);
        this.a = new zzzm(this, i2);
    }

    public void destroy() {
        this.a.destroy();
    }

    public AdListener getAdListener() {
        return this.a.getAdListener();
    }

    public AdSize getAdSize() {
        return this.a.getAdSize();
    }

    public String getAdUnitId() {
        return this.a.getAdUnitId();
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        return this.a.getMediationAdapterClassName();
    }

    @Nullable
    public ResponseInfo getResponseInfo() {
        return this.a.getResponseInfo();
    }

    public boolean isLoading() {
        return this.a.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.a.zza(adRequest.zzds());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
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
    protected void onMeasure(int i2, int i3) {
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

    public void pause() {
        this.a.pause();
    }

    public void resume() {
        this.a.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.a.setAdListener(adListener);
        if (adListener == null) {
            this.a.zza((zzvc) null);
            this.a.zza((AppEventListener) null);
            return;
        }
        if (adListener instanceof zzvc) {
            this.a.zza((zzvc) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.a.zza((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.a.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.a.setAdUnitId(str);
    }

    public void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.a.setOnPaidEventListener(onPaidEventListener);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.a = new zzzm(this, attributeSet, false, i2);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.a = new zzzm(this, attributeSet, false, i3);
    }
}
