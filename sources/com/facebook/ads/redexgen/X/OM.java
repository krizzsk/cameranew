package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public class OM {
    @Nullable
    public View A02;
    @Nullable
    public C1198Tj A03;
    @Nullable
    public MT A04;
    @Nullable
    public IS A05;
    @Nullable
    public final View A06;
    public final AnonymousClass16 A07;
    public final XT A08;
    public final JT A09;
    public final C1009Lz A0A;
    public final MU A0B;
    public final QZ A0C;
    public int A01 = 0;
    public int A00 = 1;

    public OM(XT xt, JT jt, MU mu, AnonymousClass16 anonymousClass16, @Nullable View view, QZ qz, C1009Lz c1009Lz) {
        this.A08 = xt;
        this.A09 = jt;
        this.A0B = mu;
        this.A07 = anonymousClass16;
        this.A06 = view;
        this.A0C = qz;
        this.A0A = c1009Lz;
    }

    public final OM A0D(int i2) {
        this.A00 = i2;
        return this;
    }

    public final OM A0E(int i2) {
        this.A01 = i2;
        return this;
    }

    public final OM A0F(View view) {
        this.A02 = view;
        return this;
    }

    public final OM A0G(C1198Tj c1198Tj) {
        this.A03 = c1198Tj;
        return this;
    }

    public final OM A0H(MT mt) {
        this.A04 = mt;
        return this;
    }

    public final OM A0I(IS is) {
        this.A05 = is;
        return this;
    }

    public final ON A0J() {
        return new ON(this);
    }
}
