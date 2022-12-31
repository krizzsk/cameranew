package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzccy extends zzafb implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcdx {
    @GuardedBy("this")
    private zzcbu zzgfm;
    private zzqs zzgfn;
    private final WeakReference<View> zzgfq;
    private final Map<String, WeakReference<View>> zzgfr = new HashMap();
    private final Map<String, WeakReference<View>> zzgfs = new HashMap();
    private final Map<String, WeakReference<View>> zzgft = new HashMap();

    public zzccy(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        com.google.android.gms.ads.internal.zzr.zzlo();
        zzbai.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzr.zzlo();
        zzbai.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzgfq = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.zzgfr.put(key, new WeakReference<>(value));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key) && !"3011".equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.zzgft.putAll(this.zzgfr);
        for (Map.Entry<String, View> entry2 : hashMap2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.zzgfs.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
                value2.setClickable(false);
            }
        }
        this.zzgft.putAll(this.zzgfs);
        this.zzgfn = new zzqs(view.getContext(), view);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public final synchronized void onClick(View view) {
        VdsAgent.onClick(this, view);
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zza(view, zzajr(), zzaov(), zzaow(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzb(zzajr(), zzaov(), zzaow(), zzcbu.zzz(zzajr()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzb(zzajr(), zzaov(), zzaow(), zzcbu.zzz(zzajr()));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zza(view, motionEvent, zzajr());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaey
    public final synchronized void unregisterNativeAd() {
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzc(this);
            this.zzgfm = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaey
    public final synchronized void zza(b bVar) {
        Object y0 = d.y0(bVar);
        if (!(y0 instanceof zzcbu)) {
            zzazk.zzex("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzc(this);
        }
        if (((zzcbu) y0).zzanp()) {
            zzcbu zzcbuVar2 = (zzcbu) y0;
            this.zzgfm = zzcbuVar2;
            zzcbuVar2.zza(this);
            this.zzgfm.zzaa(zzajr());
            return;
        }
        zzazk.zzev("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    @Nullable
    public final View zzajr() {
        return this.zzgfq.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final synchronized Map<String, WeakReference<View>> zzaov() {
        return this.zzgft;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final synchronized Map<String, WeakReference<View>> zzaow() {
        return this.zzgfr;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzaox() {
        return this.zzgfs;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final synchronized String zzaoy() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    @Nullable
    public final FrameLayout zzaoz() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final zzqs zzapa() {
        return this.zzgfn;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    @Nullable
    public final synchronized b zzapb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaey
    public final synchronized void zzf(b bVar) {
        if (this.zzgfm != null) {
            Object y0 = d.y0(bVar);
            if (!(y0 instanceof View)) {
                zzazk.zzex("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zzgfm.setClickConfirmingView((View) y0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final synchronized View zzgc(String str) {
        WeakReference<View> weakReference = this.zzgft.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    @Nullable
    public final synchronized JSONObject zztk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final synchronized void zza(String str, View view, boolean z) {
        if (view == null) {
            this.zzgft.remove(str);
            this.zzgfr.remove(str);
            this.zzgfs.remove(str);
            return;
        }
        this.zzgft.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !"3011".equals(str)) {
            this.zzgfr.put(str, new WeakReference<>(view));
            view.setClickable(true);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }
    }
}
