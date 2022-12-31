package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzebr implements zzebh<zzeaq, zzeaq> {
    private static final Logger logger = Logger.getLogger(zzebr.class.getName());

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    private static class zza implements zzeaq {
        private final zzebf<zzeaq> zzicu;

        private zza(zzebf<zzeaq> zzebfVar) {
            this.zzicu = zzebfVar;
        }

        @Override // com.google.android.gms.internal.ads.zzeaq
        public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return zzeho.zza(this.zzicu.zzbar().zzbaw(), this.zzicu.zzbar().zzbat().zzc(bArr, bArr2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebh
    public final /* synthetic */ zzeaq zza(zzebf<zzeaq> zzebfVar) throws GeneralSecurityException {
        return new zza(zzebfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzebh
    public final Class<zzeaq> zzbai() {
        return zzeaq.class;
    }

    @Override // com.google.android.gms.internal.ads.zzebh
    public final Class<zzeaq> zzbas() {
        return zzeaq.class;
    }
}
