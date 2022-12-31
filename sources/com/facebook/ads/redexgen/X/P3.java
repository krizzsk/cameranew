package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class P3 {
    @Nullable
    public String A02;
    @Nullable
    public String A03;
    public final C1G A04;
    public final C1S A05;
    public final XT A06;
    public C1I A01 = C1I.A01(null);
    public int A00 = 1000;

    public P3(XT xt, C1G c1g, C1S c1s) {
        this.A06 = xt;
        this.A04 = c1g;
        this.A05 = c1s;
    }

    public static /* synthetic */ int A00(P3 p3) {
        return p3.A00;
    }

    public static /* synthetic */ C1G A01(P3 p3) {
        return p3.A04;
    }

    public static /* synthetic */ C1I A02(P3 p3) {
        return p3.A01;
    }

    public static /* synthetic */ C1S A03(P3 p3) {
        return p3.A05;
    }

    public static /* synthetic */ XT A04(P3 p3) {
        return p3.A06;
    }

    public static /* synthetic */ String A05(P3 p3) {
        return p3.A03;
    }

    public static /* synthetic */ String A06(P3 p3) {
        return p3.A02;
    }

    public final P3 A07(int i2) {
        this.A00 = i2;
        return this;
    }

    public final P3 A08(C1I c1i) {
        this.A01 = c1i;
        return this;
    }

    public final P3 A09(String str) {
        this.A02 = str;
        return this;
    }

    public final P3 A0A(String str) {
        this.A03 = str;
        return this;
    }

    public final P5 A0B() {
        return new P5(this, null);
    }
}
