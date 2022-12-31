package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzdz extends zzhs<zzdz, zzdy> implements zziy {
    private static final zzdz zzg;
    private int zza;
    private String zze = "";
    private zzhz<zzeg> zzf = zzhs.zzbE();

    static {
        zzdz zzdzVar = new zzdz();
        zzg = zzdzVar;
        zzhs.zzby(zzdz.class, zzdzVar);
    }

    private zzdz() {
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
                        return zzg;
                    }
                    return new zzdy(null);
                }
                return new zzdz();
            }
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zza", "zze", "zzf", zzeg.class});
        }
        return (byte) 1;
    }
}
