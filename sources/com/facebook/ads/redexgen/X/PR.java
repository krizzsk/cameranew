package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class PR {
    public static byte[] A00;
    public static String[] A01 = {"FlapraKYinr7Nj6zb2x", "Je7Oc75DeV26JYLGdoAYQBFZl5wXaWlc", "6eSxJX", "aEepWtzNMaW6JZj4waJ23HNf2aIS7LoC", "JwlyhY0m7wRpvvwBZvP15fqQyn91MpTE", "PlE1oLNOrYKtW3AWK6zlObYGaKJphnE8", "QTcNGp4T1DOVQL9", "izKSydL2onnSjNYNNJlTpUx2BXz"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = (byte) ((copyOfRange[i5] - i4) - 93);
            String[] strArr = A01;
            if (strArr[3].charAt(25) == strArr[4].charAt(25)) {
                throw new RuntimeException();
            }
            A01[7] = "ZkkNqMbSq2X5uLLX3N";
            copyOfRange[i5] = b;
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{18, 10, 17, 10, 12, -38, 7, -3, 11, 8, 2, -3, 34, 49, 49, 32, 47, 34, 46, 38, 42, 43, 60, 47, 41, 43, 37, 51, 53, 42, 43, 50, 69, 72, 60, 58, 69, 62, 50, 54, 33, 37, 17, 40, 23, 36, -14, -29, -12, -10, -16, -25, -12, -31, -25, -16, -26, -14, -15, -21, -16, -10, 10, 6, -5, 19, -5, -4, 6, -1, -7, 8, -5, 7, -1, -22, -38, -23, -36, -36, -27, -42, -33, -36, -32, -34, -33, -21, -48, -64, -49, -62, -62, -53, -68, -44, -58, -63, -47, -59, Draft_75.CR, -2, 5, -7, 16, -1, 12, Draft_75.CR, 3, 9, 8, 1, -13, 1, 1, -9, -3, -4, -19, -9, -14};
    }

    static {
        A02();
    }

    public static Map<String, String> A01(C8J c8j, String str, String str2) {
        HashMap hashMap = new HashMap();
        C06908w c06908w = new C06908w(c8j);
        int i2 = c8j.getResources().getDisplayMetrics().widthPixels;
        int i3 = c8j.getResources().getDisplayMetrics().heightPixels;
        hashMap.put(A00(111, 10, 49), c8j.A07().A02());
        hashMap.put(A00(62, 13, 61), str2);
        hashMap.put(A00(46, 16, 37), str);
        hashMap.put(A00(20, 12, 105), String.valueOf(c06908w.A08()));
        hashMap.put(A00(88, 12, 0), String.valueOf((int) (i2 / LY.A00)));
        hashMap.put(A00(75, 13, 26), String.valueOf((int) (i3 / LY.A00)));
        hashMap.put(A00(38, 2, 102), A00(5, 7, 60));
        hashMap.put(A00(40, 6, 85), C06908w.A03);
        hashMap.put(A00(32, 6, 124), Locale.getDefault().toString());
        hashMap.put(A00(100, 11, 61), A00(0, 5, 127));
        hashMap.put(A00(12, 8, 100), c06908w.A04());
        return hashMap;
    }
}
