package com.facebook.ads.redexgen.X;

import androidx.work.WorkRequest;
/* renamed from: com.facebook.ads.redexgen.X.Vy  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1262Vy implements CY {
    public final /* synthetic */ C1261Vx A00;

    public C1262Vy(C1261Vx c1261Vx) {
        this.A00 = c1261Vx;
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final long A6O() {
        DL dl;
        long j2;
        dl = this.A00.A0B;
        j2 = this.A00.A07;
        return dl.A03(j2);
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final CX A7I(long granule) {
        DL dl;
        long j2;
        long A00;
        long j3;
        if (granule == 0) {
            j3 = this.A00.A09;
            return new CX(new CZ(0L, j3));
        }
        dl = this.A00.A0B;
        long A04 = dl.A04(granule);
        C1261Vx c1261Vx = this.A00;
        j2 = c1261Vx.A09;
        A00 = c1261Vx.A00(j2, A04, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        return new CX(new CZ(granule, A00));
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final boolean A8Y() {
        return true;
    }
}
