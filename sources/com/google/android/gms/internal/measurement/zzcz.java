package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzcz extends zzhs<zzcz, zzcy> implements zziy {
    private static final zzcz zzg;
    private int zza;
    private int zze;
    private long zzf;

    static {
        zzcz zzczVar = new zzcz();
        zzg = zzczVar;
        zzhs.zzby(zzcz.class, zzczVar);
    }

    private zzcz() {
    }

    public static zzcy zze() {
        return zzg.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzcz zzczVar, int i2) {
        zzczVar.zza |= 1;
        zzczVar.zze = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzcz zzczVar, long j2) {
        zzczVar.zza |= 2;
        zzczVar.zzf = j2;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final long zzd() {
        return this.zzf;
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
                        return zzg;
                    }
                    return new zzcy(null);
                }
                return new zzcz();
            }
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zza", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
