package com.tencent.stat.common;
/* loaded from: classes3.dex */
public class e {
    static final byte[] a = "03a976511e2cbe3a7f26808fb7af3c05".getBytes();

    public static byte[] a(byte[] bArr) {
        return a(bArr, a);
    }

    static byte[] a(byte[] bArr, byte[] bArr2) {
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        int length = bArr2.length;
        if (length < 1 || length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
            iArr2[i2] = bArr2[i2 % length];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i3 = (i3 + iArr[i4] + iArr2[i4]) & 255;
            int i5 = iArr[i4];
            iArr[i4] = iArr[i3];
            iArr[i3] = i5;
        }
        byte[] bArr3 = new byte[bArr.length];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < bArr.length; i8++) {
            i6 = (i6 + 1) & 255;
            i7 = (i7 + iArr[i6]) & 255;
            int i9 = iArr[i6];
            iArr[i6] = iArr[i7];
            iArr[i7] = i9;
            bArr3[i8] = (byte) (iArr[(iArr[i6] + iArr[i7]) & 255] ^ bArr[i8]);
        }
        return bArr3;
    }

    public static byte[] b(byte[] bArr) {
        return b(bArr, a);
    }

    static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2);
    }
}
