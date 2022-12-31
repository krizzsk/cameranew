package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzhe {
    static final zzhe zza = new zzhe(true);
    private static volatile boolean zzb = false;
    private static volatile zzhe zzc;
    private static volatile zzhe zzd;
    private final Map<zzhd, zzhq<?, ?>> zze;

    zzhe() {
        this.zze = new HashMap();
    }

    public static zzhe zza() {
        zzhe zzheVar = zzc;
        if (zzheVar == null) {
            synchronized (zzhe.class) {
                zzheVar = zzc;
                if (zzheVar == null) {
                    zzheVar = zza;
                    zzc = zzheVar;
                }
            }
        }
        return zzheVar;
    }

    public static zzhe zzb() {
        zzhe zzheVar = zzd;
        if (zzheVar != null) {
            return zzheVar;
        }
        synchronized (zzhe.class) {
            zzhe zzheVar2 = zzd;
            if (zzheVar2 != null) {
                return zzheVar2;
            }
            zzhe zzb2 = zzhm.zzb(zzhe.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final <ContainingType extends zzix> zzhq<ContainingType, ?> zzc(ContainingType containingtype, int i2) {
        return (zzhq<ContainingType, ?>) this.zze.get(new zzhd(containingtype, i2));
    }

    zzhe(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
