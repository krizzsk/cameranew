package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzbw extends zzhs<zzbw, zzbv> implements zziy {
    private static final zzbw zzm;
    private int zza;
    private int zze;
    private String zzf = "";
    private zzhz<zzby> zzg = zzhs.zzbE();
    private boolean zzh;
    private zzcd zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzbw zzbwVar = new zzbw();
        zzm = zzbwVar;
        zzhs.zzby(zzbw.class, zzbwVar);
    }

    private zzbw() {
    }

    public static zzbv zzn() {
        return zzm.zzbt();
    }

    public static /* synthetic */ void zzp(zzbw zzbwVar, String str) {
        zzbwVar.zza |= 2;
        zzbwVar.zzf = str;
    }

    public static /* synthetic */ void zzq(zzbw zzbwVar, int i2, zzby zzbyVar) {
        zzbyVar.getClass();
        zzhz<zzby> zzhzVar = zzbwVar.zzg;
        if (!zzhzVar.zza()) {
            zzbwVar.zzg = zzhs.zzbF(zzhzVar);
        }
        zzbwVar.zzg.set(i2, zzbyVar);
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

    public final List<zzby> zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzg.size();
    }

    public final zzby zzf(int i2) {
        return this.zzg.get(i2);
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final zzcd zzh() {
        zzcd zzcdVar = this.zzi;
        return zzcdVar == null ? zzcd.zzk() : zzcdVar;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final boolean zzj() {
        return this.zzk;
    }

    public final boolean zzk() {
        return (this.zza & 64) != 0;
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
                        return zzm;
                    }
                    return new zzbv(null);
                }
                return new zzbw();
            }
            return zzhs.zzbz(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zza", "zze", "zzf", "zzg", zzby.class, "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        return (byte) 1;
    }

    public final boolean zzm() {
        return this.zzl;
    }
}
