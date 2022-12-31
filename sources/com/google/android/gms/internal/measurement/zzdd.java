package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzdd extends zzhs<zzdd, zzdc> implements zziy {
    private static final zzdd zzg;
    private int zza;
    private String zze = "";
    private long zzf;

    static {
        zzdd zzddVar = new zzdd();
        zzg = zzddVar;
        zzhs.zzby(zzdd.class, zzddVar);
    }

    private zzdd() {
    }

    public static zzdc zza() {
        return zzg.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(zzdd zzddVar, String str) {
        str.getClass();
        zzddVar.zza |= 1;
        zzddVar.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzdd zzddVar, long j2) {
        zzddVar.zza |= 2;
        zzddVar.zzf = j2;
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
                    return new zzdc(null);
                }
                return new zzdd();
            }
            return zzhs.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zza", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
