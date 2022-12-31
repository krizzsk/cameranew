package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Le  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0988Le {
    public static byte[] A00;
    public static String[] A01 = {"bCA0WV7g9cnA4ltB5qqjp12FxZMghyDz", "WzMdgVuSy86surt8IbRNO89xVpYcFvZR", "vBmFH1fuq9MEDYSajFcKFjMjxlndPyIT", "AjQwhKg0BmylW2zY2qnRPlrsdpwDD7xX", "WDfLMW4THrL4GDR7l8Ogbnx7jWIf1LVp", "J", "Un7ie3hNu6oSxsviCElGpaw70qJ7D3pr", "I6rRJYdApv2XGptUPw1U"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 85);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{-10, -3, -12, -12};
    }

    static {
        A05();
    }

    public static String A01(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e2) {
                    String[] strArr = A01;
                    if (strArr[0].charAt(5) != strArr[1].charAt(5)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A01;
                    strArr2[2] = "ndgFEZBTUbwthgxyC0k1ffQbXbGUnRaA";
                    strArr2[3] = "ZnYv6Dz0eIiuCYzsHLE25vrPVm9Ysg64";
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject.toString();
    }

    public static String A02(JSONObject jSONObject, String str) {
        return A03(jSONObject, str, null);
    }

    public static String A03(JSONObject jSONObject, String str, String str2) {
        String optString = jSONObject.optString(str, str2);
        if (A00(0, 4, 51).equals(optString)) {
            return null;
        }
        return optString;
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0012 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<java.lang.String> A04(org.json.JSONArray r4) {
        /*
            if (r4 != 0) goto L8
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        L8:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2 = 0
        Le:
            int r0 = r4.length()
            if (r2 >= r0) goto L24
            java.lang.String r1 = r4.optString(r2)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L21
            r3.add(r1)
        L21:
            int r2 = r2 + 1
            goto Le
        L24:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0988Le.A04(org.json.JSONArray):java.util.List");
    }
}
