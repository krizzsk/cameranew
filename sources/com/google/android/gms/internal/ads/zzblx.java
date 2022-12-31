package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.d;
import java.util.Iterator;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzblx extends zzblv {
    private final Context context;
    private final View view;
    @Nullable
    private final zzbeb zzdjd;
    private final Executor zzfsj;
    private final zzdmz zzftn;
    private final zzbnu zzfuo;
    private final zzcco zzfup;
    private final zzbye zzfuq;
    private final zzepv<zzcxs> zzfur;
    private zzvs zzfus;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblx(zzbnw zzbnwVar, Context context, zzdmz zzdmzVar, View view, @Nullable zzbeb zzbebVar, zzbnu zzbnuVar, zzcco zzccoVar, zzbye zzbyeVar, zzepv<zzcxs> zzepvVar, Executor executor) {
        super(zzbnwVar);
        this.context = context;
        this.view = view;
        this.zzdjd = zzbebVar;
        this.zzftn = zzdmzVar;
        this.zzfuo = zzbnuVar;
        this.zzfup = zzccoVar;
        this.zzfuq = zzbyeVar;
        this.zzfur = zzepvVar;
        this.zzfsj = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final zzzc getVideoController() {
        try {
            return this.zzfuo.getVideoController();
        } catch (zzdnt unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zza(ViewGroup viewGroup, zzvs zzvsVar) {
        zzbeb zzbebVar;
        if (viewGroup == null || (zzbebVar = this.zzdjd) == null) {
            return;
        }
        zzbebVar.zza(zzbft.zzb(zzvsVar));
        viewGroup.setMinimumHeight(zzvsVar.heightPixels);
        viewGroup.setMinimumWidth(zzvsVar.widthPixels);
        this.zzfus = zzvsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final zzdmz zzajq() {
        boolean z;
        zzvs zzvsVar = this.zzfus;
        if (zzvsVar != null) {
            return zzdnu.zzh(zzvsVar);
        }
        zzdmw zzdmwVar = this.zzesr;
        if (zzdmwVar.zzhjt) {
            Iterator<String> it = zzdmwVar.zzhix.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (next != null && next.contains("FirstParty")) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return new zzdmz(this.view.getWidth(), this.view.getHeight(), false);
            }
        }
        return zzdnu.zza(this.zzesr.zzhjf, this.zzftn);
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final View zzajr() {
        return this.view;
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final zzdmz zzajz() {
        return this.zzftn;
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final int zzaka() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczh)).booleanValue() && this.zzesr.zzhjx) {
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzczi)).booleanValue()) {
                return 0;
            }
        }
        return this.zzfrd.zzhks.zzess.zzhkg;
    }

    @Override // com.google.android.gms.internal.ads.zzbnt
    public final void zzakb() {
        this.zzfsj.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbma
            private final zzblx zzfuy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfuy = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfuy.zzakc();
            }
        });
        super.zzakb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzakc() {
        if (this.zzfup.zzaom() != null) {
            try {
                this.zzfup.zzaom().zza(this.zzfur.get(), d.z0(this.context));
            } catch (RemoteException e2) {
                zzazk.zzc("RemoteException when notifyAdLoad is called", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzkf() {
        this.zzfuq.zzamr();
    }
}
