package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzedi implements zzeat {
    private final zzebf<zzeat> zzidn;

    public zzedi(zzebf<zzeat> zzebfVar) {
        this.zzidn = zzebfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeat
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzeho.zza(this.zzidn.zzbar().zzbaw(), this.zzidn.zzbar().zzbat().zzc(bArr, bArr2));
    }
}
