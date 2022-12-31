package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.10  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public enum AnonymousClass10 {
    A04(A00(37, 9, 87)),
    A06(A00(65, 9, 105)),
    A05(A00(46, 19, 116));
    
    public static byte[] A01;
    public static String[] A02 = {"YotGzB", "vsIS7NXYgiAbF4rLaahac", "Gskj2bStDtfNdzDdRe0hP24NDR2IpNEh", "oK8ItqR6UoxvIOFM7x85SOaiyNHULhPY", "o1G33SUpx5mnfpgWjDd1nYNG2RlEgzpj", "XWwbNlOGXItiEE2sGKxxfB9q5lH48KSv", "87nuLIKIZqBBcXVSFSOV", "vURZxB8V7SUFjdRy9aiCBcJV1"};
    public final String A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 54);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{99, 116, 99, 107, 110, 99, 96, 110, 103, 125, 124, 108, 125, 114, 103, 122, 101, 118, 108, 114, 119, 108, Byte.MAX_VALUE, 114, 106, 124, 102, 103, 105, 114, 114, 98, 110, 112, 124, 113, 113, 0, 23, 0, 8, Draft_75.CR, 0, 3, Draft_75.CR, 4, 44, 45, 29, 44, 35, 54, 43, 52, 39, 29, 35, 38, 29, 46, 35, 59, 45, 55, 54, 43, 48, 48, 0, 44, 50, 62, 51, 51};
        if (A02[3].charAt(28) != 'L') {
            throw new RuntimeException();
        }
        A02[6] = "yw";
    }

    static {
        A01();
    }

    AnonymousClass10(String str) {
        this.A00 = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.A00;
    }
}
