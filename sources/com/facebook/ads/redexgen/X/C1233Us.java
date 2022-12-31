package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Us  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1233Us implements GL {
    public final long[] A00;
    public final GK[] A01;

    public C1233Us(GK[] gkArr, long[] jArr) {
        this.A01 = gkArr;
        this.A00 = jArr;
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final List<GK> A67(long j2) {
        int A0B = C0923Il.A0B(this.A00, j2, true, false);
        if (A0B != -1) {
            GK[] gkArr = this.A01;
            if (gkArr[A0B] != null) {
                return Collections.singletonList(gkArr[A0B]);
            }
        }
        return Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final long A6X(int i2) {
        boolean z = true;
        I6.A03(i2 >= 0);
        if (i2 >= this.A00.length) {
            z = false;
        }
        I6.A03(z);
        return this.A00[i2];
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6Y() {
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6v(long j2) {
        int A0A = C0923Il.A0A(this.A00, j2, false, false);
        if (A0A < this.A00.length) {
            return A0A;
        }
        return -1;
    }
}
