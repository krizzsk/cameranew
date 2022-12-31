package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: assets/audience_network.dex */
public final class KT {
    public static Map<String, Long> A00;
    public static Map<String, Long> A01;
    public static Map<String, String> A02;
    @SuppressLint({"NotWrittenPrivateField"})
    public static boolean A03;
    public static byte[] A04;
    public static String[] A05 = {"WcKxqk7L6BbuUQ1o7qmtmX6WSmYBceUW", "BgR1wHMut0LLHWxcn1vNnqjOmnDpA7yk", "nofrFHfyJT7pmG0QketyEOeNZ4PDBNqx", "tJ6rTzDc1vJYhzSuFM6hiX1fKi0tAXSV", "zeDIr51bIn8XcOdXOM6dVjfvh9EOKJZZ", "x4ZdmXYSSnH60B6WOaypztUTceO04NF4", "XXJyOaEVU", "eLFDRkAKNxNhqN4Dib4JBju5Hz9f2MYZ"};

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 64);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A04 = new byte[]{-35, 43, -14, -35, 43, -14, -35, 43, -14, -35, 28, -14, -35, 28, -14, -35, 28, -21, 25, -24, -28, -22, -21, -27, -25, -20, 10, 0, 5, -2, -73, 3, -8, 10, 11, -73, -8, -5, -73, 9, -4, 10, 7, 6, 5, 10, -4, 5, 3, 18, -22, -1, 17, 18, -16, 3, 17, 14, Draft_75.CR, 12, 17, 3};
    }

    static {
        A04();
        A01 = new ConcurrentHashMap();
        A00 = new ConcurrentHashMap();
        A02 = new ConcurrentHashMap();
        A03 = false;
    }

    public static long A00(String str, K6 k6) {
        if (A01.containsKey(str)) {
            return A01.get(str).longValue();
        }
        int i2 = KS.A00[k6.ordinal()];
        if (i2 != 1) {
            return (i2 == 2 || i2 == 3) ? -1000L : -1000L;
        } else if (A05[6].length() != 32) {
            String[] strArr = A05;
            strArr[4] = "PcZmlfQcdFNZlzEkEhUxMjsAcGnkg3Oc";
            strArr[7] = "bp21WTLlcRSzBiFixYai9jfTwoum3UGv";
            return 15000L;
        } else {
            throw new RuntimeException();
        }
    }

    public static String A02(KU ku) {
        KI.A05(A01(47, 15, 94), A01(25, 22, 87), A01(17, 8, 116));
        return A02.get(A03(ku));
    }

    public static String A03(KU ku) {
        Locale locale = Locale.US;
        Object[] objArr = new Object[6];
        objArr[0] = ku.A07();
        objArr[1] = ku.A04();
        objArr[2] = ku.A05();
        objArr[3] = Integer.valueOf(ku.A06() == null ? 0 : ku.A06().A00());
        objArr[4] = Integer.valueOf(ku.A06() != null ? ku.A06().A01() : 0);
        objArr[5] = Integer.valueOf(ku.A03());
        return String.format(locale, A01(0, 17, 120), objArr);
    }

    public static void A05(long j2, KU ku) {
        A01.put(A03(ku), Long.valueOf(j2));
    }

    public static void A06(KU ku) {
        A00.put(A03(ku), Long.valueOf(System.currentTimeMillis()));
    }

    public static void A07(String str, KU ku) {
        A02.put(A03(ku), str);
    }

    public static boolean A08(KU ku) {
        if (A03) {
            return false;
        }
        String A032 = A03(ku);
        if (A00.containsKey(A032)) {
            Long l2 = A00.get(A032);
            if (A05[3].charAt(17) != 'M') {
                throw new RuntimeException();
            }
            A05[6] = "HNdF4hlEpt9Mz";
            return System.currentTimeMillis() - l2.longValue() < A00(A032, ku.A04());
        }
        return false;
    }
}
