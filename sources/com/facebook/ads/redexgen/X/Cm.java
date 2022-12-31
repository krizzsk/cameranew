package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class Cm {
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public boolean A04;
    public final byte[] A05 = new byte[10];

    public final void A00() {
        this.A04 = false;
    }

    public final void A01(CQ cq, int i2, int i3) throws IOException, InterruptedException {
        if (!this.A04) {
            cq.ACp(this.A05, 0, 10);
            cq.ADr();
            if (C0742Ax.A06(this.A05) == -1) {
                return;
            }
            this.A04 = true;
            this.A02 = 0;
        }
        if (this.A02 == 0) {
            this.A00 = i2;
            this.A01 = 0;
        }
        this.A01 += i3;
    }

    public final void A02(Cl cl) {
        if (this.A04 && this.A02 > 0) {
            cl.A0W.AE5(this.A03, this.A00, this.A01, 0, cl.A0V);
            this.A02 = 0;
        }
    }

    public final void A03(Cl cl, long j2) {
        if (!this.A04) {
            return;
        }
        int i2 = this.A02;
        this.A02 = i2 + 1;
        if (i2 == 0) {
            this.A03 = j2;
        }
        if (this.A02 < 16) {
            return;
        }
        cl.A0W.AE5(this.A03, this.A00, this.A01, 0, cl.A0V);
        this.A02 = 0;
    }
}
