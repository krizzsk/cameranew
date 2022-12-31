package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzdu extends zzhs<zzdu, zzdt> implements zziy {
    private static final zzdu zzk;
    private int zza;
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        zzdu zzduVar = new zzdu();
        zzk = zzduVar;
        zzhs.zzby(zzdu.class, zzduVar);
    }

    private zzdu() {
    }

    public static zzdt zzj() {
        return zzk.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzm(zzdu zzduVar, long j2) {
        zzduVar.zza |= 1;
        zzduVar.zze = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzn(zzdu zzduVar, String str) {
        str.getClass();
        zzduVar.zza |= 2;
        zzduVar.zzf = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzo(zzdu zzduVar, String str) {
        str.getClass();
        zzduVar.zza |= 4;
        zzduVar.zzg = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzp(zzdu zzduVar) {
        zzduVar.zza &= -5;
        zzduVar.zzg = zzk.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzq(zzdu zzduVar, long j2) {
        zzduVar.zza |= 8;
        zzduVar.zzh = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzr(zzdu zzduVar) {
        zzduVar.zza &= -9;
        zzduVar.zzh = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzs(zzdu zzduVar, double d2) {
        zzduVar.zza |= 32;
        zzduVar.zzj = d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzt(zzdu zzduVar) {
        zzduVar.zza &= -33;
        zzduVar.zzj = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final long zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return (this.zza & 4) != 0;
    }

    public final String zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return (this.zza & 8) != 0;
    }

    public final long zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return (this.zza & 32) != 0;
    }

    public final double zzi() {
        return this.zzj;
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
                        return zzk;
                    }
                    return new zzdt(null);
                }
                return new zzdu();
            }
            return zzhs.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }
}
