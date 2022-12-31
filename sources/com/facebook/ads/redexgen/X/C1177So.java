package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.So  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1177So extends N1 {
    public static byte[] A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public final ImageView A00;
    public final LinearLayout A01;
    public final ScrollView A02;
    public final XT A03;

    public static String A0A(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 55);
        }
        return new String(copyOfRange);
    }

    public static void A0B() {
        A04 = new byte[]{53, 22, 20, 28, 105, 70, 69, 89, 79, 10, 107, 78, 10, 120, 79, 90, 69, 88, 94, 67, 68, 77};
    }

    static {
        A0B();
        A07 = (int) (LY.A00 * 8.0f);
        A06 = (int) (LY.A00 * 10.0f);
        A05 = (int) (LY.A00 * 44.0f);
    }

    public C1177So(XT xt, JT jt, String str) {
        super(xt, jt, str);
        this.A03 = xt;
        this.A00 = new ImageView(getContext());
        ImageView imageView = this.A00;
        int i2 = A06;
        imageView.setPadding(i2, i2, i2, i2);
        this.A00.setColorFilter(-10459280);
        int i3 = A05;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 3;
        this.A00.setLayoutParams(layoutParams);
        this.A02 = new ScrollView(getContext());
        this.A02.setFillViewport(true);
        M5.A0M(this.A02, -218103809);
        this.A01 = new LinearLayout(getContext());
        this.A01.setOrientation(1);
        LinearLayout linearLayout = this.A01;
        int i4 = A07;
        linearLayout.setPadding(i4, i4, i4, i4);
        this.A02.addView(this.A01, new FrameLayout.LayoutParams(-1, -2));
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0K() {
        this.A00.setImageBitmap(ME.A01(MD.CROSS));
        this.A00.setOnClickListener(new NK(this));
        this.A00.setContentDescription(A0A(4, 18, 29));
        N5 n5 = new N5(this.A03);
        n5.setData(C2A.A0B(this.A03.A00()), MD.HIDE_AD);
        n5.setOnClickListener(new NL(this, n5));
        N5 n52 = new N5(this.A03);
        n52.setData(C2A.A0F(this.A03.A00()), MD.REPORT_AD);
        n52.setOnClickListener(new NM(this, n52));
        N5 n53 = new N5(this.A03);
        n53.setData(C2A.A0G(this.A03.A00()), MD.AD_CHOICES_ICON);
        n53.setOnClickListener(new NN(this, n53));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i2 = A07;
        layoutParams.setMargins(i2, i2, i2, i2);
        layoutParams.gravity = 17;
        LinearLayout menuLayout = new LinearLayout(getContext());
        menuLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, 0);
        layoutParams2.gravity = 17;
        layoutParams2.weight = 1.0f;
        M5.A0T(this.A01);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(menuLayout, layoutParams2);
        menuLayout.addView(n5, layoutParams);
        menuLayout.addView(n52, layoutParams);
        menuLayout.addView(n53, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0L() {
        M5.A0I(this);
        M5.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0M(C2D c2d, C2B c2b) {
        String A0B;
        MD md;
        int i2;
        this.A00.setOnClickListener(null);
        if (c2b == C2B.A05) {
            A0B = C2A.A09(this.A03.A00());
            md = MD.REPORT_AD;
            i2 = -552389;
        } else {
            A0B = C2A.A0B(this.A03.A00());
            md = MD.HIDE_AD;
            i2 = -13272859;
        }
        N0 A0M = new C1034Mz(this.A03, this.A0A).A0I(A0B).A0H(C2A.A07(this.A03.A00())).A0F(c2d.A04()).A0K(false).A0E(md).A0D(i2).A0L(false).A0J(false).A0M();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        M5.A0T(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(A0M, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0N(C2D c2d, C2B c2b) {
        NJ nj = new NJ(this.A03, c2d, this.A0A, c2b == C2B.A05 ? MD.REPORT_AD : MD.HIDE_AD);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        this.A00.setImageBitmap(ME.A01(MD.BACK_ARROW));
        this.A00.setOnClickListener(new NO(this));
        this.A00.setContentDescription(A0A(0, 4, 64));
        M5.A0T(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(nj, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final boolean A0O() {
        return true;
    }
}
