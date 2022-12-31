package com.facebook.ads.redexgen.X;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class XR extends C8W {
    public static byte[] A00;
    public static String[] A01 = {"jrDlnlrK", "iy84zN2ZyMyHjuWhjHotEPEqpiKyPe89", "dhX4OOJDnXlCZP9pL8vYTq2cDSC1Ep0f", "V5wGJKV", "mjidYuf4", "f2fONlBHJxOBrlG7qLTpq6ivaaiBfV2e", "tNB7OhzIAdgb5rZvvS5ZVqcHEeMF5GsI", "2zYeFugNugInNaPrLN78SJaAZY8hyaCl"};
    public static final C8Q A02;
    public static final C8Q A03;
    public static final C8Q A04;
    public static final C8Q A05;
    public static final C8Q A06;
    public static final C8Q A07;
    public static final C8Q A08;
    public static final C8Q A09;
    public static final C8Q A0A;
    public static final C8Q[] A0B;
    public static final String A0C;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 42);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-102, -73, -102, -71, -92, -87, -81, -96, -94, -96, -83, -22, -35, -39, -28, -93, -107, -100, -107, -109, -92, 112, 122, 112, -106, -94, -97, -99, 112, -75, -58, -75, -66, -60, -61, 112, -89, -104, -107, -94, -107, 112, -11, -25, -18, -25, -27, -10, -62, 5, 17, 23, 16, 22, -54, -52, -53, -62, -24, -12, -15, -17, -62, 7, 24, 7, 16, 22, 21, -49, -64, -45, -49, -95, -110, -91, -95, 109, -99, -97, -106, -102, -114, -97, -90, 109, -104, -110, -90, -19, -34, -15, -19, -71, -21, -34, -33, -34, -21, -34, -25, -36, -34, -20, -71, Draft_75.CR, 8, 4, -2, 7, 12, -71, -24, -25, -71, -18, -23, -35, -38, -19, -34, -71, -36, -38, -20, -36, -38, -35, -34, -71, -24, -25, -71, -35, -34, -27, -34, -19, -34, -71, -21, -34, -20, -19, -21, -30, -36, -19, -17, 2, 2, -13, -5, -2, 2, -85, -88, -69, -88, -82, -65, -82, -73, -67, -88, -78, -83, -4, Draft_75.CR, -4, 5, 11, 10, -77, -75, -84, -78, -75, -84, -73, -68, -80, -94, -80, -80, -90, -84, -85, -100, -90, -95, -90, -104, -90, -90, -100, -94, -95, -110, -89, -100, -96, -104, -43, -54, -50, -58, -96, -101, -105, -111, -102, -117, -107, -112, -32, -27, -36, -47};
    }

    static {
        A04();
        A04 = new C8Q(0, A00(159, 8, 31), A00(73, 16, 35));
        A09 = new C8Q(1, A00(207, 8, 2), A00(89, 59, 111));
        String A002 = A00(4, 7, 49);
        A05 = new C8Q(2, A00(173, 8, 25), A002);
        String A003 = A00(69, 4, 81);
        A0A = new C8Q(3, A00(215, 4, 66), A003);
        String A004 = A00(11, 4, 110);
        A08 = new C8Q(4, A00(203, 4, 55), A004);
        A07 = new C8Q(5, A00(191, 12, 9), A004);
        A06 = new C8Q(6, A00(181, 10, 19), A003);
        A03 = new C8Q(7, A00(155, 4, 29), A003);
        A02 = new C8Q(8, A00(148, 7, 100), A002);
        A0B = new C8Q[]{A04, A09, A05, A0A, A08, A07, A06, A03, A02};
        A0C = C8W.A02(A00(167, 6, 109), A0B);
    }

    public XR(C8S c8s) {
        super(c8s);
    }

    @Override // com.facebook.ads.redexgen.X.C8W
    public final String A06() {
        return A00(167, 6, 109);
    }

    @Override // com.facebook.ads.redexgen.X.C8W
    public final C8Q[] A0A() {
        return A0B;
    }

    public final Cursor A0B() {
        return A05().rawQuery(A00(42, 27, 120), null);
    }

    public final Cursor A0C() {
        return A05().rawQuery(A0C, null);
    }

    public final Cursor A0D(String str) {
        SQLiteDatabase A052 = A05();
        return A052.rawQuery(A00(15, 27, 38) + A04.A01 + A00(0, 4, 80), new String[]{str});
    }

    public final String A0E(String str, int i2, String str2, double d2, double d3, String str3, Map<String, String> map) throws SQLiteException {
        String uuid = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues(9);
        contentValues.put(A04.A01, uuid);
        contentValues.put(A09.A01, str);
        contentValues.put(A05.A01, Integer.valueOf(i2));
        contentValues.put(A0A.A01, str2);
        contentValues.put(A08.A01, Double.valueOf(d2));
        contentValues.put(A07.A01, Double.valueOf(d3));
        contentValues.put(A06.A01, str3);
        contentValues.put(A03.A01, map != null ? new JSONObject(map).toString() : null);
        if (A01[2].charAt(6) != '9') {
            String[] strArr = A01;
            strArr[6] = "s3YvQaCKhotLBtEqHITMzm2bHxiojI5j";
            strArr[5] = "6LuOsEhvTekWWK5Zi4EuC4VUkJbxKkeL";
            contentValues.put(A02.A01, (Integer) 0);
            A05().insertOrThrow(A00(167, 6, 109), null, contentValues);
            return uuid;
        }
        throw new RuntimeException();
    }

    public final boolean A0F(String str) {
        SQLiteDatabase A052 = A05();
        StringBuilder sb = new StringBuilder();
        sb.append(A04.A01);
        sb.append(A00(0, 4, 80));
        return A052.delete(A00(167, 6, 109), sb.toString(), new String[]{str}) > 0;
    }
}
