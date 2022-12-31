package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.d5  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1550d5 extends AbstractRunnableC0981Kv {
    public static byte[] A01;
    public final /* synthetic */ JSONObject A00;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 21);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{7, 19, 4, 16, 20, 4, 15, 2, 24, 62, 2, 0, 17, 17, 8, 15, 6};
    }

    public C1550d5(JSONObject jSONObject) {
        this.A00 = jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        try {
            C04910u.A03.await();
            synchronized (C04910u.A00) {
                C04910u.A00.A09(this.A00);
                C04910u.A04.countDown();
            }
        } catch (InterruptedException e2) {
            C04910u.A01.A06().A8q(A00(0, 17, 116), C06808m.A10, new C06818n(e2));
        } catch (JSONException e3) {
            C04910u.A07();
            C04910u.A01.A06().A8q(A00(0, 17, 116), C06808m.A0z, new C06818n(e3));
        }
    }
}
