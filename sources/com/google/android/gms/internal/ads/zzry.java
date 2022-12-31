package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzry extends zzrv {
    private MessageDigest zzbuj;

    @Override // com.google.android.gms.internal.ads.zzrv
    public final byte[] zzbq(String str) {
        byte[] bArr;
        byte[] bArr2;
        String[] split = str.split(" ");
        int i2 = 4;
        if (split.length == 1) {
            int zzbr = zzrz.zzbr(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zzbr);
            bArr2 = allocate.array();
        } else {
            if (split.length < 5) {
                bArr = new byte[split.length << 1];
                for (int i3 = 0; i3 < split.length; i3++) {
                    int zzbr2 = zzrz.zzbr(split[i3]);
                    int i4 = (zzbr2 >> 16) ^ (65535 & zzbr2);
                    byte[] bArr3 = {(byte) i4, (byte) (i4 >> 8)};
                    int i5 = i3 << 1;
                    bArr[i5] = bArr3[0];
                    bArr[i5 + 1] = bArr3[1];
                }
            } else {
                bArr = new byte[split.length];
                for (int i6 = 0; i6 < split.length; i6++) {
                    int zzbr3 = zzrz.zzbr(split[i6]);
                    bArr[i6] = (byte) ((zzbr3 >> 24) ^ (((zzbr3 & 255) ^ ((zzbr3 >> 8) & 255)) ^ ((zzbr3 >> 16) & 255)));
                }
            }
            bArr2 = bArr;
        }
        this.zzbuj = zzms();
        synchronized (this.mLock) {
            MessageDigest messageDigest = this.zzbuj;
            if (messageDigest == null) {
                return new byte[0];
            }
            messageDigest.reset();
            this.zzbuj.update(bArr2);
            byte[] digest = this.zzbuj.digest();
            if (digest.length <= 4) {
                i2 = digest.length;
            }
            byte[] bArr4 = new byte[i2];
            System.arraycopy(digest, 0, bArr4, 0, i2);
            return bArr4;
        }
    }
}
