package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdnx {
    private final zzcqr zzdie;
    private final zzdmw zzesr;
    private final zzdnb zzess;
    private final zzdss zzfrf;

    public zzdnx(zzcqr zzcqrVar, zzdss zzdssVar, zzdmw zzdmwVar, zzdnb zzdnbVar) {
        this.zzesr = zzdmwVar;
        this.zzess = zzdnbVar;
        this.zzdie = zzcqrVar;
        this.zzfrf = zzdssVar;
    }

    private final void zzb(String str, int i2) {
        if (!this.zzesr.zzhjz) {
            this.zzfrf.zzel(str);
            return;
        }
        this.zzdie.zza(new zzcrc(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis(), this.zzess.zzbvs, str, i2));
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/List<Ljava/lang/String;>;Ljava/lang/Integer;)V */
    public final void zza(List list, int i2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), i2);
        }
    }

    public final void zzj(List<String> list) {
        for (String str : list) {
            zzb(str, zzcqs.zzgru);
        }
    }
}
