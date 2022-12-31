package com.facebook.ads.redexgen.X;

import android.database.sqlite.SQLiteDatabase;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.8W  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C8W {
    public static byte[] A01;
    public static String[] A02 = {"HVKZvR5UTjStDLOL9o4rPessbKuh0O7V", "lcBs6IulTDBXs0xMNwr7074HBb5CT680", "pp9", "08Pk9qbigTz1ItVQ0hAeiWjKqsV0Kke0", "IZPR1WSW", "qkmVdqnPN26Te8aFuQlNVKOt05q5LyYY", "adXBxD3OrJvPB32QQ8w", "pvdflY6bA4nr3ZgRZtp7kAtC3Qj6GBkc"};
    public final C8S A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 59);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A01 = new byte[]{121, -127, 123, -104, 123, -102, -86, -48, -36, -39, -41, -86, -44, 11, -4, -7, 6, -7, -44, -108, -118, 126, -126, -111, -124, Byte.MIN_VALUE, -109, -124, 95, -109, Byte.MIN_VALUE, -127, -117, -124, 95, -95, -81, -84, -83, 125, -79, -98, -97, -87, -94, 125, -90, -93, 125, -94, -75, -90, -80, -79, -80, 125, -8, -22, -15, -22, -24, -7, -59};
    }

    public abstract String A06();

    public abstract C8Q[] A0A();

    static {
        A04();
    }

    public C8W(C8S c8s) {
        this.A00 = c8s;
    }

    private String A00() {
        C8Q[] A0A = A0A();
        if (A0A.length < 1) {
            if (A02[4].length() != 8) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[0] = "NTtbWHu0RetWI6yxki67w6X3knWPKgwD";
            strArr[1] = "wg0AU135P1OwlpIQrYrtBV6UQnwqkPhP";
            return null;
        }
        String A012 = A01(0, 0, 31);
        for (int i2 = 0; i2 < A0A.length - 1; i2++) {
            A012 = A012 + A0A[i2].A02() + A01(20, 2, 35);
        }
        return A012 + A0A[A0A.length - 1].A02();
    }

    public static String A02(String str, C8Q[] c8qArr) {
        StringBuilder sb = new StringBuilder(A01(56, 7, 106));
        for (int i2 = 0; i2 < c8qArr.length - 1; i2++) {
            sb.append(c8qArr[i2].A01);
            if (A02[2].length() != 3) {
                throw new RuntimeException();
            }
            A02[4] = "CXWyM2Ol";
            sb.append(A01(20, 2, 35));
        }
        sb.append(c8qArr[c8qArr.length - 1].A01);
        sb.append(A01(6, 6, 79));
        sb.append(str);
        return sb.toString();
    }

    public static String A03(String str, C8Q[] c8qArr, C8Q c8q) {
        return A02(str, c8qArr) + A01(12, 7, 121) + c8q.A01 + A01(2, 4, 32);
    }

    public final SQLiteDatabase A05() {
        return this.A00.A0E();
    }

    public final void A07(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(A01(22, 13, 4) + A06() + A01(0, 2, 30) + A00() + A01(19, 1, 48));
    }

    public final void A08(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(A01(35, 21, 34) + A06());
    }

    public final boolean A09() {
        return A05().delete(A06(), null, null) > 0;
    }
}
