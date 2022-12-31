package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.ae  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1408ae implements C6A {
    public static byte[] A01;
    public static String[] A02 = {"6ed60iFbyw4O0VClkceoZwkVaz", "1Noj8Rwr5CA27wajCyehlG0t", "GtZXESfkmlMC3ZdW", "MRULKW7dB4Z64SB2LTgGF3R4d8LEfmJR", "vApEtDGiCitQ7mYMvJS0OBzW", "koj", "8zJvQkXxVA", "coxDWwrM8IWdo7ilusiV4Y3aDk"};
    public static final String A03;
    public final XS A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 49);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {74, 119, 108, 106, Byte.MAX_VALUE, 123, 102, 96, 97, 47, 109, 122, 102, 99, 107, 102, 97, 104, 47, 73, 78, 65, 47, 99, 96, 104, 104, 102, 97, 104, 47, 69, 92, 64, 65, 122, 81, 70, 81, 30, 24, 35, 24, 29, 8, 29, 35, 16, 19, 27, 27, 21, 18, 27, 96, 107, 102, 5, 66, 74, 22, 0, 7, 38, 55, 92, 1, 10, 12};
        String[] strArr = A02;
        if (strArr[1].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[1] = "DL3yCuobuuMgb5zF6sUKmxA9";
        strArr2[4] = "KanNEDagieP8OaiGnypNi6xK";
        A01 = bArr;
    }

    static {
        A01();
        A03 = C1408ae.class.getSimpleName();
    }

    public C1408ae(XS xs) {
        this.A00 = xs;
    }

    @Override // com.facebook.ads.redexgen.X.C6A
    public final void A91(String str, String str2, Map<String, String> map, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(65, 1, 1), str);
            jSONObject.put(A00(66, 1, 95), str2);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put(A00(67, 2, 84), jSONObject2.toString());
            jSONObject.put(A00(54, 3, 51), str3);
            jSONObject.put(A00(58, 2, 22), str4);
            jSONObject.put(A00(60, 3, 66), str5);
            jSONObject.put(A00(63, 2, 114), str6);
            jSONObject.put(A00(57, 1, 87), A00(35, 4, 1));
            C06818n c06818n = new C06818n(jSONObject.toString());
            c06818n.A03(1);
            this.A00.A06().A8r(A00(39, 15, 77), 3202, c06818n);
        } catch (JSONException e2) {
            Log.e(A03, A00(0, 35, 62), e2);
        }
    }
}
