package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Zx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1365Zx implements InterfaceC06426r<Integer> {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final int A02;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 10);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{114, 100, 91, 87, 77, 73};
    }

    public C1365Zx(int i2, int i3, int i4) {
        this.A02 = i2;
        this.A00 = i3;
        this.A01 = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    /* renamed from: A01 */
    public final JSONObject AEz(Integer num, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A00(4, 2, 42), this.A02);
        jSONObject2.put(A00(0, 2, 27), this.A00);
        jSONObject2.put(A00(2, 2, 60), this.A01);
        jSONObject.put(num.toString(), jSONObject2);
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    public final boolean A8K(Object obj) {
        C1365Zx c1365Zx = (C1365Zx) obj;
        return this.A01 == c1365Zx.A01 && this.A00 == c1365Zx.A00 && this.A02 == c1365Zx.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    public final int AEd() {
        return A00(4, 2, 42).getBytes().length + A00(0, 2, 27).getBytes().length + A00(2, 2, 60).getBytes().length + 12;
    }
}
