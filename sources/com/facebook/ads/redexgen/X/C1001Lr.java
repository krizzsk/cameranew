package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.StringTokenizer;
/* renamed from: com.facebook.ads.redexgen.X.Lr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1001Lr {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 97);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{25, 65, 65, 65};
    }

    public static String A01(String truncatedBody) {
        if (truncatedBody != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(truncatedBody, A00(0, 1, 88), true);
            int i2 = 0;
            if (truncatedBody.length() > 90) {
                int length = truncatedBody.length();
                String A002 = A00(1, 3, 14);
                if (length > 93 || !truncatedBody.endsWith(A002)) {
                    while (stringTokenizer.hasMoreTokens()) {
                        int tokenLength = stringTokenizer.nextToken().length();
                        if (i2 + tokenLength < 90) {
                            i2 += tokenLength;
                        }
                    }
                    if (i2 == 0) {
                        return truncatedBody.substring(0, 90) + A002;
                    }
                    return truncatedBody.substring(0, i2) + A002;
                }
                return truncatedBody;
            }
            return truncatedBody;
        }
        return truncatedBody;
    }
}
