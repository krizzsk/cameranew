package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzcx extends zzhs<zzcx, zzcw> implements zziy {
    private static final zzcx zzi;
    private int zza;
    private int zze;
    private zzdq zzf;
    private zzdq zzg;
    private boolean zzh;

    static {
        zzcx zzcxVar = new zzcx();
        zzi = zzcxVar;
        zzhs.zzby(zzcx.class, zzcxVar);
    }

    private zzcx() {
    }

    public static zzcw zzh() {
        return zzi.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzcx zzcxVar, int i2) {
        zzcxVar.zza |= 1;
        zzcxVar.zze = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzcx zzcxVar, zzdq zzdqVar) {
        zzdqVar.getClass();
        zzcxVar.zzf = zzdqVar;
        zzcxVar.zza |= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzm(zzcx zzcxVar, zzdq zzdqVar) {
        zzcxVar.zzg = zzdqVar;
        zzcxVar.zza |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzn(zzcx zzcxVar, boolean z) {
        zzcxVar.zza |= 8;
        zzcxVar.zzh = z;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final zzdq zzc() {
        zzdq zzdqVar = this.zzf;
        return zzdqVar == null ? zzdq.zzm() : zzdqVar;
    }

    public final boolean zzd() {
        return (this.zza & 4) != 0;
    }

    public final zzdq zze() {
        zzdq zzdqVar = this.zzg;
        return zzdqVar == null ? zzdq.zzm() : zzdqVar;
    }

    public final boolean zzf() {
        return (this.zza & 8) != 0;
    }

    public final boolean zzg() {
        return this.zzh;
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
                        return zzi;
                    }
                    return new zzcw(null);
                }
                return new zzcx();
            }
            return zzhs.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zza", "zze", "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }
}
