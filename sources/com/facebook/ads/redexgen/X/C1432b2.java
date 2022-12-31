package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAd;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.b2  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1432b2 implements C7B {
    public final List<C1543cy> A00;
    public final /* synthetic */ C1431b1 A01;

    public C1432b2(C1431b1 c1431b1, List<C1543cy> list) {
        this.A01 = c1431b1;
        this.A00 = list;
    }

    private void A00() {
        C5J c5j;
        C5J c5j2;
        C5J c5j3;
        XT xt;
        C5J c5j4;
        C5J c5j5;
        XT xt2;
        c5j = this.A01.A00;
        c5j.A07(true);
        c5j2 = this.A01.A00;
        c5j2.A04();
        c5j3 = this.A01.A00;
        c5j3.A05(0);
        for (C1543cy c1543cy : this.A00) {
            xt = this.A01.A01;
            InterfaceC0952Jq A0I = C1198Tj.A0I();
            c5j4 = this.A01.A00;
            C1198Tj c1198Tj = new C1198Tj(xt, c1543cy, null, A0I, c5j4.A03());
            c5j5 = this.A01.A00;
            xt2 = this.A01.A01;
            c5j5.A06(new NativeAd(xt2, c1198Tj));
        }
        C0973Km.A00(new C1433b3(this));
    }

    @Override // com.facebook.ads.redexgen.X.C7B
    public final void AA5() {
        A00();
    }

    @Override // com.facebook.ads.redexgen.X.C7B
    public final void AAC() {
        A00();
    }
}
