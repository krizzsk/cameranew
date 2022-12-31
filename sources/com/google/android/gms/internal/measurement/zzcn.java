package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzcn extends zzhs<zzcn, zzcm> implements zziy {
    private static final zzcn zzi;
    private int zza;
    private String zze = "";
    private boolean zzf;
    private boolean zzg;
    private int zzh;

    static {
        zzcn zzcnVar = new zzcn();
        zzi = zzcnVar;
        zzhs.zzby(zzcn.class, zzcnVar);
    }

    private zzcn() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzcn zzcnVar, String str) {
        str.getClass();
        zzcnVar.zza |= 1;
        zzcnVar.zze = str;
    }

    public final String zza() {
        return this.zze;
    }

    public final boolean zzb() {
        return this.zzf;
    }

    public final boolean zzc() {
        return this.zzg;
    }

    public final boolean zzd() {
        return (this.zza & 8) != 0;
    }

    public final int zze() {
        return this.zzh;
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
                        return zzi;
                    }
                    return new zzcm(null);
                }
                return new zzcn();
            }
            return zzhs.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zza", "zze", "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }
}
