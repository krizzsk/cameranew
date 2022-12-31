package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.tencent.matrix.trace.constants.Constants;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class X9 implements C0S {
    public static byte[] A01;
    public static String[] A02 = {"EcOoOPxvgIM5VM8gU5MNIX90mja3CaI7", "nhJ", "HCYDUCxXnFbS3htlRPDiG7BoiyzyMxIV", "Fv3YAwH75PiBj9X6AN971g", "yIx", "", "9xkhFmOksAfwag3lVFNPfz", "xjMRz"};
    public final C8J A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 90);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        String[] strArr = A02;
        if (strArr[1].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[0] = "mKsg4hxQhHaV0fiKABuoeRg1A6SJU8YP";
        strArr2[2] = "TgUrCFxQKf96ICwhyLjRHk1rYV6JKdAm";
        A01 = new byte[]{-91, -111, -94, -120, -18, 29, 22, 22, Draft_75.CR, 20, -12, 35, 28, 28, 19, 26, -24, -50, -3, 12, 34, -16, 33, 16, 25, 31, 10, -37, -22, -29, -29, -38, -31, 57, 72, 65, 65, 56, 63, 50, 63, 66, 58, 58, 56, 55};
    }

    static {
        A01();
    }

    public X9(C8J c8j) {
        this.A00 = c8j;
    }

    private void A02(int i2, String str, JSONObject jSONObject, boolean z) {
        C06818n c06818n = new C06818n(A00(4, 6, 78));
        c06818n.A05(jSONObject);
        c06818n.A03(1);
        c06818n.A07(z);
        try {
            jSONObject.put(A00(33, 13, 121), C8g.A0H(this.A00));
        } catch (JSONException unused) {
        }
        this.A00.A06().A8r(A00(27, 6, 27), i2 + Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM, c06818n);
        if (this.A00.A03().A8H()) {
            String str2 = A00(10, 8, 84) + str + A00(0, 1, 35) + i2 + A00(1, 3, 14) + jSONObject.toString();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0S
    public final void A8s(C0T c0t, JSONObject jSONObject) {
        A02(c0t.A02(), c0t.toString(), jSONObject, Arrays.binarySearch(X0.A09, c0t) != -1);
    }

    @Override // com.facebook.ads.redexgen.X.C0S
    public final void A94(int i2, JSONObject jSONObject) {
        A02(i2, A00(18, 9, 81) + i2, jSONObject, false);
    }
}
