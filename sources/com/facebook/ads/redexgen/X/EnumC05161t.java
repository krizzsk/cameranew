package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.1t  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC05161t {
    A03,
    A07,
    A06,
    A08,
    A09,
    A04,
    A05;
    
    public static byte[] A00;
    public static String[] A01 = {"qS0jzzy053U49Su1PxhqxbWBiRBDhrlz", "Xt2DRLlKFdB95NsINvyqeyDnMxOOuDLx", "yf08nX9dIZfcKypKRld4zDkH94BCZAU7", "tfbakkmOh5dxCJghzZjKfCWWzPpI", "7IyHNSQ2TJBMgpMVEgH3C5YFRcP1ce7U", "xEQSxTjWMbA9c974QplA5JGviijwmXcM", "x69Rlf5MxzDhXyXzxEdLcnVcx3iMgH2Y", "aVnA9Ux0owpYjW5hlcDkLBIQBKS6Kuco"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 13);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-91, -76, -89, -93, -74, -89, -90, -57, -56, -42, -41, -43, -46, -36, -56, -57, 117, -126, -126, Byte.MAX_VALUE, -126, -111, -108, -122, -119, -118, -119, -50, -47, -61, -58, -53, -48, -55, 110, 99, 106, 114, 100, 105, 98, -40, -51, -44, -36, -45};
        if (A01[1].charAt(25) == 'M') {
            throw new RuntimeException();
        }
        A01[1] = "ORHYqq2J4PQNu3tNdzrtPOmYFobQNh7q";
    }

    static {
        A01();
    }
}
