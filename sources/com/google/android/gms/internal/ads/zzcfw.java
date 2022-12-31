package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.util.Collections;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcfw extends zzaju implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzaea {
    private zzzc zzgef;
    private View zzgek;
    private zzcbu zzgfm;
    private boolean zzesz = false;
    private boolean zzgiq = false;

    public zzcfw(zzcbu zzcbuVar, zzccd zzccdVar) {
        this.zzgek = zzccdVar.zzany();
        this.zzgef = zzccdVar.getVideoController();
        this.zzgfm = zzcbuVar;
        if (zzccdVar.zzanz() != null) {
            zzccdVar.zzanz().zza(this);
        }
    }

    private final void zzapk() {
        View view = this.zzgek;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.zzgek);
        }
    }

    private final void zzapl() {
        View view;
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar == null || (view = this.zzgek) == null) {
            return;
        }
        zzcbuVar.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzcbu.zzz(this.zzgek));
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final void destroy() throws RemoteException {
        q.e("#008 Must be called on the main UI thread.");
        zzapk();
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.destroy();
        }
        this.zzgfm = null;
        this.zzgek = null;
        this.zzgef = null;
        this.zzesz = true;
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final zzzc getVideoController() throws RemoteException {
        q.e("#008 Must be called on the main UI thread.");
        if (this.zzesz) {
            zzazk.zzev("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        return this.zzgef;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzapl();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzapl();
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final void zza(b bVar, zzajw zzajwVar) throws RemoteException {
        q.e("#008 Must be called on the main UI thread.");
        if (this.zzesz) {
            zzazk.zzev("Instream ad can not be shown after destroy().");
            zza(zzajwVar, 2);
            return;
        }
        View view = this.zzgek;
        if (view != null && this.zzgef != null) {
            if (this.zzgiq) {
                zzazk.zzev("Instream ad should not be used again.");
                zza(zzajwVar, 1);
                return;
            }
            this.zzgiq = true;
            zzapk();
            ((ViewGroup) d.y0(bVar)).addView(this.zzgek, new ViewGroup.LayoutParams(-1, -1));
            com.google.android.gms.ads.internal.zzr.zzlo();
            zzbai.zza(this.zzgek, (ViewTreeObserver.OnGlobalLayoutListener) this);
            com.google.android.gms.ads.internal.zzr.zzlo();
            zzbai.zza(this.zzgek, (ViewTreeObserver.OnScrollChangedListener) this);
            zzapl();
            try {
                zzajwVar.zzue();
                return;
            } catch (RemoteException e2) {
                zzazk.zze("#007 Could not call remote method.", e2);
                return;
            }
        }
        String str = view == null ? "can not get video view." : "can not get video controller.";
        zzazk.zzev(str.length() != 0 ? "Instream internal error: ".concat(str) : new String("Instream internal error: "));
        zza(zzajwVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzapm() {
        try {
            destroy();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final void zzr(b bVar) throws RemoteException {
        q.e("#008 Must be called on the main UI thread.");
        zza(bVar, new zzcfy(this));
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzth() {
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcfv
            private final zzcfw zzgip;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgip = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgip.zzapm();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajv
    public final zzaem zzty() {
        q.e("#008 Must be called on the main UI thread.");
        if (this.zzesz) {
            zzazk.zzev("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar == null || zzcbuVar.zzanr() == null) {
            return null;
        }
        return this.zzgfm.zzanr().zzty();
    }

    private static void zza(zzajw zzajwVar, int i2) {
        try {
            zzajwVar.zzda(i2);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }
}
