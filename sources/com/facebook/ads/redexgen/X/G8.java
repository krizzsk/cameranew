package com.facebook.ads.redexgen.X;

import java.util.Map;
/* loaded from: assets/audience_network.dex */
public abstract class G8 implements RM {
    public final RE A00;
    public final C4E A01;

    public G8(C4E c4e, RE re) {
        this.A01 = c4e;
        this.A00 = re;
    }

    @Override // com.facebook.ads.redexgen.X.RM
    public void A3M(Map<R4, RR> map, Map<GD, RE> map2) {
        map2.put(this.A01, this.A00);
    }
}
