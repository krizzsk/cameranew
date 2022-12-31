package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzdx extends zzhs<zzdx, zzdw> implements zziy {
    private static final zzdx zze;
    private zzhz<zzdz> zza = zzhs.zzbE();

    static {
        zzdx zzdxVar = new zzdx();
        zze = zzdxVar;
        zzhs.zzby(zzdx.class, zzdxVar);
    }

    private zzdx() {
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
                        return zze;
                    }
                    return new zzdw(null);
                }
                return new zzdx();
            }
            return zzhs.zzbz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzdz.class});
        }
        return (byte) 1;
    }
}
