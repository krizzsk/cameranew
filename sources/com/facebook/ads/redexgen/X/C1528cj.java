package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.cj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1528cj extends AnonymousClass16 implements Serializable {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 5751287062553772011L;

    static {
        A04();
    }

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 98);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{72, 79, 85, 68, 83, 82, 85, 72, 85, 72, 64, 77};
    }

    public C1528cj(List<AnonymousClass19> list) {
        super(list);
    }

    public static C1528cj A02(JSONObject jSONObject, XT xt) {
        C1528cj c1528cj = new C1528cj(AnonymousClass16.A01(jSONObject, xt, new C1529ck()));
        c1528cj.A0f(jSONObject);
        c1528cj.A0d(A03(0, 12, 67));
        return c1528cj;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass16
    public final int A0G() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass16
    public final int A0H() {
        return 0;
    }
}
