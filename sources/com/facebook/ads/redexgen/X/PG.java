package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class PG extends FrameLayout {
    public static final int A07 = (int) (LY.A00 * 16.0f);
    public A8 A00;
    @Nullable
    public C7x A01;
    public C0921Ij A02;
    public C06527b A03;
    public C06296e A04;
    public final XT A05;
    public final C0937Jb A06;

    public PG(XT xt, C0937Jb c0937Jb) {
        super(xt);
        this.A06 = c0937Jb;
        this.A05 = xt;
        setUpView(xt);
    }

    public final void A01() {
        this.A00.A0e(true, 10);
    }

    public final void A02() {
        C7x c7x = this.A01;
        if (c7x != null) {
            c7x.A0g();
            this.A01 = null;
        }
    }

    public final void A03(C9P c9p) {
        this.A00.getEventBus().A05(c9p);
    }

    public final void A04(JT jt, String str, Map<String, String> extraParams) {
        A02();
        this.A01 = new C7x(this.A05, jt, this.A00, str, extraParams);
    }

    public final void A05(EnumC1094Pj enumC1094Pj) {
        this.A00.A0b(enumC1094Pj, 13);
    }

    public final boolean A06() {
        return this.A00.A0k();
    }

    public C1099Po getSimpleVideoView() {
        return this.A00;
    }

    public float getVolume() {
        return this.A00.getVolume();
    }

    public void setPlaceholderUrl(String str) {
        this.A03.setImage(str);
    }

    private void setUpPlugins(XT xt) {
        this.A00.A0X();
        this.A03 = new C06527b(xt);
        this.A00.A0c(this.A03);
        this.A02 = new C0921Ij(xt, this.A06);
        this.A00.A0c(new C06587j(xt));
        this.A00.A0c(this.A02);
        this.A04 = new C06296e(xt, true, this.A06);
        this.A00.A0c(this.A04);
        this.A00.A0c(new JX(this.A04, EnumC1107Pw.A03, true, true));
        if (!this.A00.A0g() && !JD.A1s(xt)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int i2 = A07;
        layoutParams.setMargins(i2, i2, i2, i2);
        this.A02.setLayoutParams(layoutParams);
        this.A00.addView(this.A02);
    }

    private void setUpVideo(XT xt) {
        this.A00 = new A8(xt);
        this.A00.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        M5.A0K(this.A00);
        addView(this.A00);
        setOnClickListener(new PF(this));
    }

    private void setUpView(XT xt) {
        setUpVideo(xt);
        setUpPlugins(xt);
    }

    public void setVideoURI(String str) {
        this.A00.setVideoURI(str);
    }

    public void setVolume(float f2) {
        this.A00.setVolume(f2);
        this.A02.A09();
    }
}
