package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: assets/audience_network.dex */
public final class N0 extends RelativeLayout {
    public final int A00;
    public final int A01;
    public final XT A02;
    public final N3 A03;
    public final boolean A04;
    public static final int A08 = (int) (LY.A00 * 16.0f);
    public static final int A09 = (int) (LY.A00 * 8.0f);
    public static final int A0C = (int) (LY.A00 * 44.0f);
    public static final int A07 = (int) (LY.A00 * 10.0f);
    public static final int A06 = A08 - A07;
    public static final int A0D = (int) (LY.A00 * 75.0f);
    public static final int A0A = (int) (LY.A00 * 25.0f);
    public static final int A0E = (int) (LY.A00 * 45.0f);
    public static final int A0B = (int) (LY.A00 * 15.0f);
    public static final int A05 = (int) (LY.A00 * 16.0f);

    public N0(C1034Mz c1034Mz) {
        super(C1034Mz.A01(c1034Mz));
        this.A02 = C1034Mz.A01(c1034Mz);
        this.A03 = C1034Mz.A03(c1034Mz);
        this.A01 = C1034Mz.A09(c1034Mz) ? A0D : A0E;
        this.A00 = C1034Mz.A09(c1034Mz) ? A0A : A0B;
        this.A04 = C1034Mz.A0A(c1034Mz);
        setFocusable(true);
        View A01 = A01(c1034Mz);
        View A00 = A00(c1034Mz);
        View footerView = getFooterView();
        M5.A0K(A01);
        M5.A0K(A00);
        M5.A0K(footerView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        layoutParams2.addRule(3, A01.getId());
        layoutParams2.addRule(2, footerView.getId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(12);
        int i2 = A08;
        layoutParams3.setMargins(i2, 0, i2, i2);
        addView(A01, layoutParams);
        addView(A00, layoutParams2);
        addView(footerView, layoutParams3);
        footerView.setVisibility(C1034Mz.A0B(c1034Mz) ? 0 : 8);
    }

    public /* synthetic */ N0(C1034Mz c1034Mz, View$OnClickListenerC1032Mx view$OnClickListenerC1032Mx) {
        this(c1034Mz);
    }

    private View A00(C1034Mz c1034Mz) {
        ImageView imageView = new ImageView(getContext());
        int i2 = this.A00;
        imageView.setPadding(i2, i2, i2, i2);
        imageView.setImageBitmap(ME.A01(C1034Mz.A02(c1034Mz)));
        imageView.setColorFilter(-1);
        int i3 = this.A01;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(C1034Mz.A00(c1034Mz));
        M5.A0S(imageView, gradientDrawable);
        layoutParams.gravity = 17;
        int i4 = A08;
        layoutParams.setMargins(i4, 0, i4, i4);
        TextView textView = new TextView(getContext());
        M5.A0X(textView, true, 20);
        textView.setTextColor(-14934495);
        textView.setText(C1034Mz.A04(c1034Mz));
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        int i5 = A08;
        layoutParams2.setMargins(i5, 0, i5, i5);
        TextView textView2 = new TextView(getContext());
        M5.A0X(textView2, false, 16);
        textView2.setTextColor(-10459280);
        textView2.setText(C1034Mz.A05(c1034Mz));
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int i6 = A08;
        layoutParams3.setMargins(i6, 0, i6, i6);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        linearLayout.addView(textView2, layoutParams3);
        if (C1034Mz.A08(c1034Mz)) {
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            if (!TextUtils.isEmpty(C1034Mz.A06(c1034Mz))) {
                OA oa = new OA(this.A02);
                int i7 = A0E;
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i7, i7);
                layoutParams4.setMargins(0, 0, A09, 0);
                oa.setFullCircleCorners(true);
                AsyncTaskC1164Sb asyncTaskC1164Sb = new AsyncTaskC1164Sb(oa, this.A02);
                int i8 = A0E;
                asyncTaskC1164Sb.A05(i8, i8).A07(C1034Mz.A06(c1034Mz));
                linearLayout2.addView(oa, layoutParams4);
            }
            N5 n5 = new N5(this.A02);
            n5.setData(C1034Mz.A07(c1034Mz), MD.CHECKMARK);
            n5.setSelected(true);
            LinearLayout.LayoutParams selectedOptionParams = new LinearLayout.LayoutParams(-2, -2);
            linearLayout2.addView(n5, selectedOptionParams);
            linearLayout.addView(linearLayout2);
        }
        return linearLayout;
    }

    private View A01(C1034Mz c1034Mz) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        if (C1034Mz.A0C(c1034Mz)) {
            ImageView imageView = new ImageView(getContext());
            int i2 = A07;
            imageView.setPadding(i2, i2, i2, i2);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageBitmap(ME.A01(MD.CROSS));
            imageView.setOnClickListener(new View$OnClickListenerC1032Mx(this));
            int i3 = A0C;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            int i4 = A06;
            layoutParams.setMargins(i4, i4, i4, i4);
            linearLayout.addView(imageView, layoutParams);
        }
        return linearLayout;
    }

    private View getFooterView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(ME.A01(MD.SETTINGS));
        imageView.setColorFilter(-13272859);
        int i2 = A05;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 17;
        TextView textView = new TextView(getContext());
        M5.A0X(textView, false, 16);
        textView.setTextColor(-13272859);
        int i3 = A09;
        textView.setPadding(i3, i3, i3, i3);
        textView.setText(C2A.A0D(this.A02.A00()));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setOnClickListener(new View$OnClickListenerC1033My(this));
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }
}
