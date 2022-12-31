package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.7M  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C7M {
    public static int A00;
    public static int A01;
    public static int A02;
    public static int A03;
    public static int A04;
    public static int A05;
    public static int A06;
    public static int A07;
    public static byte[] A08;
    public static final String A09;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 62);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{-120, -90, -88, -83, -86, 101, -87, -82, -72, -80, 101, -85, -90, -82, -79, -70, -73, -86, 115, -63, -33, -31, -26, -29, -98, -30, -25, -15, -23, -98, -15, -13, -31, -31, -29, -15, -15, -84, -63, -33, -31, -26, -29, -98, -30, -19, -11, -20, -22, -19, -33, -30, -98, -28, -33, -25, -22, -13, -16, -29, -84, -127, -97, -95, -90, -93, 94, -90, -89, -78, 108, -72, -42, -40, -35, -38, -107, -30, -34, -24, -24, -93, -83, -80, -85, -81, -66, -79, -83, -64, -75, -62, -79, -85, -65, -75, -58, -79, -85, -82, -59, -64, -79, -65, -55, -52, -57, -53, -38, -51, -55, -36, -47, -34, -51, -57, -36, -31, -40, -51, -95, -92, -97, -90, -81, -78, -83, -95, -76, -97, -76, -71, -80, -91, 21, 24, 19, 38, 25, 37, 41, 25, 39, 40, 19, 29, 24, -79, -60, -60, -75, -67, -64, -60, -78, -80, -78, -73, -76, 24, 22, 24, 29, 26, 20, 24, 36, 35, 41, 26, 45, 41, -50, -55, -47, -44, -35, -38, -51, -57, -38, -51, -55, -37, -41, -42, 22, 26, 14, 20, 18, 11, 14, 0, 3, -2, 19, 8, 12, 4, 5, 2, -4};
    }

    static {
        A01();
        A09 = C7M.class.getSimpleName();
        A05 = C06808m.A0g;
        A06 = C06808m.A0k;
        A02 = C06808m.A0d;
        A01 = C06808m.A0c;
        A03 = C06808m.A0e;
        A00 = C06808m.A0a;
        A04 = C06808m.A0f;
        A07 = C06808m.A0l;
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A02(C8J c8j, C7C c7c, int i2, String str, long j2) {
        if (!A06(c8j)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 2), c7c.A00);
            jSONObject.put(A00(134, 13, 118), c7c.A01);
            if (j2 > 0) {
                jSONObject.put(A00(191, 9, 97), C1008Ly.A06(System.currentTimeMillis() - j2));
            }
            C06818n c06818n = new C06818n(str);
            c06818n.A05(jSONObject);
            c06818n.A03(1);
            c8j.A06().A8r(A00(154, 5, 17), i2, c06818n);
        } catch (Throwable th) {
            c8j.A06().A3P(th);
        }
    }

    public static void A03(C8J c8j, C7G c7g, String str, int i2, @Nullable String str2, @Nullable Integer num, @Nullable Long l2) {
        if (A06(c8j)) {
            A05(c8j, c7g.A05, c7g.A06, c7g.A07, A00(186, 5, 111), str, i2, str2, num, l2, null);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A04(C8J c8j, C7L c7l, boolean z) {
        if (!A06(c8j)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 2), c7l.A00);
            jSONObject.put(A00(134, 13, 118), c7l.A03);
            jSONObject.put(A00(104, 16, 42), c7l.A02);
            jSONObject.put(A00(159, 13, 119), c7l.A01);
            if (JD.A1X(c8j)) {
                jSONObject.put(A00(200, 3, 82), c7l.A04);
            }
            String A002 = z ? A00(61, 10, 0) : A00(71, 11, 55);
            int i2 = z ? A05 : A06;
            C06818n c06818n = new C06818n(A002);
            c06818n.A05(jSONObject);
            c06818n.A03(1);
            c8j.A06().A8r(A00(154, 5, 17), i2, c06818n);
        } catch (Throwable th) {
            c8j.A06().A3P(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A05(C8J c8j, String str, String str2, String str3, String str4, String str5, int i2, @Nullable String str6, @Nullable Integer num, @Nullable Long l2, @Nullable Integer num2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 2), str);
            jSONObject.put(A00(134, 13, 118), str2);
            jSONObject.put(A00(104, 16, 42), str4);
            if (str6 != null) {
                jSONObject.put(A00(172, 14, 42), str6);
            }
            if (num != null) {
                jSONObject.put(A00(82, 22, 14), String.valueOf(num));
            }
            if (l2 != null) {
                jSONObject.put(A00(191, 9, 97), String.valueOf(l2));
            }
            if (num2 != null) {
                jSONObject.put(A00(147, 7, 18), String.valueOf(num2));
            }
            jSONObject.put(A00(159, 13, 119), str5);
            if (JD.A1X(c8j)) {
                jSONObject.put(A00(200, 3, 82), str3);
            }
            String A002 = A00(19, 19, 64);
            if (i2 == A03) {
                A002 = A00(38, 23, 64);
            } else if (i2 == A01) {
                A002 = A00(0, 19, 7);
            }
            C06818n c06818n = new C06818n(A002);
            c06818n.A05(jSONObject);
            c06818n.A03(1);
            c8j.A06().A8r(A00(154, 5, 17), i2, c06818n);
        } catch (Throwable th) {
            c8j.A06().A3P(th);
        }
    }

    public static boolean A06(C8J c8j) {
        int A062;
        if (c8j.A03().A8H()) {
            A062 = 1;
        } else {
            A062 = JF.A06(c8j);
        }
        if (A062 == 0) {
            return false;
        }
        return A062 <= 0 || c8j.A07().A00() <= 1.0d / ((double) A062);
    }
}
