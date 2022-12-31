package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Wi  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1272Wi implements BU {
    public final C1266Wc A00 = new C1266Wc();
    public final C1265Wb A01 = new C1265Wb();
    public final B8[] A02;

    public C1272Wi(B8... b8Arr) {
        this.A02 = (B8[]) Arrays.copyOf(b8Arr, b8Arr.length + 2);
        B8[] b8Arr2 = this.A02;
        b8Arr2[b8Arr.length] = this.A00;
        b8Arr2[b8Arr.length + 1] = this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.BU
    public final AU A3O(AU au) {
        this.A00.A0B(au.A02);
        return new AU(this.A01.A01(au.A01), this.A01.A00(au.A00), au.A02);
    }

    @Override // com.facebook.ads.redexgen.X.BU
    public final B8[] A5i() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.BU
    public final long A6t(long j2) {
        return this.A01.A02(j2);
    }

    @Override // com.facebook.ads.redexgen.X.BU
    public final long A7P() {
        return this.A00.A0A();
    }
}
