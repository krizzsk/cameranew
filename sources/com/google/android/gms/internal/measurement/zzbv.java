package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzbv extends zzho<zzbw, zzbv> implements zziy {
    private zzbv() {
        super(zzbw.zzo());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbv(zzbs zzbsVar) {
        super(zzbw.zzo());
    }

    public final String zza() {
        return ((zzbw) this.zza).zzc();
    }

    public final zzbv zzb(String str) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzbw.zzp((zzbw) this.zza, str);
        return this;
    }

    public final int zzc() {
        return ((zzbw) this.zza).zze();
    }

    public final zzby zzd(int i2) {
        return ((zzbw) this.zza).zzf(i2);
    }

    public final zzbv zze(int i2, zzby zzbyVar) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzbw.zzq((zzbw) this.zza, i2, zzbyVar);
        return this;
    }
}
