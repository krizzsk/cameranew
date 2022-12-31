package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5j  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06095j {
    public static byte[] A00;
    public static String[] A01 = {"BBXCQ1c8lWMx5iTCFSjBAsNmZ8", "uWpSMDe8Dl1QwAjraNXmi3HjN39WCwvV", "Nl77HN8SOPKSqciG8lmOC8DFY50qabgT", "qKAuPB5zte0w", "tHnAlNrx5zeOSNOAYBdYTMmeA", "muO01a58leOoeMmtxXp9cvgd3", "skgH0VF5dzwRL9wPv5", "Mbe4svBdXamA1BIwkYK5rcxDOVieSFVl"};

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[2].charAt(14) != 'i') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "5u7aTW8yax3G";
            strArr[6] = "UvSwr6xgQWJsIweShl";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 109);
            i5++;
        }
    }

    public static void A02() {
        A00 = new byte[]{118, 126, 115, 115, 124, 118, 96, 125, 123, 118, 123, 118, 40, 36, 37, 63, 46, 37, 63, 113, 100, 100, 40, 36, 38, 101, 45, 42, 40, 46, 41, 36, 36, 32, 101, 32, 42, 63, 42, 37, 42, 101, 59, 57, 36, 61, 34, 47, 46, 57, 101, 10, 63, 63, 57, 34, 41, 62, 63, 34, 36, 37, 2, 47, 27, 57, 36, 61, 34, 47, 46, 57, 37, 32, 36, 32, 61, 22, 61, 59, 40, 42, 34, 32, 39, 46};
    }

    static {
        A02();
    }

    public static C06085i A00(ContentResolver contentResolver) {
        String A012 = A01(72, 14, 36);
        String A013 = A01(3, 9, 127);
        String A014 = A01(0, 3, 122);
        Cursor cursor = null;
        try {
            Cursor query = contentResolver.query(Uri.parse(A01(12, 60, 38)), new String[]{A014, A013, A012}, null, null, null);
            if (query == null || !query.moveToFirst()) {
                C06085i c06085i = new C06085i(null, null, false);
                if (query != null) {
                    query.close();
                }
                return c06085i;
            }
            String string = query.getString(query.getColumnIndex(A014));
            String advertisingId = query.getString(query.getColumnIndex(A013));
            C06085i c06085i2 = new C06085i(string, advertisingId, Boolean.valueOf(query.getString(query.getColumnIndex(A012))).booleanValue());
            query.close();
            return c06085i2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }
}
