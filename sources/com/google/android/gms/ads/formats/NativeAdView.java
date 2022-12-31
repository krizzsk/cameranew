package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzaev;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzwr;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public class NativeAdView extends FrameLayout {
    private final FrameLayout a;
    private final zzaev b;

    public NativeAdView(Context context) {
        super(context);
        this.a = c(context);
        this.b = d();
    }

    private final FrameLayout c(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaev d() {
        q.k(this.a, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwr.zzqo().zza(this.a.getContext(), this, this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, View view) {
        try {
            this.b.zzb(str, com.google.android.gms.dynamic.d.z0(view));
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to call setAssetView on delegate", e2);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        super.bringChildToFront(this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View b(String str) {
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

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.a;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public void destroy() {
        try {
            this.b.destroy();
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to destroy native ad view", e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
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

    public AdChoicesView getAdChoicesView() {
        View b = b(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (b instanceof AdChoicesView) {
            return (AdChoicesView) b;
        }
        return null;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
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
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.a == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        a(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.b.zza((com.google.android.gms.dynamic.b) nativeAd.zzjs());
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to call setNativeAd on delegate", e2);
        }
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = c(context);
        this.b = d();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = c(context);
        this.b = d();
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = c(context);
        this.b = d();
    }
}
