package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzdh extends zzhs<zzdh, zzdg> implements zziy {
    private static final zzdh zze;
    private zzhz<zzdj> zza = zzhs.zzbE();

    static {
        zzdh zzdhVar = new zzdh();
        zze = zzdhVar;
        zzhs.zzby(zzdh.class, zzdhVar);
    }

    private zzdh() {
    }

    public static zzdg zzc() {
        return zze.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzdh zzdhVar, zzdj zzdjVar) {
        zzdjVar.getClass();
        zzhz<zzdj> zzhzVar = zzdhVar.zza;
        if (!zzhzVar.zza()) {
            zzdhVar.zza = zzhs.zzbF(zzhzVar);
        }
        zzdhVar.zza.add(zzdjVar);
    }

    public final List<zzdj> zza() {
        return this.zza;
    }

    public final zzdj zzb(int i2) {
        return this.zza.get(0);
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
                        return zze;
                    }
                    return new zzdg(null);
                }
                return new zzdh();
            }
            return zzhs.zzbz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzdj.class});
        }
        return (byte) 1;
    }
}
