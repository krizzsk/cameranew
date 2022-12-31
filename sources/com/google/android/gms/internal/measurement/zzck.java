package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzck extends zzhs<zzck, zzcg> implements zziy {
    private static final zzck zzi;
    private int zza;
    private int zze;
    private boolean zzg;
    private String zzf = "";
    private zzhz<String> zzh = zzhs.zzbE();

    static {
        zzck zzckVar = new zzck();
        zzi = zzckVar;
        zzhs.zzby(zzck.class, zzckVar);
    }

    private zzck() {
    }

    public static zzck zzi() {
        return zzi;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzcj zzb() {
        zzcj zza = zzcj.zza(this.zze);
        return zza == null ? zzcj.UNKNOWN_MATCH_TYPE : zza;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final List<String> zzg() {
        return this.zzh;
    }

    public final int zzh() {
        return this.zzh.size();
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
                        return zzi;
                    }
                    return new zzcg(null);
                }
                return new zzck();
            }
            return zzhs.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zza", "zze", zzcj.zzb(), "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }
}
