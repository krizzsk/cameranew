package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.bX  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1462bX implements C4G {
    public static String[] A01 = {"IP6gXu3Aic9rrZpr", "DSm6OHbiM4aoMyjFh2wy7Spd3inn5axc", "lJd94ygIcpnkIi9oYNWqXg3HQV8t0X4Q", "337I3pVrWHOBtYrFGcdtPHZp8Kpz9VIJ", "vd5lczoeg9gY82TvyWngHoQKFpNC9gt0", "CefcuhKyPhUbDvzsvxPUhaoMgi2Xy5FO", "Qia1n7qQgpdEP2KZeQvga8Xzcvoo51Ij", "UfDKqgBAky8ekVpIbdpaQQPTuf6RISL4"};
    public final /* synthetic */ C0828Eq A00;

    public C1462bX(C0828Eq c0828Eq) {
        this.A00 = c0828Eq;
    }

    @Override // com.facebook.ads.redexgen.X.C4G
    public final void A9n(AbstractC05784e abstractC05784e) {
        boolean A0A;
        abstractC05784e.A0Z(true);
        if (abstractC05784e.A06 != null && abstractC05784e.A07 == null) {
            abstractC05784e.A06 = null;
        }
        abstractC05784e.A07 = null;
        A0A = abstractC05784e.A0A();
        if (!A0A && !this.A00.A1z(abstractC05784e.A0H) && abstractC05784e.A0e()) {
            C0828Eq c0828Eq = this.A00;
            if (A01[6].charAt(16) != 'e') {
                throw new RuntimeException();
            }
            A01[0] = "BbBTSQcWyeSpGVnm";
            c0828Eq.removeDetachedView(abstractC05784e.A0H, false);
        }
    }
}
