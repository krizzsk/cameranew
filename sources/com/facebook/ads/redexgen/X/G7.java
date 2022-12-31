package com.facebook.ads.redexgen.X;

import java.util.Map;
/* loaded from: assets/audience_network.dex */
public abstract class G7 implements RM {
    public final GG A00;
    public final RR A01;

    public G7(GG gg, RR rr) {
        this.A00 = gg;
        this.A01 = rr;
    }

    @Override // com.facebook.ads.redexgen.X.RM
    public void A3M(Map<R4, RR> map, Map<GD, RE> map2) {
        map.put(this.A00, this.A01);
    }
}
