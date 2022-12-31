package com.pinguo.camera360.cloud.cropImage;
/* compiled from: CropImageUtils.java */
/* loaded from: classes3.dex */
public class b {
    private static boolean a = false;
    private static long[] b = new long[256];

    public static long a(String str) {
        if (str == null || str.length() == 0) {
            return 0L;
        }
        long j2 = -1;
        if (!a) {
            for (int i2 = 0; i2 < 256; i2++) {
                long j3 = i2;
                for (int i3 = 0; i3 < 8; i3++) {
                    j3 = (((int) j3) & 1) != 0 ? (j3 >> 1) ^ (-7661587058870466123L) : j3 >> 1;
                }
                b[i2] = j3;
            }
            a = true;
        }
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            j2 = (j2 >> 8) ^ b[(str.charAt(i4) ^ ((int) j2)) & 255];
        }
        return j2;
    }
}
