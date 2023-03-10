package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeir implements zzebd {
    private final zzedv zzikw;
    private final int zzikx;

    public zzeir(zzedv zzedvVar, int i2) throws GeneralSecurityException {
        this.zzikw = zzedvVar;
        this.zzikx = i2;
        if (i2 >= 10) {
            zzedvVar.zzd(new byte[0], i2);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    @Override // com.google.android.gms.internal.ads.zzebd
    public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
        return this.zzikw.zzd(bArr, this.zzikx);
    }
}
