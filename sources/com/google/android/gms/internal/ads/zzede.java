package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzede implements zzebh<zzeau, zzeau> {
    private static final Logger logger = Logger.getLogger(zzede.class.getName());

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    private static class zza implements zzeau {
        private final zzebf<zzeau> zzidn;

        public zza(zzebf<zzeau> zzebfVar) {
            this.zzidn = zzebfVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebh
    public final /* synthetic */ zzeau zza(zzebf<zzeau> zzebfVar) throws GeneralSecurityException {
        return new zza(zzebfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzebh
    public final Class<zzeau> zzbai() {
        return zzeau.class;
    }

    @Override // com.google.android.gms.internal.ads.zzebh
    public final Class<zzeau> zzbas() {
        return zzeau.class;
    }
}
