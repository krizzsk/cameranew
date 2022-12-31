package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* renamed from: com.facebook.ads.redexgen.X.Mo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1023Mo extends LinearLayout {
    public static final int A06 = (int) (LY.A00 * 10.0f);
    public static final int A07 = (int) (LY.A00 * 44.0f);
    public int A00;
    public boolean A01;
    public final ImageView A02;
    public final LinearLayout A03;
    public final TextView A04;
    public final O3 A05;

    public C1023Mo(XT xt, int i2) {
        super(xt);
        this.A01 = false;
        this.A02 = new ImageView(xt);
        ImageView imageView = this.A02;
        int i3 = A06;
        imageView.setPadding(i3, i3, i3, i3);
        this.A05 = new O3(xt);
        this.A05.setProgress(0.0f);
        O3 o3 = this.A05;
        int i4 = A06;
        o3.setPadding(i4, i4, i4, i4);
        this.A04 = new TextView(xt);
        setOrientation(0);
        this.A03 = new LinearLayout(xt);
        this.A00 = i2;
        A00();
    }

    private void A00() {
        setToolbarActionMode(this.A00);
        LinearLayout.LayoutParams actionIconParams = new LinearLayout.LayoutParams(-2, -2);
        setGravity(17);
        int i2 = A07;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        M5.A0X(this.A04, true, 16);
        this.A04.setTextColor(-1);
        this.A04.setVisibility(8);
        this.A03.addView(this.A02, layoutParams);
        this.A03.addView(this.A05, layoutParams);
        addView(this.A03, actionIconParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        addView(this.A04, layoutParams2);
    }

    private void A01() {
        int i2;
        O3 o3 = this.A05;
        if (this.A00 == 2) {
            i2 = this.A01 ? 4 : 0;
        } else {
            i2 = 8;
        }
        o3.setVisibility(i2);
        this.A02.setVisibility(this.A00 == 2 ? 8 : 0);
    }

    public final boolean A02() {
        return !this.A04.getText().toString().isEmpty();
    }

    public final boolean A03() {
        int i2 = this.A00;
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public void setActionClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setColors(int i2) {
        this.A05.A02(C2N.A01(i2, 77), i2);
        this.A02.setColorFilter(i2);
    }

    public void setInitialUnskippableSeconds(int i2) {
        if (i2 > 0) {
            setToolbarActionMode(2);
        }
    }

    public void setProgress(float f2) {
        this.A05.setProgressWithAnimation(f2);
    }

    public void setProgressSpinnerInvisible(boolean z) {
        this.A01 = z;
        A01();
    }

    public void setToolbarActionMode(int i2) {
        MD md;
        this.A00 = i2;
        A01();
        setVisibility(0);
        if (i2 == 0) {
            md = MD.CROSS;
        } else if (i2 == 1) {
            md = MD.SKIP_ARROW;
        } else if (i2 == 3) {
            md = MD.MINIMIZE_ARROW;
        } else if (i2 != 4) {
            md = MD.CROSS;
        } else {
            md = MD.CROSS;
            this.A02.setVisibility(8);
            setVisibility(8);
        }
        this.A02.setImageBitmap(ME.A01(md));
        M5.A0G(1002, this.A02);
    }

    public void setToolbarMessage(String str) {
        this.A04.setText(str);
        this.A04.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void setToolbarMessageEnabled(boolean z) {
        this.A04.setVisibility(z ? 0 : 4);
    }
}
