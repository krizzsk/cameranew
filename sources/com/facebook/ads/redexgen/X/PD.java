package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: assets/audience_network.dex */
public final class PD extends LinearLayout {
    public static final int A04 = (int) (LY.A00 * 32.0f);
    public static final int A05 = (int) (LY.A00 * 8.0f);
    public TextView A00;
    public TextView A01;
    public OA A02;
    public final XT A03;

    public PD(XT xt) {
        super(xt);
        this.A03 = xt;
        A00(xt);
    }

    private final void A00(XT xt) {
        setGravity(16);
        this.A02 = new OA(xt);
        this.A02.setFullCircleCorners(true);
        int i2 = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.setMargins(0, 0, A05, 0);
        addView(this.A02, layoutParams);
        LinearLayout linearLayout = new LinearLayout(xt);
        linearLayout.setOrientation(1);
        this.A00 = new TextView(xt);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        M5.A0X(this.A00, true, 16);
        this.A00.setEllipsize(TextUtils.TruncateAt.END);
        this.A00.setSingleLine(true);
        this.A01 = new TextView(xt);
        M5.A0X(this.A01, false, 14);
        linearLayout.addView(this.A00);
        linearLayout.addView(this.A01);
        addView(linearLayout, layoutParams2);
    }

    public final void A01(int i2, int i3) {
        this.A00.setTextColor(i2);
        this.A01.setTextColor(i3);
    }

    public void setPageDetails(C1S c1s) {
        AsyncTaskC1164Sb asyncTaskC1164Sb = new AsyncTaskC1164Sb(this.A02, this.A03);
        int i2 = A04;
        asyncTaskC1164Sb.A05(i2, i2);
        asyncTaskC1164Sb.A07(c1s.A01());
        this.A00.setText(c1s.A02());
        this.A01.setText(c1s.A03());
    }
}
