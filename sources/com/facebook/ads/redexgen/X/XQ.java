package com.facebook.ads.redexgen.X;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.UUID;
/* loaded from: assets/audience_network.dex */
public final class XQ extends C8W {
    public static byte[] A00;
    public static final C8Q A01;
    public static final C8Q A02;
    public static final C8Q[] A03;
    public static final String A04;
    public static final String A05;
    public static final String A06;
    public static final String A07;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 36);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{19, 14, 19, 91, 63, 44, 45, 36, 45, 60, 45, 72, 46, 58, 39, 37, 72, 28, 7, 3, Draft_75.CR, 6, 27, 72, 63, 32, 45, 58, 45, 72, 38, 39, 60, 72, 45, 48, 33, 59, 60, 59, 72, 64, 59, 45, 36, 45, 43, 60, 72, 89, 72, 46, 58, 39, 37, 72, Draft_75.CR, 30, Draft_75.CR, 6, 28, 27, 72, 63, 32, 45, 58, 45, 72, 28, 7, 3, Draft_75.CR, 6, 27, 70, 8, 53, 46, 40, 61, 57, 36, 34, 35, 109, 58, 37, 40, 35, 109, 57, 63, 52, 36, 35, 42, 109, 57, 34, 109, 41, 40, 33, 40, 57, 40, 109, 46, 37, 36, 33, 41, 33, 40, 62, 62, 109, 57, 34, 38, 40, 35, 62, 99, 22, 49, 41, 62, 51, 54, 59, Byte.MAX_VALUE, 43, 48, 52, 58, 49, 113, 92, 77, 80, 92, 74, 91, 70, 74, 62, 78, 76, 87, 83, 95, 76, 71, 62, 85, 91, 71, 36, 55, 36, 47, 53, 50, 2, 25, 29, 19, 24, 25, 2, 6, 8, 3, 50, 4, 9, 80, 75, 79, 65, 74, 87};
    }

    static {
        A04();
        A02 = new C8Q(0, A00(170, 8, 73), A00(143, 16, 58));
        A01 = new C8Q(1, A00(165, 5, 82), A00(139, 4, 44));
        A03 = new C8Q[]{A02, A01};
        A07 = XQ.class.getSimpleName();
        C8Q[] c8qArr = A03;
        String A002 = A00(178, 6, 0);
        A05 = C8W.A02(A002, c8qArr);
        A06 = C8W.A03(A002, A03, A01);
        A04 = A00(5, 71, 76) + A02.A01 + A00(0, 3, 23) + A00(159, 6, 101) + A00(4, 1, 53) + XR.A09.A01 + A00(3, 1, 86);
    }

    public XQ(C8S c8s) {
        super(c8s);
    }

    @Override // com.facebook.ads.redexgen.X.C8W
    public final String A06() {
        return A00(178, 6, 0);
    }

    @Override // com.facebook.ads.redexgen.X.C8W
    public final C8Q[] A0A() {
        return A03;
    }

    public final Cursor A0B() {
        return A05().rawQuery(A05, null);
    }

    public final String A0C(String str) throws IllegalArgumentException, SQLiteException {
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = A05().rawQuery(A06, new String[]{str});
                String string = cursor.moveToNext() ? cursor.getString(A02.A00) : null;
                if (!TextUtils.isEmpty(string)) {
                    cursor.close();
                    return string;
                }
                String uuid = UUID.randomUUID().toString();
                ContentValues contentValues = new ContentValues(2);
                String existingTokenId = A02.A01;
                contentValues.put(existingTokenId, uuid);
                String existingTokenId2 = A01.A01;
                contentValues.put(existingTokenId2, str);
                SQLiteDatabase A052 = A05();
                String existingTokenId3 = A00(178, 6, 0);
                A052.insertOrThrow(existingTokenId3, null, contentValues);
                cursor.close();
                return uuid;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        throw new IllegalArgumentException(A00(125, 14, 123));
    }

    public final void A0D() {
        try {
            A05().execSQL(A04);
        } catch (SQLException e2) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A07, A00(76, 49, 105), e2);
            }
        }
    }
}
