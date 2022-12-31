package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzehl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zzp(byte[] bArr) {
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[16];
            for (int i2 = 0; i2 < 16; i2++) {
                bArr2[i2] = (byte) ((bArr[i2] << 1) & 254);
                if (i2 < 15) {
                    bArr2[i2] = (byte) (bArr2[i2] | ((byte) ((bArr[i2 + 1] >> 7) & 1)));
                }
            }
            bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
            return bArr2;
        }
        throw new IllegalArgumentException("value must be a block.");
    }
}
