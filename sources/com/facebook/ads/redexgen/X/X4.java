package com.facebook.ads.redexgen.X;

import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class X4 implements RJ {
    public final /* synthetic */ XS A00;
    public final /* synthetic */ KU A01;

    public X4(KU ku, XS xs) {
        this.A01 = ku;
        this.A00 = xs;
    }

    @Override // com.facebook.ads.redexgen.X.RJ
    public final Map<String, String> A6T() {
        return this.A01.A08(C9H.A00().A01(this.A00, true).A6S());
    }
}
