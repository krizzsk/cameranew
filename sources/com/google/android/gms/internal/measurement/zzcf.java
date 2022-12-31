package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzcf extends zzhs<zzcf, zzce> implements zziy {
    private static final zzcf zzk;
    private int zza;
    private int zze;
    private String zzf = "";
    private zzby zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzcf zzcfVar = new zzcf();
        zzk = zzcfVar;
        zzhs.zzby(zzcf.class, zzcfVar);
    }

    private zzcf() {
    }

    public static zzce zzi() {
        return zzk.zzbt();
    }

    public static /* synthetic */ void zzk(zzcf zzcfVar, String str) {
        zzcfVar.zza |= 2;
        zzcfVar.zzf = str;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final zzby zzd() {
        zzby zzbyVar = this.zzg;
        return zzbyVar == null ? zzby.zzi() : zzbyVar;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return (this.zza & 32) != 0;
    }

    public final boolean zzh() {
        return this.zzj;
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
                        return zzk;
                    }
                    return new zzce(null);
                }
                return new zzcf();
            }
            return zzhs.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }
}
