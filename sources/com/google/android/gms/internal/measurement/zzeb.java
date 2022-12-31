package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzeb extends zzhs<zzeb, zzea> implements zziy {
    private static final zzeb zzg;
    private int zza;
    private zzhz<zzeg> zze = zzhs.zzbE();
    private zzdx zzf;

    static {
        zzeb zzebVar = new zzeb();
        zzg = zzebVar;
        zzhs.zzby(zzeb.class, zzebVar);
    }

    private zzeb() {
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
                    return new zzea(null);
                }
                return new zzeb();
            }
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zza", "zze", zzeg.class, "zzf"});
        }
        return (byte) 1;
    }
}
