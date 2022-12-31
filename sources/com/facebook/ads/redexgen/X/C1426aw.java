package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.aw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1426aw extends AbstractRunnableC0981Kv {
    public static byte[] A01;
    public final /* synthetic */ C5V A00;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 18);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{62, 44, 44, 58, 43, 44};
    }

    public C1426aw(C5V c5v) {
        this.A00 = c5v;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0017 */
    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A06() {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.5V r0 = r5.A00     // Catch: org.json.JSONException -> L4b
            org.json.JSONObject r3 = com.facebook.ads.redexgen.X.C5V.A06(r0)     // Catch: org.json.JSONException -> L4b
            r2 = 0
            r1 = 6
            r0 = 77
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: org.json.JSONException -> L4b
            org.json.JSONArray r4 = r3.getJSONArray(r0)     // Catch: org.json.JSONException -> L4b
            r3 = 0
        L13:
            int r0 = r4.length()     // Catch: org.json.JSONException -> L4b
            if (r3 >= r0) goto L2b
            org.json.JSONObject r0 = r4.getJSONObject(r3)     // Catch: org.json.JSONException -> L4b
            com.facebook.ads.redexgen.X.5T r2 = com.facebook.ads.redexgen.X.C5T.A00(r0)     // Catch: org.json.JSONException -> L4b
            com.facebook.ads.redexgen.X.5V r1 = r5.A00     // Catch: org.json.JSONException -> L4b
            boolean r0 = r2.A04     // Catch: org.json.JSONException -> L4b
            com.facebook.ads.redexgen.X.C5V.A08(r1, r0, r2)     // Catch: org.json.JSONException -> L4b
            int r3 = r3 + 1
            goto L13
        L2b:
            com.facebook.ads.redexgen.X.5V r0 = r5.A00     // Catch: org.json.JSONException -> L4b
            com.facebook.ads.redexgen.X.7J r4 = com.facebook.ads.redexgen.X.C5V.A02(r0)     // Catch: org.json.JSONException -> L4b
            com.facebook.ads.redexgen.X.ay r3 = new com.facebook.ads.redexgen.X.ay     // Catch: org.json.JSONException -> L4b
            r3.<init>(r5)     // Catch: org.json.JSONException -> L4b
            com.facebook.ads.redexgen.X.5V r0 = r5.A00     // Catch: org.json.JSONException -> L4b
            java.lang.String r2 = com.facebook.ads.redexgen.X.C5V.A04(r0)     // Catch: org.json.JSONException -> L4b
            com.facebook.ads.redexgen.X.5V r0 = r5.A00     // Catch: org.json.JSONException -> L4b
            java.lang.String r1 = com.facebook.ads.redexgen.X.C5V.A05(r0)     // Catch: org.json.JSONException -> L4b
            com.facebook.ads.redexgen.X.7C r0 = new com.facebook.ads.redexgen.X.7C     // Catch: org.json.JSONException -> L4b
            r0.<init>(r2, r1)     // Catch: org.json.JSONException -> L4b
            r4.A0U(r3, r0)     // Catch: org.json.JSONException -> L4b
            goto L59
        L4b:
            com.facebook.ads.redexgen.X.5V r0 = r5.A00
            android.os.Handler r1 = com.facebook.ads.redexgen.X.C5V.A00(r0)
            com.facebook.ads.redexgen.X.ax r0 = new com.facebook.ads.redexgen.X.ax
            r0.<init>(r5)
            r1.post(r0)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1426aw.A06():void");
    }
}
