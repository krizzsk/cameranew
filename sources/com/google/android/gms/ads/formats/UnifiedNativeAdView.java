package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzaec;
import com.google.android.gms.internal.ads.zzaee;
import com.google.android.gms.internal.ads.zzaem;
import com.google.android.gms.internal.ads.zzaev;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzwr;
import com.google.android.gms.internal.ads.zzzw;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class UnifiedNativeAdView extends FrameLayout {
    private final FrameLayout a;
    private final zzaev b;

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.a = e(context);
        this.b = f();
    }

    private final void c(String str, View view) {
        try {
            this.b.zzb(str, com.google.android.gms.dynamic.d.z0(view));
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to call setAssetView on delegate", e2);
        }
    }

    private final View d(String str) {
        try {
            com.google.android.gms.dynamic.b zzco = this.b.zzco(str);
            if (zzco != null) {
                return (View) com.google.android.gms.dynamic.d.y0(zzco);
            }
            return null;
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to call getAssetView on delegate", e2);
            return null;
        }
    }

    private final FrameLayout e(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaev f() {
        q.k(this.a, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwr.zzqo().zza(this.a.getContext(), this, this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            try {
                this.b.zzh(com.google.android.gms.dynamic.d.z0(scaleType));
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call setMediaViewImageScaleType on delegate", e2);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        super.bringChildToFront(this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(MediaContent mediaContent) {
        try {
            if (mediaContent instanceof zzzw) {
                this.b.zza(((zzzw) mediaContent).zzrt());
            } else if (mediaContent == null) {
                this.b.zza((zzaem) null);
            } else {
                zzazk.zzdy("Use MediaContent provided by UnifiedNativeAd.getMediaContent");
            }
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to call setMediaContent on delegate", e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.a;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final void destroy() {
        try {
            this.b.destroy();
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to destroy native ad view", e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzaev zzaevVar;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcso)).booleanValue() && (zzaevVar = this.b) != null) {
            try {
                zzaevVar.zzg(com.google.android.gms.dynamic.d.z0(motionEvent));
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call handleTouchEvent on delegate", e2);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final AdChoicesView getAdChoicesView() {
        View d2 = d("3011");
        if (d2 instanceof AdChoicesView) {
            return (AdChoicesView) d2;
        }
        return null;
    }

    public final View getAdvertiserView() {
        return d("3005");
    }

    public final View getBodyView() {
        return d("3004");
    }

    public final View getCallToActionView() {
        return d("3002");
    }

    public final View getHeadlineView() {
        return d("3001");
    }

    public final View getIconView() {
        return d("3003");
    }

    public final View getImageView() {
        return d("3008");
    }

    public final MediaView getMediaView() {
        View d2 = d("3010");
        if (d2 instanceof MediaView) {
            return (MediaView) d2;
        }
        if (d2 != null) {
            zzazk.zzdy("View is not an instance of MediaView");
            return null;
        }
        return null;
    }

    public final View getPriceView() {
        return d("3007");
    }

    public final View getStarRatingView() {
        return d("3009");
    }

    public final View getStoreView() {
        return d("3006");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        zzaev zzaevVar = this.b;
        if (zzaevVar != null) {
            try {
                zzaevVar.zzc(com.google.android.gms.dynamic.d.z0(view), i2);
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call onVisibilityChanged on delegate", e2);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.a == view) {
            return;
        }
        super.removeView(view);
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        c("3011", adChoicesView);
    }

    public final void setAdvertiserView(View view) {
        c("3005", view);
    }

    public final void setBodyView(View view) {
        c("3004", view);
    }

    public final void setCallToActionView(View view) {
        c("3002", view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.b.zzf(com.google.android.gms.dynamic.d.z0(view));
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to call setClickConfirmingView on delegate", e2);
        }
    }

    public final void setHeadlineView(View view) {
        c("3001", view);
    }

    public final void setIconView(View view) {
        c("3003", view);
    }

    public final void setImageView(View view) {
        c("3008", view);
    }

    public final void setMediaView(MediaView mediaView) {
        c("3010", mediaView);
        if (mediaView != null) {
            mediaView.a(new zzaec(this) { // from class: com.google.android.gms.ads.formats.d
                private final UnifiedNativeAdView a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzaec
                public final void setMediaContent(MediaContent mediaContent) {
                    this.a.b(mediaContent);
                }
            });
            mediaView.b(new zzaee(this) { // from class: com.google.android.gms.ads.formats.e
                private final UnifiedNativeAdView a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzaee
                public final void setImageScaleType(ImageView.ScaleType scaleType) {
                    this.a.a(scaleType);
                }
            });
        }
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.b.zza((com.google.android.gms.dynamic.b) unifiedNativeAd.zzjs());
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to call setNativeAd on delegate", e2);
        }
    }

    public final void setPriceView(View view) {
        c("3007", view);
    }

    public final void setStarRatingView(View view) {
        c("3009", view);
    }

    public final void setStoreView(View view) {
        c("3006", view);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = e(context);
        this.b = f();
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = e(context);
        this.b = f();
    }

    @TargetApi(21)
    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = e(context);
        this.b = f();
    }
}
