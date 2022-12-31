package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.0g  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04780g {
    public static byte[] A00;
    public static final String A01;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 33);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{111, 84, 91, 88, 86, 95, 26, 78, 85, 26, 74, 91, 72, 73, 95, 26, 80, 73, 85, 84, 26, 94, 91, 78, 91, 26, 83, 84, 26, 123, 94, 123, 89, 78, 83, 85, 84, 124, 91, 89, 78, 85, 72, 67, 20, 19, 22, 3, 22, 82, 77, 88, 83, 98, 81, 84, 83, 86, 94, 79, 92, 93, 71, 64, 73, 98, 115, 97, 97, 102, 122, 96, 125, 103, 117, 122, 24, 31, 4, 25, 14, 34, 61, 48, 49, 59, 11, 33, 38, 56};
    }

    static {
        A03();
        A01 = C04780g.class.getSimpleName();
    }

    @Nullable
    public static AbstractC04770f A00(XT xt, JT jt, String str, Uri uri, Map<String, String> extraData) {
        return A01(xt, jt, str, uri, extraData, true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.ads.redexgen.X.AbstractC04770f A01(com.facebook.ads.redexgen.X.XT r15, com.facebook.ads.redexgen.X.JT r16, java.lang.String r17, android.net.Uri r18, java.util.Map<java.lang.String, java.lang.String> r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C04780g.A01(com.facebook.ads.redexgen.X.XT, com.facebook.ads.redexgen.X.JT, java.lang.String, android.net.Uri, java.util.Map, boolean, boolean):com.facebook.ads.redexgen.X.0f");
    }

    public static boolean A04(String str) {
        return A02(76, 5, 74).equalsIgnoreCase(str) || A02(49, 9, 28).equalsIgnoreCase(str);
    }
}
