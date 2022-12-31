package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelb;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzelc implements zzeml {
    private static final zzelc zziqn = new zzelc();

    private zzelc() {
    }

    public static zzelc zzbir() {
        return zziqn;
    }

    @Override // com.google.android.gms.internal.ads.zzeml
    public final boolean zze(Class<?> cls) {
        return zzelb.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeml
    public final zzemm zzf(Class<?> cls) {
        if (!zzelb.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzemm) zzelb.zzd(cls.asSubclass(zzelb.class)).zza(zzelb.zze.zziqu, (Object) null, (Object) null);
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e2);
        }
    }
}
