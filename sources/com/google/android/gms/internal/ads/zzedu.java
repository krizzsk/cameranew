package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
class zzedu implements zzebh<zzebd, zzebd> {
    private static final Logger logger = Logger.getLogger(zzedu.class.getName());

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    private static class zza implements zzebd {
        private final zzebf<zzebd> zzidn;
        private final byte[] zzidy;

        private zza(zzebf<zzebd> zzebfVar) {
            this.zzidy = new byte[]{0};
            this.zzidn = zzebfVar;
        }

        @Override // com.google.android.gms.internal.ads.zzebd
        public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
            if (this.zzidn.zzbar().zzbav().equals(zzegx.LEGACY)) {
                return zzeho.zza(this.zzidn.zzbar().zzbaw(), this.zzidn.zzbar().zzbat().zzk(zzeho.zza(bArr, this.zzidy)));
            }
            return zzeho.zza(this.zzidn.zzbar().zzbaw(), this.zzidn.zzbar().zzbat().zzk(bArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebh
    public final /* synthetic */ zzebd zza(zzebf<zzebd> zzebfVar) throws GeneralSecurityException {
        return new zza(zzebfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzebh
    public final Class<zzebd> zzbai() {
        return zzebd.class;
    }

    @Override // com.google.android.gms.internal.ads.zzebh
    public final Class<zzebd> zzbas() {
        return zzebd.class;
    }
}
