package com.growingio.android.sdk.encrypt;
/* loaded from: classes2.dex */
public class XORUtils {
    public static byte[] encrypt(byte[] bArr, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr2[i3] = (byte) (bArr[i3] ^ i2);
        }
        return bArr2;
    }
}
