package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Tr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1206Tr extends AbstractC04850o {
    public static byte[] A01;
    public final /* synthetic */ C1198Tj A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 109);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{23, 42, 61, 50, 63, 46, -23, 42, 45, 60, -23, 54, 42, 55, 42, 48, 46, 59, -23, 61, 49, 46, 50, 59, -23, 56, 64, 55, -23, 50, 54, 57, 59, 46, 60, 60, 50, 56, 55, 60, -9};
    }

    public C1206Tr(C1198Tj c1198Tj) {
        this.A00 = c1198Tj;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0B(C1543cy c1543cy) {
        InterfaceC1197Ti interfaceC1197Ti;
        this.A00.A0e(c1543cy, true);
        interfaceC1197Ti = this.A00.A0H;
        if (interfaceC1197Ti != null && c1543cy.A0W() != null) {
            C1207Ts c1207Ts = new C1207Ts(this);
            for (C1198Tj c1198Tj : c1543cy.A0W()) {
                c1198Tj.A0f(c1207Ts);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0C() {
        InterfaceC1197Ti interfaceC1197Ti;
        InterfaceC1197Ti interfaceC1197Ti2;
        interfaceC1197Ti = this.A00.A0H;
        if (interfaceC1197Ti != null) {
            interfaceC1197Ti2 = this.A00.A0H;
            interfaceC1197Ti2.A9h();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0D() {
        throw new IllegalStateException(A00(0, 41, 92));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0F(InterfaceC04840n interfaceC04840n) {
        F6 f6;
        F6 f62;
        f6 = this.A00.A0A;
        if (f6 != null) {
            f62 = this.A00.A0A;
            f62.A0G();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0G(K3 k3) {
        long j2;
        InterfaceC1197Ti interfaceC1197Ti;
        InterfaceC1197Ti interfaceC1197Ti2;
        C0R A0D = this.A00.A10().A0D();
        j2 = this.A00.A00;
        A0D.A2a(C1008Ly.A01(j2), k3.A03().getErrorCode(), k3.A04());
        interfaceC1197Ti = this.A00.A0H;
        if (interfaceC1197Ti != null) {
            interfaceC1197Ti2 = this.A00.A0H;
            interfaceC1197Ti2.AAW(k3);
        }
    }
}
