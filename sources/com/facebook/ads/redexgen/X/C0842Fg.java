package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.Fg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0842Fg {
    @Nullable
    public C0842Fg A00;
    @Nullable
    public HI A01;
    public boolean A02;
    public final long A03;
    public final long A04;

    public C0842Fg(long j2, int i2) {
        this.A04 = j2;
        this.A03 = i2 + j2;
    }

    public final int A00(long j2) {
        return ((int) (j2 - this.A04)) + this.A01.A00;
    }

    public final C0842Fg A01() {
        this.A01 = null;
        C0842Fg c0842Fg = this.A00;
        this.A00 = null;
        return c0842Fg;
    }

    public final void A02(HI hi, C0842Fg c0842Fg) {
        this.A01 = hi;
        this.A00 = c0842Fg;
        this.A02 = true;
    }
}
