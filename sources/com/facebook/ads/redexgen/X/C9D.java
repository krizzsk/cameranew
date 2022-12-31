package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.9D  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9D {
    public static HashMap<String, String> A00;
    public static byte[] A01;
    public static String[] A02 = {"khEJJSEBeZAj3OAxCgzNidlYCZn1WdrQ", "WigI19L", "nVQbXZzkIzZCm6ed4Wwsa9gCOy", "HTplkKsJZ28QwTvwNKGrQ1qXfC2z", "xAVvuzXwzMicNcIETZjP5vM2paYATPUF", "ZQBu7F3mQUfNW6aD", "dGQdYWCLx", "hFrznfqGyDFETBry94BNLT7Zi42G"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 101);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{63, 46, 46, 60, 43, 55, 50, 58, 118, 103, 103, 121, 118, 122, 114, 27, 10, 10, 12, 31, 8, 9, Draft_75.CR, 34, 40, 62, 35, 37, 40, 32, 55, 44, 38, 46, 39, Draft_75.CR, 15, 4, 5, 12, 53, 41, 121, 101, 96, 115, 100, 101, 114, 101, 106, 126, 105, 102, 114, 123, 104, Byte.MAX_VALUE, 126, 100, 98, 99, 1, 23, 1, 1, 27, 29, 28, Draft_75.CR, 27, 22, 53, 58, 48, 38, 59, 61, 48};
    }

    static {
        A03();
    }

    public static synchronized Map<String, String> A01(C8J c8j) {
        synchronized (C9D.class) {
            if (A00 != null) {
                return new HashMap(A00);
            }
            A00 = new HashMap<>();
            A00.put(A00(29, 6, 7), c8j.getPackageName());
            A02(c8j, A00);
            HashMap hashMap = new HashMap(A00);
            if (A02[6].length() != 9) {
                throw new RuntimeException();
            }
            A02[4] = "csszmLyTseT6qvLdDZ4XLWwozasc9BBN";
            return hashMap;
        }
    }

    public static synchronized Map<String, String> A02(C8J c8j, Map<String, String> map) {
        synchronized (C9D.class) {
            map.put(A00(48, 3, 68), A00(72, 7, 49));
            map.put(A00(51, 11, 72), c8j.A03().A7f());
            map.put(A00(40, 2, 31), A00(22, 7, 41));
            map.put(A00(42, 6, 83), C06908w.A03);
            C06908w c06908w = new C06908w(c8j);
            map.put(A00(15, 7, 63), c06908w.A05());
            map.put(A00(8, 7, 82), c06908w.A04());
            map.put(A00(0, 8, 27), String.valueOf(c06908w.A03()));
            map.put(A00(35, 5, 37), c06908w.A09());
            map.put(A00(62, 10, 55), c8j.A07().A02());
        }
        return map;
    }
}
