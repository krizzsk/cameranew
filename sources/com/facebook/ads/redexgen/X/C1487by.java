package com.facebook.ads.redexgen.X;

import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.by  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1487by extends C2W<K, V> {
    public final /* synthetic */ C1486bx A00;

    public C1487by(C1486bx c1486bx) {
        this.A00 = c1486bx;
    }

    @Override // com.facebook.ads.redexgen.X.C2W
    public final int A04() {
        return ((C2Z) this.A00).A00;
    }

    @Override // com.facebook.ads.redexgen.X.C2W
    public final int A05(Object obj) {
        return this.A00.A08(obj);
    }

    @Override // com.facebook.ads.redexgen.X.C2W
    public final int A06(Object obj) {
        return this.A00.A07(obj);
    }

    @Override // com.facebook.ads.redexgen.X.C2W
    public final Object A07(int i2, int i3) {
        return this.A00.A02[(i2 << 1) + i3];
    }

    @Override // com.facebook.ads.redexgen.X.C2W
    public final V A08(int i2, V v) {
        V value = this.A00.A0C(i2, v);
        return value;
    }

    @Override // com.facebook.ads.redexgen.X.C2W
    public final Map<K, V> A0A() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.C2W
    public final void A0D() {
        this.A00.clear();
    }

    @Override // com.facebook.ads.redexgen.X.C2W
    public final void A0E(int i2) {
        this.A00.A0A(i2);
    }

    @Override // com.facebook.ads.redexgen.X.C2W
    public final void A0F(K k2, V v) {
        this.A00.put(k2, v);
    }
}
