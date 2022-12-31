package com.google.android.gms.common.util;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class j {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = b2 & Draft_75.END_OF_FRAME;
            int i4 = i2 + 1;
            char[] cArr2 = b;
            cArr[i2] = cArr2[i3 >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    public static String b(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length << 1);
        for (int i2 = 0; i2 < length && (!z || i2 != length - 1 || (bArr[i2] & Draft_75.END_OF_FRAME) != 0); i2++) {
            char[] cArr = a;
            sb.append(cArr[(bArr[i2] & 240) >>> 4]);
            sb.append(cArr[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    public static byte[] c(String str) throws IllegalArgumentException {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[length / 2];
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 2;
                bArr[i2 / 2] = (byte) Integer.parseInt(str.substring(i2, i3), 16);
                i2 = i3;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Hex string has odd number of characters");
    }
}
