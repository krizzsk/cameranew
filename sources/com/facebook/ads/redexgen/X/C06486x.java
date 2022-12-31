package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.6x  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06486x {
    public static byte[] A01;
    public static String[] A02 = {"dNawujz5uV7FYgEDis7mqHiOYshviVT", "9zMPJcjBq2CUVbnUK8h7IqP7lj2y2mDE", "v9kwRPsjL9e79G", "Q5ai3781mryKatmpPHMLZ9OBEo", "39szp", "Eqic037VHIj9mkDB9Ac6oywo8OkpAY9", "EWNNEyX3tdVvHEmrYmgOIteMXnkg7nZP", "FOdMhgM8irk7XO"};
    public static final String A03;
    public final String A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = copyOfRange[i5] ^ i4;
            String[] strArr = A02;
            if (strArr[5].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "0af503L5MOYuQEPRhxTnmunHvI";
            strArr2[4] = "8ZzF9";
            copyOfRange[i5] = (byte) (i6 ^ 68);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{62, 9, 9, 20, 9, 91, 56, 9, 30, 26, 15, 18, 21, 28, 91, 49, 40, 52, 53, 50, 63};
    }

    static {
        A01();
        A03 = C06486x.class.getSimpleName();
    }

    public C06486x(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public final JSONObject A03() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(19, 2, 21), this.A00);
        } catch (JSONException e2) {
            Log.e(A03, A00(0, 19, 63), e2);
        }
        return jSONObject;
    }
}
