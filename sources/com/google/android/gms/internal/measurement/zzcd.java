package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzcd extends zzhs<zzcd, zzbz> implements zziy {
    private static final zzcd zzj;
    private int zza;
    private int zze;
    private boolean zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzcd zzcdVar = new zzcd();
        zzj = zzcdVar;
        zzhs.zzby(zzcd.class, zzcdVar);
    }

    private zzcd() {
    }

    public static zzcd zzk() {
        return zzj;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzcc zzb() {
        zzcc zza = zzcc.zza(this.zze);
        return zza == null ? zzcc.UNKNOWN_COMPARISON_TYPE : zza;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final boolean zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zza & 16) != 0;
    }

    public final String zzj() {
        return this.zzi;
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
                        return zzj;
                    }
                    return new zzbz(null);
                }
                return new zzcd();
            }
            return zzhs.zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zza", "zze", zzcc.zzb(), "zzf", "zzg", "zzh", "zzi"});
        }
        return (byte) 1;
    }
}
