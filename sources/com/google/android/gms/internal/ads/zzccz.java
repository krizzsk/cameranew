package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzccz {
    private final Executor executor;
    private final zzaeh zzdoe;
    private final com.google.android.gms.ads.internal.util.zzf zzedg;
    private final Executor zzfsj;
    private final zzdnp zzfwy;
    private final zzccd zzgch;
    private final zzcch zzgdj;
    private final zzccc zzgds;
    @Nullable
    private final zzcdh zzgfu;
    @Nullable
    private final zzcdp zzgfv;

    public zzccz(com.google.android.gms.ads.internal.util.zzf zzfVar, zzdnp zzdnpVar, zzcch zzcchVar, zzccd zzccdVar, @Nullable zzcdh zzcdhVar, @Nullable zzcdp zzcdpVar, Executor executor, Executor executor2, zzccc zzcccVar) {
        this.zzedg = zzfVar;
        this.zzfwy = zzdnpVar;
        this.zzdoe = zzdnpVar.zzdoe;
        this.zzgdj = zzcchVar;
        this.zzgch = zzccdVar;
        this.zzgfu = zzcdhVar;
        this.zzgfv = zzcdpVar;
        this.zzfsj = executor;
        this.executor = executor2;
        this.zzgds = zzcccVar;
    }

    public final void zza(final zzcdx zzcdxVar) {
        this.zzfsj.execute(new Runnable(this, zzcdxVar) { // from class: com.google.android.gms.internal.ads.zzcdc
            private final zzcdx zzgdv;
            private final zzccz zzgfx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfx = this;
                this.zzgdv = zzcdxVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgfx.zzi(this.zzgdv);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzgch.zzany() != null) {
            if (2 != this.zzgch.zzanu() && 1 != this.zzgch.zzanu()) {
                if (6 == this.zzgch.zzanu()) {
                    this.zzedg.zza(this.zzfwy.zzhkx, "2", z);
                    this.zzedg.zza(this.zzfwy.zzhkx, "1", z);
                    return;
                }
                return;
            }
            this.zzedg.zza(this.zzfwy.zzhkx, String.valueOf(this.zzgch.zzanu()), z);
        }
    }

    public final void zzg(@Nullable zzcdx zzcdxVar) {
        if (zzcdxVar == null || this.zzgfu == null || zzcdxVar.zzaoz() == null || !this.zzgdj.zzaog()) {
            return;
        }
        try {
            zzcdxVar.zzaoz().addView(this.zzgfu.zzapf());
        } catch (zzben e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("web view can not be obtained", e2);
        }
    }

    public final void zzh(@Nullable zzcdx zzcdxVar) {
        if (zzcdxVar == null) {
            return;
        }
        Context context = zzcdxVar.zzajr().getContext();
        if (com.google.android.gms.ads.internal.util.zzbn.zza(context, this.zzgdj.zzgeu)) {
            if (!(context instanceof Activity)) {
                zzazk.zzdy("Activity context is needed for policy validator.");
            } else if (this.zzgfv == null || zzcdxVar.zzaoz() == null) {
            } else {
                try {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    windowManager.addView(this.zzgfv.zza(zzcdxVar.zzaoz(), windowManager), com.google.android.gms.ads.internal.util.zzbn.zzzq());
                } catch (zzben e2) {
                    com.google.android.gms.ads.internal.util.zzd.zza("web view can not be obtained", e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzcdx zzcdxVar) {
        ViewGroup viewGroup;
        View view;
        final ViewGroup viewGroup2;
        b zzti;
        Drawable drawable;
        int i2 = 0;
        if (this.zzgdj.zzaoi() || this.zzgdj.zzaoh()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
            for (int i3 = 0; i3 < 2; i3++) {
                View zzgc = zzcdxVar.zzgc(strArr[i3]);
                if (zzgc != null && (zzgc instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzgc;
                    break;
                }
            }
        }
        viewGroup = null;
        boolean z = viewGroup != null;
        Context context = zzcdxVar.zzajr().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.zzgch.zzanv() != null) {
            view = this.zzgch.zzanv();
            zzaeh zzaehVar = this.zzdoe;
            if (zzaehVar != null && !z) {
                zza(layoutParams, zzaehVar.zzbnv);
                view.setLayoutParams(layoutParams);
            }
        } else if (this.zzgch.zzto() instanceof zzady) {
            zzady zzadyVar = (zzady) this.zzgch.zzto();
            if (!z) {
                zza(layoutParams, zzadyVar.zztg());
            }
            View zzaebVar = new zzaeb(context, zzadyVar, layoutParams);
            zzaebVar.setContentDescription((CharSequence) zzwr.zzqr().zzd(zzabp.zzctf));
            view = zzaebVar;
        } else {
            view = null;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzcdxVar.zzajr().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(view);
                FrameLayout zzaoz = zzcdxVar.zzaoz();
                if (zzaoz != null) {
                    zzaoz.addView(adChoicesView);
                }
            }
            zzcdxVar.zza(zzcdxVar.zzaoy(), view, true);
        }
        String[] strArr2 = zzccx.zzgfi;
        int length = strArr2.length;
        while (true) {
            if (i2 >= length) {
                viewGroup2 = null;
                break;
            }
            View zzgc2 = zzcdxVar.zzgc(strArr2[i2]);
            if (zzgc2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzgc2;
                break;
            }
            i2++;
        }
        this.executor.execute(new Runnable(this, viewGroup2) { // from class: com.google.android.gms.internal.ads.zzcdb
            private final zzccz zzgfx;
            private final ViewGroup zzgfy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfx = this;
                this.zzgfy = viewGroup2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgfx.zzb(this.zzgfy);
            }
        });
        if (viewGroup2 != null) {
            if (zza(viewGroup2)) {
                if (this.zzgch.zzanz() != null) {
                    this.zzgch.zzanz().zza(new zzcde(this, zzcdxVar, viewGroup2));
                    return;
                }
                return;
            }
            viewGroup2.removeAllViews();
            View zzajr = zzcdxVar.zzajr();
            Context context2 = zzajr != null ? zzajr.getContext() : null;
            if (context2 != null) {
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcte)).booleanValue()) {
                    zzaem zzty = this.zzgds.zzty();
                    if (zzty == null) {
                        return;
                    }
                    try {
                        zzti = zzty.zztl();
                    } catch (RemoteException unused) {
                        zzazk.zzex("Could not get main image drawable");
                        return;
                    }
                } else {
                    zzaer zzanw = this.zzgch.zzanw();
                    if (zzanw == null) {
                        return;
                    }
                    try {
                        zzti = zzanw.zzti();
                    } catch (RemoteException unused2) {
                        zzazk.zzex("Could not get drawable from image");
                        return;
                    }
                }
                if (zzti == null || (drawable = (Drawable) d.y0(zzti)) == null) {
                    return;
                }
                ImageView imageView = new ImageView(context2);
                imageView.setImageDrawable(drawable);
                b zzapb = zzcdxVar != null ? zzcdxVar.zzapb() : null;
                if (zzapb != null) {
                    if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxx)).booleanValue()) {
                        imageView.setScaleType((ImageView.ScaleType) d.y0(zzapb));
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        viewGroup2.addView(imageView);
                    }
                }
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                viewGroup2.addView(imageView);
            }
        }
    }

    private static void zza(RelativeLayout.LayoutParams layoutParams, int i2) {
        if (i2 == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i2 == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i2 != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zza(zzcdx zzcdxVar, String[] strArr) {
        Map<String, WeakReference<View>> zzaow = zzcdxVar.zzaow();
        if (zzaow == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzaow.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(@NonNull ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View zzany = this.zzgch.zzany();
        if (zzany == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzany.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzany.getParent()).removeView(zzany);
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcti)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzany, layoutParams);
        return true;
    }
}
