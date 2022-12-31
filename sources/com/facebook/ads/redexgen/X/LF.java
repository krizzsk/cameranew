package com.facebook.ads.redexgen.X;

import androidx.annotation.VisibleForTesting;
/* loaded from: assets/audience_network.dex */
public final class LF {
    public static final LF A04 = new LF(new TT(), new TS());
    public final LE A02;
    public final InterfaceC1007Lx A03;
    public boolean A01 = true;
    public long A00 = -1;

    @VisibleForTesting
    public LF(InterfaceC1007Lx interfaceC1007Lx, LE le) {
        this.A03 = interfaceC1007Lx;
        this.A02 = le;
    }

    public static LF A00() {
        return A04;
    }

    public final synchronized void A01() {
        this.A01 = false;
        this.A00 = this.A03.A4e();
    }

    public final synchronized void A02() {
        this.A00 = -1L;
    }

    public final boolean A03() {
        boolean z = true;
        if (this.A02.A6n() != null) {
            return true;
        }
        synchronized (LF.class) {
            if (this.A01) {
                return true;
            }
            if (this.A00 >= 0 && this.A03.A4e() - this.A00 >= 1000) {
                z = false;
            }
            return z;
        }
    }
}
