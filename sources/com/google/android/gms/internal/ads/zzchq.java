package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzchq {
    private final Context context;
    private final zzazn zzbpn;
    private final zzbej zzbqa;
    private final zztu zzeqv;
    private final zzei zzesm;
    private final zzacq zzesn;
    private final com.google.android.gms.ads.internal.zzb zzesp;
    private final zzbts zzgjw;

    public zzchq(zzbej zzbejVar, Context context, zzei zzeiVar, zzacq zzacqVar, zzazn zzaznVar, com.google.android.gms.ads.internal.zzb zzbVar, zztu zztuVar, zzbts zzbtsVar) {
        this.zzbqa = zzbejVar;
        this.context = context;
        this.zzesm = zzeiVar;
        this.zzesn = zzacqVar;
        this.zzbpn = zzaznVar;
        this.zzesp = zzbVar;
        this.zzeqv = zztuVar;
        this.zzgjw = zzbtsVar;
    }

    public final zzbeb zza(zzvs zzvsVar, zzdmw zzdmwVar, zzdnb zzdnbVar) throws zzben {
        return zzbej.zza(this.context, zzbft.zzb(zzvsVar), zzvsVar.zzacy, false, false, this.zzesm, this.zzesn, this.zzbpn, null, new zzchp(this), this.zzesp, this.zzeqv, zzdmwVar, zzdnbVar);
    }

    public final zzbeb zze(zzvs zzvsVar) throws zzben {
        return zza(zzvsVar, null, null);
    }
}
