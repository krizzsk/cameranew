package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Pq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1101Pq extends AbstractRunnableC0981Kv {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C1099Po A02;

    public C1101Pq(C1099Po c1099Po, int i2, int i3) {
        this.A02 = c1099Po;
        this.A00 = i2;
        this.A01 = i3;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        C9O c9o;
        c9o = this.A02.A0A;
        c9o.A02(new C0966Ke(this.A00, this.A01));
    }
}
