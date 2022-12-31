package com.facebook.ads.redexgen.X;

import android.widget.LinearLayout;
/* loaded from: assets/audience_network.dex */
public final class OC extends LinearLayout {
    public static final int A06 = (int) (LY.A00 * 4.0f);
    public int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final XT A04;
    public final OD[] A05;

    public OC(XT xt, int i2, int i3, int i4, int i5) {
        super(xt);
        this.A00 = A06;
        this.A04 = xt;
        setOrientation(0);
        this.A03 = i2;
        this.A01 = i4;
        this.A02 = i5;
        this.A05 = new OD[i3];
        for (int i6 = 0; i6 < i3; i6++) {
            this.A05[i6] = A00();
            addView(this.A05[i6]);
        }
        A01();
    }

    private OD A00() {
        OD od = new OD(this.A04, this.A01, this.A02);
        int i2 = this.A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 16;
        od.setLayoutParams(layoutParams);
        return od;
    }

    private void A01() {
        int i2 = 0;
        while (true) {
            OD[] odArr = this.A05;
            if (i2 < odArr.length) {
                ((LinearLayout.LayoutParams) odArr[i2].getLayoutParams()).leftMargin = i2 == 0 ? 0 : this.A00;
                i2++;
            } else {
                requestLayout();
                return;
            }
        }
    }

    private void A02(float f2) {
        for (int i2 = 0; i2 < this.A05.length; i2++) {
            float min = Math.min(1.0f, f2 - i2);
            if (min < 0.0f) {
                min = 0.0f;
            }
            this.A05[i2].setFillRatio(min);
        }
    }

    public void setItemSpacing(int i2) {
        this.A00 = i2;
        A01();
    }

    public void setRating(float f2) {
        A02(f2);
    }
}
