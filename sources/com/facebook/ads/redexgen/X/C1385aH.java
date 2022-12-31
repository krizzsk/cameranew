package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.aH  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1385aH implements InterfaceC06356k {
    public final /* synthetic */ C1371a3 A00;

    public C1385aH(C1371a3 c1371a3) {
        this.A00 = c1371a3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() throws Throwable {
        AnonymousClass61 anonymousClass61;
        AnonymousClass74 anonymousClass74;
        anonymousClass61 = this.A00.A02;
        if (anonymousClass61.A0a() != EnumC06396o.A0I) {
            anonymousClass74 = this.A00.A03;
            String A06 = anonymousClass74.A06(10010);
            if (A06 != null) {
                return this.A00.A08(A06);
            }
            return this.A00.A07(EnumC06466v.A07);
        }
        return this.A00.A07(EnumC06466v.A04);
    }
}
