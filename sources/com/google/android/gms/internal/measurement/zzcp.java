package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzcp extends zzhs<zzcp, zzco> implements zziy {
    private static final zzcp zzn;
    private int zza;
    private long zze;
    private int zzg;
    private boolean zzl;
    private String zzf = "";
    private zzhz<zzcr> zzh = zzhs.zzbE();
    private zzhz<zzcn> zzi = zzhs.zzbE();
    private zzhz<zzbu> zzj = zzhs.zzbE();
    private String zzk = "";
    private zzhz<zzeb> zzm = zzhs.zzbE();

    static {
        zzcp zzcpVar = new zzcp();
        zzn = zzcpVar;
        zzhs.zzby(zzcp.class, zzcpVar);
    }

    private zzcp() {
    }

    public static zzco zzj() {
        return zzn.zzbt();
    }

    public static zzcp zzk() {
        return zzn;
    }

    public static /* synthetic */ void zzn(zzcp zzcpVar, int i2, zzcn zzcnVar) {
        zzcnVar.getClass();
        zzhz<zzcn> zzhzVar = zzcpVar.zzi;
        if (!zzhzVar.zza()) {
            zzcpVar.zzi = zzhs.zzbF(zzhzVar);
        }
        zzcpVar.zzi.set(i2, zzcnVar);
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final long zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final List<zzcr> zze() {
        return this.zzh;
    }

    public final int zzf() {
        return this.zzi.size();
    }

    public final zzcn zzg(int i2) {
        return this.zzi.get(i2);
    }

    public final List<zzbu> zzh() {
        return this.zzj;
    }

    public final boolean zzi() {
        return this.zzl;
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
                        return zzn;
                    }
                    return new zzco(null);
                }
                return new zzcp();
            }
            return zzhs.zzbz(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", zzcr.class, "zzi", zzcn.class, "zzj", zzbu.class, "zzk", "zzl", "zzm", zzeb.class});
        }
        return (byte) 1;
    }
}
