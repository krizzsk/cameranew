package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.widget.Button;
import java.util.Locale;
/* loaded from: assets/audience_network.dex */
public class O4 extends Button {
    public static final int A0A = (int) (LY.A00 * 16.0f);
    public static final int A0B = (int) (LY.A00 * 4.0f);
    public int A00;
    public int A01;
    public C1I A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final float A06;
    public final int A07;
    public final Runnable A08;
    public final Runnable A09;

    public O4(XT xt, C1I c1i) {
        super(xt);
        this.A03 = false;
        this.A01 = 0;
        this.A00 = 0;
        this.A04 = true;
        this.A05 = false;
        this.A08 = new SY(this);
        this.A09 = new SX(this);
        this.A02 = c1i;
        this.A07 = JD.A03(xt);
        this.A06 = JD.A00(xt);
        M5.A0X(this, false, 16);
        setGravity(17);
        A03();
    }

    private void A03() {
        C1I c1i = this.A02;
        if (c1i != null) {
            this.A00 = c1i.A08(this.A05);
            this.A01 = this.A02.A09(this.A05);
        }
        M5.A0O(this, this.A00, this.A04 ? A0B : 0);
        setTextColor(this.A01);
    }

    private void A04() {
        if (this.A07 < 0 || this.A03) {
            return;
        }
        this.A03 = true;
        if (JD.A1i(getContext()) && Build.VERSION.SDK_INT >= 16) {
            postDelayed(this.A08, this.A07);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        A04();
    }

    public void setRoundedCornersEnabled(boolean z) {
        this.A04 = z;
        A03();
    }

    public void setText(String str) {
        super.setText((CharSequence) str.toUpperCase(Locale.US));
    }

    public void setUpButtonColors(C1I c1i) {
        this.A02 = c1i;
        A03();
    }

    public void setViewShowsOverMedia(boolean z) {
        this.A05 = z;
        A03();
    }
}
