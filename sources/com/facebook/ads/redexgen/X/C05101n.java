package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.1n  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05101n {
    public static byte[] A00;
    public static String[] A01 = {"igRhJ5PMh9Eh8Y2IerdGy5xkOC6P2llR", "V46d15x", "MJKFW0CLK7bAI6aw2ZElw", "zTSnxKwsRm9QX9x71YaST5qvog5tEdJu", "st59mNNBONuIr", "MIQpkXIOac94fCVdDkTkmEIjKw0qiSq3", "kiNh4KBsD0OfWobtTcq7wf9fMfaX9NJ7", "i75b2K08qbcfq0VL3a3toAQCEFjwzJS6"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 7);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-31, -12, -16, -18, -35, -37, -32, -35, -16, -35, -108, -112, -96, -92, -60, -59, -54, -48, -49, -55, -57, -54, -70};
        String[] strArr = A01;
        if (strArr[4].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[7] = "QiBNmKb9uzO3ShmPEHX6g0hmsapRWinL";
        strArr2[6] = "1YGcOKJJ0RaoQrn7jQfS5C5uNlMatHof";
    }

    static {
        A01();
    }

    public static boolean A02(@Nullable String str) {
        String A002 = A00(0, 10, 117);
        if (str == null) {
            return false;
        }
        try {
            JSONObject hintsJsonRoot = new JSONObject(str).getJSONObject(A00(14, 5, 85));
            if (hintsJsonRoot.has(A002)) {
                return new JSONObject(hintsJsonRoot.getString(A002)).optString(A00(10, 4, 39)).equals(A00(19, 4, 78));
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }
}
