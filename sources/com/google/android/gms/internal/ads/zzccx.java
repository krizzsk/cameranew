package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzccx extends zzaeu implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcdx {
    public static final String[] zzgfi = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, "3010"};
    private FrameLayout zzbny;
    private zzaem zzclh;
    private final String zzgfh;
    private FrameLayout zzgfj;
    private zzdzv zzgfk;
    private View zzgfl;
    @GuardedBy("this")
    private zzcbu zzgfm;
    private zzqs zzgfn;
    private boolean zzgfp;
    @GuardedBy("this")
    private Map<String, WeakReference<View>> zzdto = new HashMap();
    private b zzgfo = null;
    private boolean zzesz = false;
    private final int zzehz = 204204000;

    public zzccx(FrameLayout frameLayout, FrameLayout frameLayout2, int i2) {
        String str;
        this.zzgfj = frameLayout;
        this.zzbny = frameLayout2;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzgfh = str;
        com.google.android.gms.ads.internal.zzr.zzlo();
        zzbai.zza((View) frameLayout, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzr.zzlo();
        zzbai.zza((View) frameLayout, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzgfk = zzazp.zzeig;
        this.zzgfn = new zzqs(this.zzgfj.getContext(), this.zzgfj);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzaou() {
        this.zzgfk.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcda
            private final zzccx zzgfw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfw = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgfw.zzapc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final synchronized void destroy() {
        if (this.zzesz) {
            return;
        }
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzc(this);
            this.zzgfm = null;
        }
        this.zzdto.clear();
        this.zzgfj.removeAllViews();
        this.zzbny.removeAllViews();
        this.zzdto = null;
        this.zzgfj = null;
        this.zzbny = null;
        this.zzgfl = null;
        this.zzgfn = null;
        this.zzesz = true;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public final synchronized void onClick(View view) {
        VdsAgent.onClick(this, view);
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.cancelUnconfirmedClick();
            this.zzgfm.zza(view, this.zzgfj, zzaov(), zzaow(), false);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzb(this.zzgfj, zzaov(), zzaow(), zzcbu.zzz(this.zzgfj));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzb(this.zzgfj, zzaov(), zzaow(), zzcbu.zzz(this.zzgfj));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zza(view, motionEvent, this.zzgfj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final synchronized void zza(String str, View view, boolean z) {
        if (this.zzesz) {
            return;
        }
        if (view == null) {
            this.zzdto.remove(str);
            return;
        }
        this.zzdto.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !"3011".equals(str)) {
            if (com.google.android.gms.ads.internal.util.zzbn.zzdh(this.zzehz)) {
                view.setOnTouchListener(this);
            }
            view.setClickable(true);
            view.setOnClickListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final /* synthetic */ View zzajr() {
        return this.zzgfj;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final synchronized Map<String, WeakReference<View>> zzaov() {
        return this.zzdto;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final synchronized Map<String, WeakReference<View>> zzaow() {
        return this.zzdto;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzaox() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final synchronized String zzaoy() {
        return this.zzgfh;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final FrameLayout zzaoz() {
        return this.zzbny;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final zzqs zzapa() {
        return this.zzgfn;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    @Nullable
    public final b zzapb() {
        return this.zzgfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzapc() {
        if (this.zzgfl == null) {
            View view = new View(this.zzgfj.getContext());
            this.zzgfl = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzgfj != this.zzgfl.getParent()) {
            this.zzgfj.addView(this.zzgfl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final synchronized void zzb(String str, b bVar) {
        zza(str, (View) d.y0(bVar), true);
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final synchronized void zzc(b bVar, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final synchronized b zzco(String str) {
        return d.z0(zzgc(str));
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final synchronized void zzf(b bVar) {
        this.zzgfm.setClickConfirmingView((View) d.y0(bVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final void zzg(b bVar) {
        onTouch(this.zzgfj, (MotionEvent) d.y0(bVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final synchronized View zzgc(String str) {
        if (this.zzesz) {
            return null;
        }
        WeakReference<View> weakReference = this.zzdto.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final synchronized void zzh(b bVar) {
        if (this.zzesz) {
            return;
        }
        this.zzgfo = bVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    @Nullable
    public final synchronized JSONObject zztk() {
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            return zzcbuVar.zza(this.zzgfj, zzaov(), zzaow());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final synchronized void zza(b bVar) {
        if (this.zzesz) {
            return;
        }
        Object y0 = d.y0(bVar);
        if (!(y0 instanceof zzcbu)) {
            zzazk.zzex("Not an instance of native engine. This is most likely a transient error");
            return;
        }
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzc(this);
        }
        zzaou();
        zzcbu zzcbuVar2 = (zzcbu) y0;
        this.zzgfm = zzcbuVar2;
        zzcbuVar2.zza(this);
        this.zzgfm.zzaa(this.zzgfj);
        this.zzgfm.zzab(this.zzbny);
        if (this.zzgfp) {
            this.zzgfm.zzanr().zza(this.zzclh);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final synchronized void zza(zzaem zzaemVar) {
        if (this.zzesz) {
            return;
        }
        this.zzgfp = true;
        this.zzclh = zzaemVar;
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzanr().zza(zzaemVar);
        }
    }
}
