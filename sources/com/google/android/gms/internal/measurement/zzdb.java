package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzdb extends zzhs<zzdb, zzda> implements zziy {
    private static final zzdb zzj;
    private int zza;
    private zzhz<zzdf> zze = zzhs.zzbE();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private int zzi;

    static {
        zzdb zzdbVar = new zzdb();
        zzj = zzdbVar;
        zzhs.zzby(zzdb.class, zzdbVar);
    }

    private zzdb() {
    }

    public static zzda zzk() {
        return zzj.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzn(zzdb zzdbVar, int i2, zzdf zzdfVar) {
        zzdfVar.getClass();
        zzdbVar.zzv();
        zzdbVar.zze.set(i2, zzdfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzo(zzdb zzdbVar, zzdf zzdfVar) {
        zzdfVar.getClass();
        zzdbVar.zzv();
        zzdbVar.zze.add(zzdfVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzp(zzdb zzdbVar, Iterable iterable) {
        zzdbVar.zzv();
        zzgb.zzbs(iterable, zzdbVar.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzr(zzdb zzdbVar, int i2) {
        zzdbVar.zzv();
        zzdbVar.zze.remove(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzs(zzdb zzdbVar, String str) {
        str.getClass();
        zzdbVar.zza |= 1;
        zzdbVar.zzf = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzt(zzdb zzdbVar, long j2) {
        zzdbVar.zza |= 2;
        zzdbVar.zzg = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzu(zzdb zzdbVar, long j2) {
        zzdbVar.zza |= 4;
        zzdbVar.zzh = j2;
    }

    private final void zzv() {
        zzhz<zzdf> zzhzVar = this.zze;
        if (zzhzVar.zza()) {
            return;
        }
        this.zze = zzhs.zzbF(zzhzVar);
    }

    public final List<zzdf> zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final zzdf zzc(int i2) {
        return this.zze.get(i2);
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 2) != 0;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 4) != 0;
    }

    public final long zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zza & 8) != 0;
    }

    public final int zzj() {
        return this.zzi;
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
                    return new zzda(null);
                }
                return new zzdb();
            }
            return zzhs.zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zza", "zze", zzdf.class, "zzf", "zzg", "zzh", "zzi"});
        }
        return (byte) 1;
    }
}
