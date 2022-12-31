package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class MR extends LinearLayout {
    public static byte[] A03;
    public static final int A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public final ImageView A00;
    public final ImageView A01;
    public final XT A02;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 91);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{118, 83};
    }

    static {
        A02();
        A07 = (int) (LY.A00 * 50.0f);
        A04 = (int) (LY.A00 * 10.0f);
        A05 = (int) (LY.A00 * 20.0f);
        A08 = (int) (LY.A00 * 4.0f);
        A06 = (int) (LY.A00 * 12.0f);
    }

    public MR(XT xt, int i2) {
        super(xt);
        this.A02 = xt;
        setOrientation(0);
        this.A00 = new ImageView(xt);
        this.A01 = new ImageView(xt);
        A03(i2);
    }

    private void A03(int i2) {
        MD md;
        A04(this.A00, MD.AD_CHOICES_ICON);
        if (i2 == 2) {
            int i3 = A04;
            setPadding(i3, i3 / 3, i3, i3 / 3);
            TextView textView = new TextView(this.A02);
            textView.setText(A01(0, 2, 108));
            textView.setTextColor(-1);
            int i4 = A04;
            textView.setPadding(0, i4 / 2, i4 / 2, i4 / 2);
            M5.A0X(textView, true, 13);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            addView(textView, layoutParams);
            int i5 = A06;
            LinearLayout.LayoutParams adChoicesIconParams = new LinearLayout.LayoutParams(i5, i5);
            adChoicesIconParams.gravity = 16;
            addView(this.A00, adChoicesIconParams);
            return;
        }
        int i6 = A04;
        setPadding(i6, i6, i6, i6);
        if (i2 == 1) {
            md = MD.AN_INFO_ICON;
        } else {
            md = MD.DEFAULT_INFO_ICON;
        }
        A04(this.A01, md);
        int i7 = A05;
        LinearLayout.LayoutParams infoButtonParams = new LinearLayout.LayoutParams(i7, i7);
        infoButtonParams.gravity = 17;
        addView(this.A01, infoButtonParams);
        int i8 = A05;
        LinearLayout.LayoutParams infoButtonParams2 = new LinearLayout.LayoutParams(i8, i8);
        infoButtonParams2.setMargins(A08, 0, 0, 0);
        infoButtonParams2.gravity = 17;
        addView(this.A00, infoButtonParams2);
    }

    public static void A04(ImageView imageView, MD md) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(ME.A01(md));
        imageView.setColorFilter(-1);
    }

    public void setAdDetails(C1S c1s, String str, C0937Jb c0937Jb, MU mu) {
        setOnClickListener(new MQ(this, c0937Jb, mu, str, c1s));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(A07);
        gradientDrawable.setColor(i2);
        M5.A0S(this, gradientDrawable);
    }

    public void setIconColors(int i2) {
        this.A00.setColorFilter(i2);
        this.A01.setColorFilter(i2);
    }
}
