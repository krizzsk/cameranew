package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.2P  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2P {
    public static final int[] A00 = new int[0];
    public static final long[] A01 = new long[0];
    public static final Object[] A02 = new Object[0];

    public static int A00(int i2) {
        return A01(i2 * 8) / 8;
    }

    public static int A01(int i2) {
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                return (1 << i3) - 12;
            }
        }
        return i2;
    }

    public static int A02(int[] iArr, int i2, int mid) {
        int midVal = 0;
        int i3 = i2 - 1;
        while (midVal <= i3) {
            int i4 = (midVal + i3) >>> 1;
            int i5 = iArr[i4];
            if (i5 < mid) {
                midVal = i4 + 1;
            } else if (i5 > mid) {
                i3 = i4 - 1;
            } else {
                return i4;
            }
        }
        return midVal ^ (-1);
    }

    public static int A03(long[] jArr, int i2, long j2) {
        int i3 = 0;
        int i4 = i2 - 1;
        while (i3 <= i4) {
            int i5 = (i3 + i4) >>> 1;
            long j3 = jArr[i5];
            if (j3 < j2) {
                i3 = i5 + 1;
            } else if (j3 > j2) {
                i4 = i5 - 1;
            } else {
                return i5;
            }
        }
        return i3 ^ (-1);
    }

    public static boolean A04(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
