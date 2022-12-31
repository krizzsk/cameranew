package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzdo extends zzhs<zzdo, zzdk> implements zziy {
    private static final zzdo zzg;
    private int zza;
    private int zze = 1;
    private zzhz<zzdd> zzf = zzhs.zzbE();

    static {
        zzdo zzdoVar = new zzdo();
        zzg = zzdoVar;
        zzhs.zzby(zzdo.class, zzdoVar);
    }

    private zzdo() {
    }

    public static zzdk zza() {
        return zzg.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(zzdo zzdoVar, zzdd zzddVar) {
        zzddVar.getClass();
        zzhz<zzdd> zzhzVar = zzdoVar.zzf;
        if (!zzhzVar.zza()) {
            zzdoVar.zzf = zzhs.zzbF(zzhzVar);
        }
        zzdoVar.zzf.add(zzddVar);
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
                    return new zzdk(null);
                }
                return new zzdo();
            }
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zza", "zze", zzdn.zzb(), "zzf", zzdd.class});
        }
        return (byte) 1;
    }
}
