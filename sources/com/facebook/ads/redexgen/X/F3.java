package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import java.util.EnumSet;
/* loaded from: assets/audience_network.dex */
public final class F3 extends AbstractC1500cG {
    public static String[] A02 = {"Wdifh5HSN4RyvogFUrIVqQJQULlKdEei", "S34yOHPbjBOZXrhEKXqsFwPvtnd1qciy", "vu9eRI", "x0OqZ", "VYF0eZRg0jpnLcLhIoRoBnoO3djZf6SI", "33GTCt01Ki3rQT8tpwoWMPFpMqFvVQrj", "pa13jV0ykdfTm6Oo414mEZE7qu5xzGka", "tj8XsVszyFe6dIsjKXzcwTwgC3z6jHVp"};
    @VisibleForTesting
    public static final InterfaceC05211y A03 = new C1492c6();
    @Nullable
    public C1496cB A00;
    public final C05201x A01;

    public F3(C05201x c05201x) {
        super(c05201x.A05(), A03.A4L(c05201x));
        this.A01 = c05201x;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1500cG
    public final void A05() {
        C1496cB c1496cB = this.A00;
        if (c1496cB != null) {
            c1496cB.A0C();
        }
        InterfaceC05171u interfaceC05171u = super.A00;
        EnumC05161t enumC05161t = EnumC05161t.A04;
        if (A02[1].charAt(8) == 'f') {
            throw new RuntimeException();
        }
        A02[4] = "bjBCaQy28rNQq0pISHtZZouKJ3cbndZJ";
        interfaceC05171u.AEJ(enumC05161t);
    }

    public final C1496cB A07() {
        return this.A00;
    }

    public final void A08() {
        this.A00 = new C1496cB(this.A01, this, this.A02);
        this.A00.A0F(this.A01.A0A(), this.A01.A06());
    }

    public final void A09(InterstitialAd interstitialAd, EnumSet<CacheFlag> enumSet, @Nullable String str) {
        if (super.A00.A5H()) {
            return;
        }
        this.A01.A0C(interstitialAd);
        C1496cB c1496cB = this.A00;
        if (c1496cB != null) {
            c1496cB.A0F(enumSet, str);
            return;
        }
        this.A01.A0J(enumSet);
        this.A01.A0G(str);
        A08();
    }

    public final boolean A0A() {
        C1496cB c1496cB = this.A00;
        if (c1496cB != null) {
            return c1496cB.A0G();
        }
        if (this.A01.A00() > 0) {
            int i2 = (C1008Ly.A00() > this.A01.A00() ? 1 : (C1008Ly.A00() == this.A01.A00() ? 0 : -1));
            if (A02[0].charAt(6) == 'y') {
                throw new RuntimeException();
            }
            A02[4] = "spPOKGUnJm6foAMMjUQWH3rPbfiGZlB3";
            if (i2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0B() {
        C1496cB c1496cB = this.A00;
        if (c1496cB != null) {
            return c1496cB.A0H();
        }
        return super.A00.A5a() == EnumC05161t.A06;
    }

    public final boolean A0C(InterstitialAd interstitialAd, InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig) {
        if (super.A00.A5I()) {
            return false;
        }
        this.A01.A0C(interstitialAd);
        C1496cB c1496cB = this.A00;
        if (c1496cB != null) {
            return c1496cB.A0I();
        }
        this.A00 = new C1496cB(this.A01, this, this.A02);
        this.A00.A0I();
        return false;
    }
}
