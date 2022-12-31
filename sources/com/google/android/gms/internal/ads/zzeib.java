package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeib implements zzeaq {
    private final zzeio zzijy;
    private final zzebd zzijz;
    private final int zzika;

    public zzeib(zzeio zzeioVar, zzebd zzebdVar, int i2) {
        this.zzijy = zzeioVar;
        this.zzijz = zzebdVar;
        this.zzika = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzn = this.zzijy.zzn(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzeho.zza(zzn, this.zzijz.zzk(zzeho.zza(bArr2, zzn, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }
}
