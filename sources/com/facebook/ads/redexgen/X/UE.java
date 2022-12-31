package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONException;
/* loaded from: assets/audience_network.dex */
public class UE implements R6 {
    public static byte[] A02;
    public final /* synthetic */ XS A00;
    public final /* synthetic */ R4 A01;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 32);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-120, -121, -125, -106, -105, -108, -121, -127, -123, -111, -112, -120, -117, -119};
    }

    public UE(R4 r4, XS xs) {
        this.A01 = r4;
        this.A00 = xs;
    }

    @Override // com.facebook.ads.redexgen.X.R6
    public final void A3s() {
        try {
            JD.A0O(this.A00).A25(this.A01.A6F().optJSONObject(A00(0, 14, 2)));
        } catch (JSONException e2) {
            this.A00.A06().A3P(e2);
        }
    }
}
