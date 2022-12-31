package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Jd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0939Jd {
    public static byte[] A00;
    public static final Map<String, String> A01;
    public static final Map<String, List<String>> A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 27);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-68, -51, -49, -52, -33, -52, -42, -27, -34, -34, -43, -36, -3, 0, -14, -11, -16, 5, -6, -2, -10, -16, -2, 4, -68, -81, -69, -65, -81, -67, -66, -87, -66, -77, -73, -81, -87, -73, -67, -111, -108, 123, -126, -111, -118, -118, -127, -120, 123, -120, -117, -125, -125, -123, -118, -125};
    }

    static {
        A03();
        A02 = new HashMap();
        A01 = new HashMap();
    }

    @Nullable
    public static String A01(String str) {
        return A01.get(str);
    }

    public static List<String> A02(XT xt, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                arrayList.add(jSONArray.getString(i2));
            } catch (JSONException e2) {
                xt.A06().A8q(A00(39, 17, 1), C06808m.A11, new C06818n(e2));
            }
        }
        return arrayList;
    }

    public static void A04(View view, C0937Jb c0937Jb, EnumC0936Ja enumC0936Ja) {
        view.addOnAttachStateChangeListener(new View$OnAttachStateChangeListenerC0938Jc(c0937Jb, enumC0936Ja));
    }

    public static void A05(XT xt, String str, long j2) {
        C0937Jb c0937Jb = new C0937Jb(str, xt.A08());
        HashMap hashMap = new HashMap();
        hashMap.put(A00(24, 15, 47), C1008Ly.A06(j2));
        hashMap.put(A00(12, 12, 118), C1008Ly.A04(j2));
        c0937Jb.A02(EnumC0936Ja.A0D, hashMap);
    }

    public static void A06(XT xt, JSONObject jSONObject, long j2, @Nullable String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A00(2, 4, 80));
        if (optJSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(A00(6, 6, 85));
        if (TextUtils.isEmpty(str) && optJSONArray != null) {
            A07(xt, optJSONObject, A02(xt, optJSONArray), j2, null);
        } else if (TextUtils.isEmpty(str) || !A02.containsKey(str)) {
        } else {
            A07(xt, optJSONObject, A02.get(str), j2, str);
        }
    }

    public static void A07(XT xt, JSONObject jSONObject, List<String> list, long j2, @Nullable String str) {
        String A002 = A00(0, 2, 62);
        if (jSONObject.has(A002)) {
            String optString = jSONObject.optString(A002);
            A08(optString, str);
            A09(optString, list);
            A05(xt, optString, j2);
        }
    }

    public static void A08(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        A01.put(str, str2);
    }

    public static void A09(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list.isEmpty()) {
            return;
        }
        A02.put(str, list);
    }

    public static boolean A0A(String str, EnumC0936Ja enumC0936Ja) {
        return A0B(str, enumC0936Ja.A02());
    }

    public static boolean A0B(String str, String str2) {
        return A02.containsKey(str) && A02.get(str).contains(str2);
    }
}
