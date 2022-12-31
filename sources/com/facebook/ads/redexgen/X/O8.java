package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.ads.RewardData;
/* loaded from: assets/audience_network.dex */
public final class O8 extends FrameLayout {
    public static String[] A07 = {"Lu0oG19N", "JNY", "Ev6F9eDhg42RHlCeRuJfEtiFO07AluFn", "qSbaO4FE34QcNqD1YWxCxyT8wr5s9kWw", "hZddA1hSD7Y", "v9TnLSaOxYneacolptRVdRHaZQ0ab06L", "iyW9tyIIQvF7WQz3LOxNHXxa074IcWbN", "vzh"};
    @Nullable
    public MT A00;
    public final AnonymousClass16 A01;
    public final XT A02;
    public final MU A03;
    public final O7 A04;
    @Nullable
    public final C1099Po A05;
    public final View[] A06;

    public O8(ON on, AnonymousClass16 anonymousClass16, @Nullable C1099Po c1099Po, IS is, AbstractC1058Nx abstractC1058Nx, MU mu, O7 o7) {
        this(on, anonymousClass16, c1099Po, mu, o7, is, abstractC1058Nx);
    }

    public O8(ON on, AnonymousClass16 anonymousClass16, @Nullable C1099Po c1099Po, MU mu, O7 o7, View... viewArr) {
        this(on.A05(), on.A08(), anonymousClass16, c1099Po, mu, o7, viewArr);
    }

    public O8(XT xt, @Nullable MT mt, AnonymousClass16 anonymousClass16, @Nullable C1099Po c1099Po, MU mu, O7 o7, View... viewArr) {
        super(xt);
        this.A02 = xt;
        this.A00 = mt;
        this.A01 = anonymousClass16;
        this.A06 = viewArr;
        this.A03 = mu;
        this.A05 = c1099Po;
        this.A04 = o7;
        A03();
    }

    private void A03() {
        String title;
        RewardData A0I = this.A01.A0I();
        if (A0I == null) {
            title = this.A01.A0M().A05();
        } else {
            title = this.A01.A0M().A06(A0I.getCurrency(), A0I.getQuantity());
        }
        C1013Md c1013Md = new C1013Md(this.A02, -1, ViewCompat.MEASURED_STATE_MASK, title, null, this.A01.A0M().A04(), this.A01.A0M().A03(), ME.A01(MD.REWARD_ICON));
        c1013Md.A02.setOnClickListener(new O5(this));
        c1013Md.A01.setOnClickListener(new O6(this));
        addView(c1013Md, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        C1099Po c1099Po = this.A05;
        if (c1099Po != null) {
            c1099Po.A0a(EnumC1090Pf.A07);
        }
        this.A04.A9l();
        if (!this.A01.A0K().A0N()) {
            this.A01.A0b(this.A03);
        }
    }

    public final void A07(ViewGroup viewGroup) {
        View[] viewArr;
        C1099Po c1099Po = this.A05;
        if (c1099Po != null && !c1099Po.A0j()) {
            this.A05.A0f(false, false, 11);
            M5.A0N(this.A05, 4);
        }
        MT mt = this.A00;
        String[] strArr = A07;
        if (strArr[7].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A07[0] = "vGH3jzSu";
        if (mt != null) {
            M5.A0H(mt);
        }
        for (View view : this.A06) {
            view.clearAnimation();
            M5.A0N(view, 4);
        }
        viewGroup.addView(this, new RelativeLayout.LayoutParams(-1, -1));
        this.A04.ABB();
    }
}
