package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public class SE implements InterfaceC1065Og {
    public static byte[] A01;
    public final /* synthetic */ C06999f A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 23);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-49, -53, -64, -40};
    }

    public SE(C06999f c06999f) {
        this.A00 = c06999f;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1065Og
    public final void ACS(String str, JSONObject jSONObject) {
        C1072On c1072On;
        XT xt;
        XT xt2;
        if (str.equals(A00(0, 4, 72))) {
            this.A00.AEq();
            xt = this.A00.A07;
            if (JD.A1D(xt)) {
                xt2 = this.A00.A07;
                xt2.A09().AAH();
            }
        }
        c1072On = this.A00.A0F;
        c1072On.A0c(str, jSONObject);
    }
}
