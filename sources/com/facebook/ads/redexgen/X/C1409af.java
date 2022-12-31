package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.af  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1409af implements C6B {
    public static byte[] A01;
    public static final String A02;
    public final XS A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 48);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{73, 116, 111, 105, 124, 120, 101, 99, 98, 44, 110, 121, 101, 96, 104, 101, 98, 107, 44, 74, 77, 66, 44, 96, 99, 107, 107, 101, 98, 107, 44, 70, 95, 67, 66, 69, 87, 77, 64, 71, 65, 122, 65, 68, 81, 68, 122, 73, 74, 66, 66, 76, 75, 66, 72, 67, 78, 121, 110, 65, 71, 32, 54, 39, 9, 16, 30};
    }

    static {
        A01();
        A02 = C1409af.class.getSimpleName();
    }

    public C1409af(XS xs) {
        this.A00 = xs;
    }

    @Override // com.facebook.ads.redexgen.X.C6B
    public final void A9A(String str, String str2, int i2, int i3, int i4, JSONObject jSONObject, EnumC06406p enumC06406p) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(A00(35, 4, 20), str);
            jSONObject2.put(A00(54, 3, 26), str2);
            jSONObject2.put(A00(57, 2, 42), i2);
            jSONObject2.put(A00(59, 2, 3), i3);
            jSONObject2.put(A00(61, 3, 99), i4);
            jSONObject2.put(A00(64, 3, 74), AnonymousClass76.A01(jSONObject.toString(), str2));
            C06818n c06818n = new C06818n(jSONObject2.toString());
            c06818n.A03(1);
            this.A00.A06().A8r(A00(39, 15, 21), 3201, c06818n);
        } catch (JSONException e2) {
            Log.e(A02, A00(0, 35, 60), e2);
        }
    }
}
