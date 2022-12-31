package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public abstract class N1 extends FrameLayout {
    public int A00;
    public C2B A01;
    public C2C A02;
    @Nullable
    public C2D A03;
    public final XT A04;
    public final JT A05;
    @Nullable
    public final MU A06;
    @Nullable
    public final MV A07;
    public final String A08;
    @Nullable
    public final C1S A09;
    public final N3 A0A;

    public abstract void A0K();

    public abstract void A0L();

    public abstract void A0M(C2D c2d, C2B c2b);

    public abstract void A0N(C2D c2d, C2B c2b);

    public abstract boolean A0O();

    public N1(XT xt, JT jt, String str) {
        this(xt, jt, str, null, null, null);
    }

    public N1(XT xt, JT jt, String str, @Nullable C1S c1s, @Nullable MV mv, @Nullable MU mu) {
        super(xt);
        this.A00 = 0;
        this.A01 = C2B.A04;
        this.A03 = null;
        this.A0A = new C1180Sr(this);
        this.A04 = xt;
        this.A05 = jt;
        this.A07 = mv;
        this.A06 = mu;
        this.A08 = str;
        this.A09 = c1s;
    }

    public static /* synthetic */ int A00(N1 n1) {
        int i2 = n1.A00;
        n1.A00 = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int A01(N1 n1) {
        int i2 = n1.A00;
        n1.A00 = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        if (this.A02.A0A()) {
            this.A05.A8i(this.A08, this.A02.A02());
            this.A02.A03();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B() {
        this.A03 = null;
        this.A02.A05();
        A0K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(C2D c2d) {
        this.A02.A08(this.A01);
        A0M(c2d, this.A01);
        C04910u.A03();
        if (A0O()) {
            A0A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(C2D c2d) {
        this.A03 = c2d;
        this.A02.A09(this.A01, this.A00);
        A0N(c2d, this.A01);
    }

    public final void A0I() {
        A0A();
    }

    public final void A0J() {
        this.A02 = new C2C(new C0937Jb(this.A08, this.A05));
        MV mv = this.A07;
        if (mv != null) {
            mv.ABU(true);
        }
        A0B();
    }
}
