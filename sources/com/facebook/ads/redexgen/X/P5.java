package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class P5 extends LinearLayout {
    @Nullable
    public LinearLayout A00;
    public final int A01;
    public final XT A02;
    public final OA A03;
    public final OG A04;
    public static final int A07 = (int) (LY.A00 * 16.0f);
    public static final int A08 = (int) (LY.A00 * 16.0f);
    public static final int A06 = (int) (LY.A00 * 8.0f);
    public static final int A05 = (int) (LY.A00 * 72.0f);

    public P5(P3 p3) {
        super(P3.A04(p3));
        this.A02 = P3.A04(p3);
        this.A03 = new OA(this.A02);
        this.A04 = new OG(this.A02, P3.A02(p3), true, false, true);
        this.A01 = P3.A00(p3);
        A03(p3);
    }

    public /* synthetic */ P5(P3 p3, C1153Rq c1153Rq) {
        this(p3);
    }

    private void A00() {
        A01(this.A03, 150);
        A01(this.A04, 170);
        LinearLayout linearLayout = this.A00;
        if (linearLayout != null) {
            A01(linearLayout, 190);
        }
    }

    private void A01(View view, int i2) {
        view.setTranslationY(i2);
        view.setScaleY(0.75f);
        view.setScaleX(0.75f);
        view.animate().translationYBy(-i2).scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator(2.0f));
    }

    private void A02(P3 p3) {
        if (!TextUtils.isEmpty(P3.A05(p3))) {
            this.A00 = new LinearLayout(getContext());
            this.A00.setGravity(17);
            LinearLayout linearLayout = this.A00;
            int i2 = A08;
            linearLayout.setPadding(i2, i2 / 2, i2, i2 / 2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, A08 / 2, 0, 0);
            TextView textView = new TextView(getContext());
            textView.setTextColor(-1);
            M5.A0X(textView, false, 16);
            textView.setText(P3.A05(p3));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            ImageView imageView = new ImageView(getContext());
            new AsyncTaskC1164Sb(imageView, this.A02).A04().A07(P3.A06(p3));
            int i3 = A07;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, i3);
            layoutParams3.setMargins(0, 0, A08 / 2, 0);
            this.A00.addView(imageView, layoutParams3);
            this.A00.addView(textView, layoutParams2);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(100.0f);
            gradientDrawable.setColor(469762047);
            M5.A0S(this.A00, gradientDrawable);
            addView(this.A00, layoutParams);
        }
    }

    private void A03(P3 p3) {
        M5.A0M(this.A03, 0);
        this.A03.setRadius(50);
        if (P3.A01(p3).A00() == C1E.A05) {
            this.A03.setFullCircleCorners(true);
        } else {
            this.A03.setRadius(A06);
        }
        new AsyncTaskC1164Sb(this.A03, this.A02).A04().A07(P3.A03(p3).A01());
        this.A04.A01(P3.A01(p3).A06(), P3.A03(p3).A03(), null, false, true);
        this.A04.getDescriptionTextView().setAlpha(0.8f);
        this.A04.setAlignment(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i2 = A08;
        layoutParams.setMargins(0, i2, 0, i2 / 2);
        View view = this.A03;
        int i3 = A05;
        addView(view, new LinearLayout.LayoutParams(i3, i3));
        addView(this.A04, layoutParams);
        A02(p3);
        M5.A0M(this, -14473425);
        setGravity(17);
        setOrientation(1);
    }

    public final void A04(P4 p4) {
        A00();
        postDelayed(new C1153Rq(this, p4), this.A01);
    }
}
