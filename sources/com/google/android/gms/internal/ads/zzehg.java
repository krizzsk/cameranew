package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzehg implements zzeio {
    private static final ThreadLocal<Cipher> zzidh = new zzehf();
    private final SecretKeySpec zziiv;
    private final int zziiw;
    private final int zziix;

    public zzehg(byte[] bArr, int i2) throws GeneralSecurityException {
        zzeiv.zzfu(bArr.length);
        this.zziiv = new SecretKeySpec(bArr, "AES");
        int blockSize = zzidh.get().getBlockSize();
        this.zziix = blockSize;
        if (i2 >= 12 && i2 <= blockSize) {
            this.zziiw = i2;
            return;
        }
        throw new GeneralSecurityException("invalid IV size");
    }

    @Override // com.google.android.gms.internal.ads.zzeio
    public final byte[] zzn(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.zziiw;
        if (length <= Integer.MAX_VALUE - i2) {
            byte[] bArr2 = new byte[bArr.length + i2];
            byte[] zzft = zzeiu.zzft(i2);
            System.arraycopy(zzft, 0, bArr2, 0, this.zziiw);
            int length2 = bArr.length;
            int i3 = this.zziiw;
            Cipher cipher = zzidh.get();
            byte[] bArr3 = new byte[this.zziix];
            System.arraycopy(zzft, 0, bArr3, 0, this.zziiw);
            cipher.init(1, this.zziiv, new IvParameterSpec(bArr3));
            if (cipher.doFinal(bArr, 0, length2, bArr2, i3) == length2) {
                return bArr2;
            }
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("plaintext length can not exceed ");
        sb.append(Integer.MAX_VALUE - this.zziiw);
        throw new GeneralSecurityException(sb.toString());
    }
}
