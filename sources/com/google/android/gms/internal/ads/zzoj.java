package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzoj {
    public final zznu zzbhx;
    public final zzoi zzbhy;
    public final Object zzbhz;
    public final zzia[] zzbia;

    public zzoj(zznu zznuVar, zzoi zzoiVar, Object obj, zzia[] zziaVarArr) {
        this.zzbhx = zznuVar;
        this.zzbhy = zzoiVar;
        this.zzbhz = obj;
        this.zzbia = zziaVarArr;
    }

    public final boolean zza(zzoj zzojVar, int i2) {
        return zzojVar != null && zzpt.zza(this.zzbhy.zzbe(i2), zzojVar.zzbhy.zzbe(i2)) && zzpt.zza(this.zzbia[i2], zzojVar.zzbia[i2]);
    }
}
