package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.9W  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9W {
    public static byte[] A02;
    public static String[] A03 = {"x3S2W4LbSFe5E5feiuJV3xvLrDJW5MIT", "c6l", "kksKjEgnZRd2qIBKnSBjD5FFw", "r4XHqvELKUQNiUGngs8vqNM0Mk3b9MGe", "kvUI2sJVOm05aD2rNLnp8ceY2vExoctW", "R5zC7nE0u0bj6wUda1FjOq7V7", "PNiW5N8GwPzy1zueKCYWrY6DC52FHCY", "sp7WuMlrQg67lkIbNPhafgU9zVWwTylU"};
    public final int A00;
    public final int A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 35);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-85, -48, -40, -61, -50, -53, -58, -126, -53, -48, -58, -57, -38, -90, -57, -50, -42, -61, -126, -118, -121, -58, -114, -126, -53, -48, -58, -57, -38, -126, -97, -126, -121, -58, -117, -88, -85, -82, -89, 98, 106, 103, -90, 107, 98, 126, 98, 111, 115, -93, -90, -87, -94, 93, 122, 93, 98, -95, 93, 99, 99, 93, -90, -85, -95, -94, -75, 93, 122, 93, 98, -95, -51, -48, -45, -52, -121, -92, -92, -121, -108, -104, -121, -115, -115, -121, -48, -43, -53, -52, -33, -121, -92, -121, -116, -53};
    }

    static {
        A01();
    }

    public C9W() {
        this(-1, -1);
    }

    public C9W(int i2, int i3) {
        if (i2 < -1) {
            throw new IllegalArgumentException(String.format(Locale.US, A00(35, 14, 31), Integer.valueOf(i2)));
        }
        if (i2 >= 0 && i3 < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, A00(49, 23, 26), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (i2 == -1 && i3 != -1) {
            throw new IllegalArgumentException(String.format(Locale.US, A00(72, 24, 68), Integer.valueOf(i3)));
        }
        this.A00 = i2;
        this.A01 = i3;
    }

    public final int A02() {
        return this.A00;
    }

    public final int A03() {
        return this.A01;
    }

    public final int A04(C9W c9w) {
        int i2 = this.A00;
        int i3 = c9w.A00;
        if (i2 != i3) {
            return i2 - i3;
        }
        return this.A01 - c9w.A01;
    }

    public final C9W A05(int i2) {
        int i3 = this.A01;
        if (i2 + i3 >= 0) {
            return new C9W(this.A00, i3 + i2);
        }
        throw new IllegalArgumentException(String.format(Locale.US, A00(0, 35, 63), Integer.valueOf(i2), Integer.valueOf(this.A01)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C9W) {
            C9W c9w = (C9W) obj;
            int i2 = c9w.A00;
            int i3 = this.A00;
            if (A03[4].charAt(2) != 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[2] = "8FF357LC7LaQaiaU3dBgrFv1B";
            strArr[5] = "tq4t252ij5wfM6c4Cr38q8OJQ";
            return i2 == i3 && c9w.A01 == this.A01;
        }
        return false;
    }

    public final int hashCode() {
        return (this.A00 * 2) + (this.A01 * 3);
    }
}
