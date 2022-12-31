package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.cf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1524cf extends AnonymousClass16 implements Serializable {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 2751287062553772011L;

    static {
        A04();
    }

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 1);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{123, 108, 126, 104, 123, 109, 108, 109, 86, Byte.MAX_VALUE, 96, 109, 108, 102};
    }

    public C1524cf(List<AnonymousClass19> list) {
        super(list);
    }

    public static C1524cf A02(JSONObject jSONObject, XT xt) {
        C1524cf c1524cf = new C1524cf(AnonymousClass16.A01(jSONObject, xt, new C1525cg()));
        c1524cf.A0f(jSONObject);
        c1524cf.A0d(A03(0, 14, 8));
        return c1524cf;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass16
    public final int A0G() {
        if (A0m()) {
            return 2;
        }
        if (A0K().A0D().A06() != null) {
            return 1;
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass16
    public final int A0H() {
        return A0K().A0D().A04();
    }
}
