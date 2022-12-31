package com.facebook.ads.redexgen.X;

import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class JP {
    public double A00;
    public JV A01;
    public JW A02;
    public String A03;
    public String A04;
    public Map<String, String> A05;
    public boolean A06;

    public final JP A00(double d2) {
        this.A00 = d2;
        return this;
    }

    public final JP A01(JV jv) {
        this.A01 = jv;
        return this;
    }

    public final JP A02(JW jw) {
        this.A02 = jw;
        return this;
    }

    public final JP A03(String str) {
        this.A03 = str;
        return this;
    }

    public final JP A04(String str) {
        this.A04 = str;
        return this;
    }

    public final JP A05(Map<String, String> mData) {
        this.A05 = mData;
        return this;
    }

    public final JP A06(boolean z) {
        this.A06 = z;
        return this;
    }

    public final JQ A07(C8J c8j) {
        return new JQ(c8j, this.A04, this.A00, this.A03, this.A05, this.A01, this.A02, this.A06);
    }
}
