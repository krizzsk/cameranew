package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.TransitionSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* renamed from: com.facebook.ads.redexgen.X.Sq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1179Sq extends N1 {
    public static final int A02 = (int) (LY.A00 * 8.0f);
    public final RelativeLayout A00;
    public final XT A01;

    public C1179Sq(XT xt, JT jt, String str, C1S c1s, MV mv, MU mu) {
        super(xt, jt, str, c1s, mv, mu);
        this.A01 = xt;
        this.A00 = new RelativeLayout(getContext());
        addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        M5.A0M(this.A00, -1728053248);
        this.A00.setOnClickListener(new N6(this));
    }

    public static RelativeLayout.LayoutParams A0A(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, z ? -1 : -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    private void A0B() {
        if (Build.VERSION.SDK_INT >= 21) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.setOrdering(0);
            transitionSet.addTransition(new ChangeBounds()).addTransition(new Explode());
            M5.A0V(this, transitionSet);
            return;
        }
        M5.A0T(this);
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0K() {
        C2D A03 = C2A.A03(this.A01.A00());
        NG ng = new NG(this.A01);
        ng.setInfo(MD.HIDE_AD, C2A.A0B(this.A01.A00()), C2A.A0A(this.A01.A00()));
        ng.setOnClickListener(new N7(this));
        C2D A04 = C2A.A04(this.A01.A00());
        NG ng2 = new NG(this.A01);
        ng2.setInfo(MD.REPORT_AD, C2A.A0F(this.A01.A00()), C2A.A0E(this.A01.A00()));
        ng2.setOnClickListener(new N8(this));
        NG ng3 = new NG(this.A01);
        ng3.setInfo(MD.AD_CHOICES_ICON, C2A.A0G(this.A01.A00()), "");
        ng3.setOnClickListener(new N9(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        linearLayout.setOrientation(1);
        int i2 = A02;
        linearLayout.setPadding(i2 * 2, i2, i2 * 2, i2);
        M5.A0M(linearLayout, -1);
        if (!A03.A05().isEmpty()) {
            linearLayout.addView(ng, layoutParams);
        }
        if (!A04.A05().isEmpty()) {
            linearLayout.addView(ng2, layoutParams);
        }
        linearLayout.addView(ng3, layoutParams);
        A0B();
        this.A00.removeAllViews();
        this.A00.addView(linearLayout, A0A(false));
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0L() {
        M5.A0I(this);
        this.A00.removeAllViews();
        M5.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0M(C2D c2d, C2B c2b) {
        String A08;
        int i2;
        if (c2b == C2B.A04) {
            return;
        }
        boolean z = c2b == C2B.A05;
        C1034Mz c1034Mz = new C1034Mz(this.A01, this.A0A);
        if (z) {
            A08 = C2A.A09(this.A01.A00());
        } else {
            A08 = C2A.A08(this.A01.A00());
        }
        C1034Mz A0E = c1034Mz.A0I(A08).A0H(C2A.A07(this.A01.A00())).A0F(c2d.A04()).A0E(z ? MD.REPORT_AD : MD.HIDE_AD);
        if (z) {
            i2 = -552389;
        } else {
            i2 = -13272859;
        }
        N0 A0M = A0E.A0D(i2).A0G(this.A09 != null ? this.A09.A01() : "").A0M();
        M5.A0M(A0M, -1);
        M5.A0T(this);
        this.A00.removeAllViews();
        this.A00.addView(A0M, A0A(true));
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0N(C2D c2d, C2B c2b) {
        String A0B;
        boolean z = c2b == C2B.A05;
        XT xt = this.A01;
        N3 n3 = this.A0A;
        if (z) {
            A0B = C2A.A0F(this.A01.A00());
        } else {
            A0B = C2A.A0B(this.A01.A00());
        }
        NJ nj = new NJ(xt, c2d, n3, A0B, z ? MD.REPORT_AD : MD.HIDE_AD);
        nj.setClickable(true);
        M5.A0M(nj, -1);
        int i2 = A02;
        nj.setPadding(i2 * 2, i2, i2 * 2, i2);
        A0B();
        this.A00.removeAllViews();
        this.A00.addView(nj, A0A(false));
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final boolean A0O() {
        return false;
    }
}
