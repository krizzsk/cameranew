package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
/* renamed from: com.facebook.ads.redexgen.X.cb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1520cb implements C7B {
    public static String[] A03 = {"SGxBKOT0PnlxeQ2jGccieZy3bFeI", "1PQaT", "uVEahNbfwTxCxKVGO7p", "rVPhbhRBlKfAg8fviAhE", "2ov", "KrP87Bn8e271VzBAE5Wi", "4No2VIB7eIWgh7ub8hExBeYUcY", "mEjh"};
    public final /* synthetic */ C04981b A00;
    public final /* synthetic */ XT A01;
    public final /* synthetic */ boolean A02;

    public C1520cb(C04981b c04981b, XT xt, boolean z) {
        this.A00 = c04981b;
        this.A01 = xt;
        this.A02 = z;
    }

    private void A00(boolean z) {
        InterfaceC04971a interfaceC04971a;
        InterfaceC04971a interfaceC04971a2;
        C1528cj c1528cj;
        if (!z) {
            interfaceC04971a = this.A00.A04;
            String[] strArr = A03;
            if (strArr[7].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "3TR1ccuSepVqqTAhPt5x";
            strArr2[3] = "2nf30Z9fIqCCPDXuu277";
            interfaceC04971a.A9i(AdError.CACHE_ERROR);
            return;
        }
        if (JD.A17(this.A01)) {
            boolean z2 = this.A02;
            String[] strArr3 = A03;
            if (strArr3[7].length() == strArr3[0].length()) {
                throw new RuntimeException();
            }
            A03[4] = "td5rO8fwqS2g7pt7eIgv7CCFkrrD";
            if (z2) {
                C04981b c04981b = this.A00;
                XT xt = this.A01;
                c1528cj = c04981b.A03;
                c04981b.A02 = C1073Oo.A01(xt, c1528cj, 1, new C1521cc(this));
                return;
            }
        }
        interfaceC04971a2 = this.A00.A04;
        interfaceC04971a2.A9j();
    }

    @Override // com.facebook.ads.redexgen.X.C7B
    public final void AA5() {
        A00(false);
    }

    @Override // com.facebook.ads.redexgen.X.C7B
    public final void AAC() {
        A00(true);
    }
}
