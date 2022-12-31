package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzadw {
    private static final AtomicReference<zzadx> zzdfd = new AtomicReference<>();
    static final AtomicBoolean zzdfe = new AtomicBoolean();

    public static void zza(zzadx zzadxVar) {
        zzdfd.set(zzadxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzadx zztc() {
        return zzdfd.get();
    }
}
