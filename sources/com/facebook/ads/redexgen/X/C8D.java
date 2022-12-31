package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.8D  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public enum C8D {
    A04,
    A05,
    A0J,
    A0C,
    A0E,
    A06,
    A0B,
    A08,
    A0M,
    A0F,
    A0G,
    A03,
    A07,
    A09,
    A0K,
    A0N,
    A0I,
    A0A,
    A0H,
    A0L,
    A0D;
    
    public static byte[] A00;
    public static String[] A01 = {"SXlbL1CY1HnlFue4Epuvc3q4430g41ka", "Q7EHaqXEYxiQEOiIyqjopxzkHRhZVKtw", "xNF", "uYQgnyI7xn5N5GOR4jmA1ry4yxIflSMQ", "rwtSlkdLuH5KaJR0oY6wYi8G8Rc4X5Yb", "KhrHqa8env5LHobs7dTfjp4HGZPf1i5f", "07o3NElFbIdfTqORF47AUY47", "YWtiaLPvBkX5SyS9ALyLBNGqlxgBLMMn"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[1].charAt(11) == strArr[7].charAt(11)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "W4gBMubxKiZM5LLivtLPs396PBqN8ReM";
            strArr2[0] = "lPif8zo0BCGymIa9nsJJXRn9Vdfcrwfz";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 99);
            i5++;
        }
    }

    public static void A01() {
        byte[] bArr = {103, 116, 116, 103, Byte.MAX_VALUE, 20, 25, 25, 26, 19, 23, 24, 64, 91, 86, 71, 122, 113, 120, 107, 84, 85, 83, 92, 81, 66, 85, 84, 48, 59, 33, 54, 56, 49, 21, 2, 2, 31, 2, 15, 18, 15, 9, 31, 30, 11, 8, 6, 15, 73, 67, 64, 78, 91, 11, 12, 22, 100, 99, 121, 104, Byte.MAX_VALUE, 126, 104, 110, 121, 100, 98, 99, 102, 101, 100, 109, 78, 79, 78, 69, 84, 79, 86, 86, 95, 68, 88, 85, 66, 28, Draft_75.CR, 15, 7, Draft_75.CR, 11, 9, 55, 44, 43, 54, 48, 20, 25, 16, 5, 22, 1, 18, 97, 122, 125, 123, 122, 64, 89, 95, 82, 90, 68, 65, 73, 78, 76, 95, 73};
        String[] strArr = A01;
        if (strArr[4].charAt(5) == strArr[0].charAt(5)) {
            throw new RuntimeException();
        }
        A01[6] = "Uq";
        A00 = bArr;
    }

    static {
        A01();
    }
}
