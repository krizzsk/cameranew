package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzdq extends zzhs<zzdq, zzdp> implements zziy {
    private static final zzdq zzh;
    private zzhy zza = zzhs.zzbC();
    private zzhy zze = zzhs.zzbC();
    private zzhz<zzcz> zzf = zzhs.zzbE();
    private zzhz<zzds> zzg = zzhs.zzbE();

    static {
        zzdq zzdqVar = new zzdq();
        zzh = zzdqVar;
        zzhs.zzby(zzdq.class, zzdqVar);
    }

    private zzdq() {
    }

    public static zzdp zzk() {
        return zzh.zzbt();
    }

    public static zzdq zzm() {
        return zzh;
    }

    public static /* synthetic */ void zzo(zzdq zzdqVar, Iterable iterable) {
        zzhy zzhyVar = zzdqVar.zza;
        if (!zzhyVar.zza()) {
            zzdqVar.zza = zzhs.zzbD(zzhyVar);
        }
        zzgb.zzbs(iterable, zzdqVar.zza);
    }

    public static /* synthetic */ void zzq(zzdq zzdqVar, Iterable iterable) {
        zzhy zzhyVar = zzdqVar.zze;
        if (!zzhyVar.zza()) {
            zzdqVar.zze = zzhs.zzbD(zzhyVar);
        }
        zzgb.zzbs(iterable, zzdqVar.zze);
    }

    public static /* synthetic */ void zzs(zzdq zzdqVar, Iterable iterable) {
        zzdqVar.zzw();
        zzgb.zzbs(iterable, zzdqVar.zzf);
    }

    public static /* synthetic */ void zzt(zzdq zzdqVar, int i2) {
        zzdqVar.zzw();
        zzdqVar.zzf.remove(i2);
    }

    public static /* synthetic */ void zzu(zzdq zzdqVar, Iterable iterable) {
        zzdqVar.zzx();
        zzgb.zzbs(iterable, zzdqVar.zzg);
    }

    public static /* synthetic */ void zzv(zzdq zzdqVar, int i2) {
        zzdqVar.zzx();
        zzdqVar.zzg.remove(i2);
    }

    private final void zzw() {
        zzhz<zzcz> zzhzVar = this.zzf;
        if (zzhzVar.zza()) {
            return;
        }
        this.zzf = zzhs.zzbF(zzhzVar);
    }

    private final void zzx() {
        zzhz<zzds> zzhzVar = this.zzg;
        if (zzhzVar.zza()) {
            return;
        }
        this.zzg = zzhs.zzbF(zzhzVar);
    }

    public final List<Long> zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final List<Long> zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final List<zzcz> zze() {
        return this.zzf;
    }

    public final int zzf() {
        return this.zzf.size();
    }

    public final zzcz zzg(int i2) {
        return this.zzf.get(i2);
    }

    public final List<zzds> zzh() {
        return this.zzg;
    }

    public final int zzi() {
        return this.zzg.size();
    }

    public final zzds zzj(int i2) {
        return this.zzg.get(i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzhs
    public final Object zzl(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return null;
                        }
                        return zzh;
                    }
                    return new zzdp(null);
                }
                return new zzdq();
            }
            return zzhs.zzbz(zzh, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zza", "zze", "zzf", zzcz.class, "zzg", zzds.class});
        }
        return (byte) 1;
    }
}
