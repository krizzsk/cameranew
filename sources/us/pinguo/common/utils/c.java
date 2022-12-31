package us.pinguo.common.utils;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* compiled from: Base64.java */
/* loaded from: classes4.dex */
public class c {
    private static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] b = new byte[128];

    static {
        for (int i2 = 0; i2 < 128; i2++) {
            b[i2] = -1;
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            b[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 97; i4 <= 122; i4++) {
            b[i4] = (byte) ((i4 - 97) + 26);
        }
        for (int i5 = 48; i5 <= 57; i5++) {
            b[i5] = (byte) ((i5 - 48) + 52);
        }
        byte[] bArr = b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2;
        int length = bArr.length % 3;
        if (length == 0) {
            bArr2 = new byte[(bArr.length * 4) / 3];
        } else {
            bArr2 = new byte[((bArr.length / 3) + 1) * 4];
        }
        int length2 = bArr.length - length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            int i4 = bArr[i2] & Draft_75.END_OF_FRAME;
            int i5 = bArr[i2 + 1] & Draft_75.END_OF_FRAME;
            int i6 = bArr[i2 + 2] & Draft_75.END_OF_FRAME;
            byte[] bArr3 = a;
            bArr2[i3] = bArr3[(i4 >>> 2) & 63];
            bArr2[i3 + 1] = bArr3[((i4 << 4) | (i5 >>> 4)) & 63];
            bArr2[i3 + 2] = bArr3[((i5 << 2) | (i6 >>> 6)) & 63];
            bArr2[i3 + 3] = bArr3[i6 & 63];
            i2 += 3;
            i3 += 4;
        }
        if (length == 1) {
            int i7 = bArr[bArr.length - 1] & Draft_75.END_OF_FRAME;
            byte[] bArr4 = a;
            bArr2[bArr2.length - 4] = bArr4[(i7 >>> 2) & 63];
            bArr2[bArr2.length - 3] = bArr4[(i7 << 4) & 63];
            bArr2[bArr2.length - 2] = 61;
            bArr2[bArr2.length - 1] = 61;
        } else if (length == 2) {
            int i8 = bArr[bArr.length - 2] & Draft_75.END_OF_FRAME;
            int i9 = bArr[bArr.length - 1] & Draft_75.END_OF_FRAME;
            byte[] bArr5 = a;
            bArr2[bArr2.length - 4] = bArr5[(i8 >>> 2) & 63];
            bArr2[bArr2.length - 3] = bArr5[((i8 << 4) | (i9 >>> 4)) & 63];
            bArr2[bArr2.length - 2] = bArr5[(i9 << 2) & 63];
            bArr2[bArr2.length - 1] = 61;
        }
        return bArr2;
    }
}
