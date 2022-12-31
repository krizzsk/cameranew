package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Sp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1178Sp extends N1 {
    public static byte[] A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public final HorizontalScrollView A00;
    public final ImageView A01;
    public final LinearLayout A02;
    public final LinearLayout A03;
    public final XT A04;

    public static String A0A(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 8);
        }
        return new String(copyOfRange);
    }

    public static void A0B() {
        A05 = new byte[]{-57, -26, -24, -16, -92, -51, -48, -44, -58, -127, -94, -59, -127, -77, -58, -47, -48, -45, -43, -54, -49, -56};
    }

    static {
        A0B();
        A08 = (int) (LY.A00 * 4.0f);
        A07 = (int) (LY.A00 * 10.0f);
        A06 = (int) (LY.A00 * 44.0f);
    }

    public C1178Sp(XT xt, JT jt, String str) {
        super(xt, jt, str);
        this.A04 = xt;
        this.A01 = new ImageView(getContext());
        ImageView imageView = this.A01;
        int i2 = A07;
        imageView.setPadding(i2, i2, i2, i2);
        this.A01.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A01.setColorFilter(-10459280);
        int i3 = A06;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 16;
        this.A02 = new LinearLayout(getContext());
        this.A02.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        this.A00 = new HorizontalScrollView(getContext());
        this.A00.setHorizontalScrollBarEnabled(false);
        this.A00.setLayoutParams(layoutParams2);
        this.A00.addView(this.A02, layoutParams2);
        this.A03 = new LinearLayout(getContext());
        this.A03.setOrientation(0);
        M5.A0M(this.A03, -218103809);
        this.A03.setMotionEventSplittingEnabled(false);
        this.A03.addView(this.A01, layoutParams);
        this.A03.addView(this.A00, layoutParams2);
        addView(this.A03, new FrameLayout.LayoutParams(-1, -1));
        this.A03.setClickable(true);
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0K() {
        this.A01.setImageBitmap(ME.A01(MD.CROSS));
        this.A01.setOnClickListener(new NA(this));
        this.A01.setContentDescription(A0A(4, 18, 89));
        N5 n5 = new N5(this.A04);
        n5.setData(C2A.A0B(this.A04.A00()), MD.HIDE_AD);
        n5.setOnClickListener(new NB(this, n5));
        N5 n52 = new N5(this.A04);
        n52.setData(C2A.A0F(this.A04.A00()), MD.REPORT_AD);
        n52.setOnClickListener(new NC(this, n52));
        N5 n53 = new N5(this.A04);
        n53.setData(C2A.A0G(this.A04.A00()), MD.AD_CHOICES_ICON);
        n53.setOnClickListener(new ND(this, n53));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i2 = A08;
        layoutParams.setMargins(0, i2, i2, i2);
        M5.A0T(this.A03);
        this.A02.removeAllViews();
        this.A02.addView(n5, layoutParams);
        this.A02.addView(n52, layoutParams);
        this.A02.addView(n53, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0L() {
        M5.A0I(this);
        M5.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0M(C2D c2d, C2B c2b) {
        this.A01.setOnClickListener(null);
        TextView textView = new TextView(getContext());
        M5.A0X(textView, true, 14);
        textView.setText(C2A.A07(this.A04.A00()));
        textView.setGravity(17);
        M5.A0T(this.A03);
        this.A03.removeAllViews();
        this.A03.addView(textView, new LinearLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final void A0N(C2D c2d, C2B c2b) {
        M5.A0T(this.A03);
        this.A01.setImageBitmap(ME.A01(MD.BACK_ARROW));
        this.A01.setOnClickListener(new NE(this));
        this.A01.setContentDescription(A0A(0, 4, 125));
        this.A02.removeAllViews();
        this.A00.fullScroll(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i2 = A08;
        layoutParams.setMargins(0, i2, i2, i2);
        for (C2D c2d2 : c2d.A05()) {
            N5 n5 = new N5(this.A04);
            n5.setData(c2d2.A04(), null);
            n5.setOnClickListener(new NF(this, n5, c2d2));
            this.A02.addView(n5, layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.X.N1
    public final boolean A0O() {
        return true;
    }
}
