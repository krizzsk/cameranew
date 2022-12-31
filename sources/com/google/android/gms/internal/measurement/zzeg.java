package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzeg extends zzhs<zzeg, zzec> implements zziy {
    private static final zzeg zzk;
    private int zza;
    private int zze;
    private zzhz<zzeg> zzf = zzhs.zzbE();
    private String zzg = "";
    private String zzh = "";
    private boolean zzi;
    private double zzj;

    static {
        zzeg zzegVar = new zzeg();
        zzk = zzegVar;
        zzhs.zzby(zzeg.class, zzegVar);
    }

    private zzeg() {
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
                    return new zzec(null);
                }
                return new zzeg();
            }
            return zzhs.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zza", "zze", zzef.zzb(), "zzf", zzeg.class, "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }
}
