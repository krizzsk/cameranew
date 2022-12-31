package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.ao  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1418ao implements InterfaceC06025c {
    public static byte[] A02;
    public static String[] A03 = {"TFthAsyh9DXeOXmOSrI", "6fWFj2GuIp8edYChPrJEmZ0EGdAH52zr", "1W8BLXCecsGswLg5J6ItB4TJ0IeP92", "LJOYl73w1qtKK7uJcnV", "z6IkqPokH6efARGWKazebLzdy8d5mCY", "2wZEZTk79zqBVt75gMVieTbdYLiT7Zir", "bDoQVkMDKn3JHFmlXSVDRiBYbpx4sGCA", "L28Z4g4sdLlGf5SKMowSfgQKz11TtxJ4"};
    public final EnumC06035d A00;
    public final String A01;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 124);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{5, 10, 1, -10, 78, 75, 69};
    }

    static {
        A02();
    }

    public C1418ao(EnumC06035d enumC06035d, String str) {
        this.A00 = enumC06035d;
        this.A01 = str;
    }

    @Nullable
    public static C1418ao A00(JSONObject jSONObject) {
        EnumC06035d A00 = EnumC06035d.A00(jSONObject.optString(A01(0, 4, 21)));
        String optString = jSONObject.optString(A01(4, 3, 93));
        if (A00 == null || optString == null) {
            String[] strArr = A03;
            String str = strArr[7];
            String url = strArr[5];
            if (str.charAt(27) != url.charAt(27)) {
                throw new RuntimeException();
            }
            A03[2] = "YX1kth4";
            return null;
        }
        return new C1418ao(A00, optString);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06025c
    public final EnumC06035d A7c() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
        if (r4 != r3) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
        if (r4 != r3) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
        r7 = (com.facebook.ads.redexgen.X.C1418ao) r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
        if (r6.A00 == r7.A00) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
        return r6.A01.equals(r7.A01);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            if (r6 != r7) goto L23
            r3 = 1
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1418ao.A03
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 31
            if (r1 == r0) goto L16
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L16:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1418ao.A03
            java.lang.String r1 = "7vOCIJjJCX9CoY0eg8O"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "3BsZIpiI9Segj8T9GPE"
            r0 = 3
            r2[r0] = r1
            return r3
        L23:
            r5 = 0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1418ao.A03
            r0 = 7
            r1 = r2[r0]
            r0 = 5
            r2 = r2[r0]
            r0 = 27
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L3e
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1418ao.A03
            java.lang.String r1 = "CUYUmjEQroJXgi3huLe"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "AnYHMDp1ebtK81SsggF"
            r0 = 3
            r2[r0] = r1
            if (r7 == 0) goto L6a
            java.lang.Class r4 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1418ao.A03
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 31
            if (r1 == r0) goto L6b
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1418ao.A03
            java.lang.String r1 = "McBoxOwAJvKvGI9HKqBnGpNAZAcduNL"
            r0 = 4
            r2[r0] = r1
            if (r4 == r3) goto L6e
        L6a:
            return r5
        L6b:
            if (r4 == r3) goto L6e
            goto L6a
        L6e:
            com.facebook.ads.redexgen.X.ao r7 = (com.facebook.ads.redexgen.X.C1418ao) r7
            com.facebook.ads.redexgen.X.5d r1 = r6.A00
            com.facebook.ads.redexgen.X.5d r0 = r7.A00
            if (r1 == r0) goto L77
            return r5
        L77:
            java.lang.String r1 = r6.A01
            java.lang.String r0 = r7.A01
            boolean r0 = r1.equals(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1418ao.equals(java.lang.Object):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06025c
    public final String getUrl() {
        return this.A01;
    }

    public final int hashCode() {
        return (this.A00.hashCode() * 31) + this.A01.hashCode();
    }
}
