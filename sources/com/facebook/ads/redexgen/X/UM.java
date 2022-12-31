package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class UM implements HQ {
    public final int A00;
    @Nullable
    public final HO A01;
    public final HQ A02;
    public final HQ A03;
    public final InterfaceC0902Hq A04;
    @Nullable
    public final InterfaceC0904Hs A05;

    public UM(InterfaceC0902Hq interfaceC0902Hq, HQ hq, HQ hq2, HO ho, int i2, InterfaceC0904Hs interfaceC0904Hs) {
        this.A04 = interfaceC0902Hq;
        this.A03 = hq;
        this.A02 = hq2;
        this.A01 = ho;
        this.A00 = i2;
        this.A05 = interfaceC0904Hs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.HQ
    /* renamed from: A00 */
    public final UN A4C() {
        InterfaceC0902Hq interfaceC0902Hq = this.A04;
        HR A4C = this.A03.A4C();
        HR A4C2 = this.A02.A4C();
        HO ho = this.A01;
        return new UN(interfaceC0902Hq, A4C, A4C2, ho != null ? ho.createDataSink() : null, this.A00, this.A05);
    }
}
