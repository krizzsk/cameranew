package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeiq implements zzedv {
    private final SecretKey zzidi;
    private byte[] zziku;
    private byte[] zzikv;

    public zzeiq(byte[] bArr) throws GeneralSecurityException {
        zzeiv.zzfu(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzidi = secretKeySpec;
        Cipher zzbfs = zzbfs();
        zzbfs.init(1, secretKeySpec);
        byte[] zzp = zzehl.zzp(zzbfs.doFinal(new byte[16]));
        this.zziku = zzp;
        this.zzikv = zzehl.zzp(zzp);
    }

    private static Cipher zzbfs() throws GeneralSecurityException {
        return zzeie.zzikg.zzhw("AES/ECB/NoPadding");
    }

    @Override // com.google.android.gms.internal.ads.zzedv
    public final byte[] zzd(byte[] bArr, int i2) throws GeneralSecurityException {
        byte[] zzd;
        if (i2 <= 16) {
            Cipher zzbfs = zzbfs();
            zzbfs.init(1, this.zzidi);
            int max = Math.max(1, (int) Math.ceil(bArr.length / 16.0d));
            if ((max << 4) == bArr.length) {
                zzd = zzeho.zza(bArr, (max - 1) << 4, this.zziku, 0, 16);
            } else {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
                if (copyOfRange.length < 16) {
                    byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                    copyOf[copyOfRange.length] = Byte.MIN_VALUE;
                    zzd = zzeho.zzd(copyOf, this.zzikv);
                } else {
                    throw new IllegalArgumentException("x must be smaller than a block.");
                }
            }
            byte[] bArr2 = new byte[16];
            for (int i3 = 0; i3 < max - 1; i3++) {
                bArr2 = zzbfs.doFinal(zzeho.zza(bArr2, 0, bArr, i3 << 4, 16));
            }
            return Arrays.copyOf(zzbfs.doFinal(zzeho.zzd(zzd, bArr2)), i2);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
