package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Up  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1230Up implements GL {
    public final List<GK> A00;

    public C1230Up(List<GK> list) {
        this.A00 = Collections.unmodifiableList(list);
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final List<GK> A67(long j2) {
        return j2 >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final long A6X(int i2) {
        I6.A03(i2 == 0);
        return 0L;
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6Y() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6v(long j2) {
        return j2 < 0 ? 0 : -1;
    }
}
