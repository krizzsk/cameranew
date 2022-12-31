package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzbu extends zzhs<zzbu, zzbt> implements zziy {
    private static final zzbu zzj;
    private int zza;
    private int zze;
    private zzhz<zzcf> zzf = zzhs.zzbE();
    private zzhz<zzbw> zzg = zzhs.zzbE();
    private boolean zzh;
    private boolean zzi;

    static {
        zzbu zzbuVar = new zzbu();
        zzj = zzbuVar;
        zzhs.zzby(zzbu.class, zzbuVar);
    }

    private zzbu() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzbu zzbuVar, int i2, zzcf zzcfVar) {
        zzcfVar.getClass();
        zzhz<zzcf> zzhzVar = zzbuVar.zzf;
        if (!zzhzVar.zza()) {
            zzbuVar.zzf = zzhs.zzbF(zzhzVar);
        }
        zzbuVar.zzf.set(i2, zzcfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzbu zzbuVar, int i2, zzbw zzbwVar) {
        zzbwVar.getClass();
        zzhz<zzbw> zzhzVar = zzbuVar.zzg;
        if (!zzhzVar.zza()) {
            zzbuVar.zzg = zzhs.zzbF(zzhzVar);
        }
        zzbuVar.zzg.set(i2, zzbwVar);
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final List<zzcf> zzc() {
        return this.zzf;
    }

    public final int zzd() {
        return this.zzf.size();
    }

    public final zzcf zze(int i2) {
        return this.zzf.get(i2);
    }

    public final List<zzbw> zzf() {
        return this.zzg;
    }

    public final int zzg() {
        return this.zzg.size();
    }

    public final zzbw zzh(int i2) {
        return this.zzg.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                        return zzj;
                    }
                    return new zzbt(null);
                }
                return new zzbu();
            }
            return zzhs.zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zza", "zze", "zzf", zzcf.class, "zzg", zzbw.class, "zzh", "zzi"});
        }
        return (byte) 1;
    }
}
