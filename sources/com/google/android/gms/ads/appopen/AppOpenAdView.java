package com.google.android.gms.ads.appopen;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzsj;
import com.google.android.gms.internal.ads.zzvs;
import com.google.android.gms.internal.ads.zzxl;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class AppOpenAdView extends ViewGroup {
    private AppOpenAd a;
    private AppOpenAdPresentationCallback b;

    public AppOpenAdView(Context context) {
        super(context);
        q.k(context, "Context cannot be null");
    }

    private final AdSize a() {
        zzxl zzdx = this.a.zzdx();
        if (zzdx != null) {
            try {
                zzvs zzkg = zzdx.zzkg();
                if (zzkg != null) {
                    return zzkg.zzqi();
                }
                return null;
            } catch (RemoteException e2) {
                zzazk.zze("#007 Could not call remote method.", e2);
                return null;
            }
        }
        return null;
    }

    private final void b() {
        AppOpenAd appOpenAd = this.a;
        if (appOpenAd == null || this.b == null) {
            return;
        }
        appOpenAd.zza(new zzsj(this.b));
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
                adSize = a();
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

    public final void setAppOpenAd(AppOpenAd appOpenAd) {
        b zzke;
        try {
            zzxl zzdx = appOpenAd.zzdx();
            if (zzdx == null || (zzke = zzdx.zzke()) == null) {
                return;
            }
            View view = (View) d.y0(zzke);
            if (view.getParent() == null) {
                removeAllViews();
                addView(view);
                this.a = appOpenAd;
                b();
                return;
            }
            zzazk.zzev("Trying to set AppOpenAd which is already in use.");
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setAppOpenAdPresentationCallback(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.b = appOpenAdPresentationCallback;
        b();
    }

    public AppOpenAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppOpenAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
