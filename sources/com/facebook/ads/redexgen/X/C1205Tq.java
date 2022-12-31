package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Tq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1205Tq implements C7B {
    public static byte[] A03;
    public static String[] A04 = {"8KjqebZv60QJkTDxRMgw9", "thfRn5pDzJN70UFYfVIlaB6cN7Gudk2R", "C9BVpw9UV8RgNssPir2gScGxH", "7AiIJI7TwWfHsESFux14U5S4ACJbRhuU", "Q7zUSmRtSU1V7fItr4R7SI8x29M95mvp", "Azfz", "38Oiuq4LYjnMY2HJpsmmy", "sSYHnhmgAc6ueqp"};
    public final /* synthetic */ C1543cy A00;
    public final /* synthetic */ C1198Tj A01;
    public final /* synthetic */ boolean A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 96);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-41, -14, -6, -3, -10, -11, -79, 5, 0, -79, -11, 0, 8, -1, -3, 0, -14, -11, -79, -14, -79, -2, -10, -11, -6, -14, -65};
    }

    static {
        A01();
    }

    public C1205Tq(C1198Tj c1198Tj, C1543cy c1543cy, boolean z) {
        this.A01 = c1198Tj;
        this.A00 = c1543cy;
        this.A02 = z;
    }

    @Override // com.facebook.ads.redexgen.X.C7B
    public final void AA5() {
        XT xt;
        long j2;
        InterfaceC1197Ti interfaceC1197Ti;
        InterfaceC1197Ti interfaceC1197Ti2;
        if (this.A01.A0a != null) {
            this.A01.A0a.A0X();
            this.A01.A0a = null;
        }
        AdErrorType adErrorType = AdErrorType.CACHE_FAILURE_ERROR;
        String A00 = A00(0, 27, 49);
        xt = this.A01.A0D;
        C0R A0D = xt.A0D();
        j2 = this.A01.A00;
        A0D.A2a(C1008Ly.A01(j2), adErrorType.getErrorCode(), A00);
        interfaceC1197Ti = this.A01.A0H;
        if (interfaceC1197Ti != null) {
            interfaceC1197Ti2 = this.A01.A0H;
            interfaceC1197Ti2.AAW(K3.A01(adErrorType, A00));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
        if (r1.equals(com.facebook.ads.redexgen.X.EnumC0947Jl.A04) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
        r0 = r4.A01.A0p();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0075, code lost:
        if (r0 != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0077, code lost:
        r0 = r4.A01.A0H;
        r0.ABE();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
        if (r4.A02 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0084, code lost:
        r0 = r4.A01.A0H;
        r0.A9k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a4, code lost:
        if (r1.equals(com.facebook.ads.redexgen.X.EnumC0947Jl.A04) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    @Override // com.facebook.ads.redexgen.X.C7B
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AAC() {
        /*
            r4 = this;
            com.facebook.ads.redexgen.X.Tj r1 = r4.A01
            com.facebook.ads.redexgen.X.cy r0 = r4.A00
            r1.A0a = r0
            boolean r0 = r4.A02
            if (r0 == 0) goto L39
            com.facebook.ads.redexgen.X.F6 r0 = com.facebook.ads.redexgen.X.C1198Tj.A0F(r1)
            if (r0 == 0) goto L39
            com.facebook.ads.redexgen.X.Tj r0 = r4.A01
            com.facebook.ads.redexgen.X.F6 r3 = com.facebook.ads.redexgen.X.C1198Tj.A0F(r0)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1205Tq.A04
            r0 = 4
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 21
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto La7
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1205Tq.A04
            java.lang.String r1 = "VPn7Tjnl2g2ZoGzxCsTNTuvzL6QbPFmz"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "YMqnQw7eyVGctn758ocTTHmAed4stf5y"
            r0 = 1
            r2[r0] = r1
            r3.A0F()
        L39:
            com.facebook.ads.redexgen.X.Tj r0 = r4.A01
            com.facebook.ads.redexgen.X.Ti r0 = com.facebook.ads.redexgen.X.C1198Tj.A0L(r0)
            if (r0 == 0) goto L8d
            com.facebook.ads.redexgen.X.Tj r3 = r4.A01
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1205Tq.A04
            r0 = 4
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 21
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L8e
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1205Tq.A04
            java.lang.String r1 = "6qlMxmRDBvH4L6kOfkSoYm3n5"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "yt5qGGbrsd8TRcD"
            r0 = 7
            r2[r0] = r1
            com.facebook.ads.redexgen.X.Jl r1 = com.facebook.ads.redexgen.X.C1198Tj.A0H(r3)
            com.facebook.ads.redexgen.X.Jl r0 = com.facebook.ads.redexgen.X.EnumC0947Jl.A04
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L80
        L6f:
            com.facebook.ads.redexgen.X.Tj r0 = r4.A01
            boolean r0 = com.facebook.ads.redexgen.X.C1198Tj.A0v(r0)
            if (r0 != 0) goto L80
            com.facebook.ads.redexgen.X.Tj r0 = r4.A01
            com.facebook.ads.redexgen.X.Ti r0 = com.facebook.ads.redexgen.X.C1198Tj.A0L(r0)
            r0.ABE()
        L80:
            boolean r0 = r4.A02
            if (r0 == 0) goto L8d
            com.facebook.ads.redexgen.X.Tj r0 = r4.A01
            com.facebook.ads.redexgen.X.Ti r0 = com.facebook.ads.redexgen.X.C1198Tj.A0L(r0)
            r0.A9k()
        L8d:
            return
        L8e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1205Tq.A04
            java.lang.String r1 = "NqrZxTPTxSSE484geuNhnuVXrlMqLfJJ"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "nXt660y1rE1HMRNPODglVba6eKGAZLBD"
            r0 = 1
            r2[r0] = r1
            com.facebook.ads.redexgen.X.Jl r1 = com.facebook.ads.redexgen.X.C1198Tj.A0H(r3)
            com.facebook.ads.redexgen.X.Jl r0 = com.facebook.ads.redexgen.X.EnumC0947Jl.A04
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L80
            goto L6f
        La7:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1205Tq.AAC():void");
    }
}
