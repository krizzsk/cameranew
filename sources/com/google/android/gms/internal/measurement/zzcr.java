package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzcr extends zzhs<zzcr, zzcq> implements zziy {
    private static final zzcr zzg;
    private int zza;
    private String zze = "";
    private String zzf = "";

    static {
        zzcr zzcrVar = new zzcr();
        zzg = zzcrVar;
        zzhs.zzby(zzcr.class, zzcrVar);
    }

    private zzcr() {
    }

    public final String zza() {
        return this.zze;
    }

    public final String zzb() {
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
                    return new zzcq(null);
                }
                return new zzcr();
            }
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zza", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
