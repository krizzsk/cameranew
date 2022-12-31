package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class UZ implements HQ {
    public final InterfaceC0898Hm<? super C1215Ua> A00;

    public UZ() {
        this(null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hm != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.FileDataSource> */
    public UZ(InterfaceC0898Hm<? super C1215Ua> interfaceC0898Hm) {
        this.A00 = interfaceC0898Hm;
    }

    @Override // com.facebook.ads.redexgen.X.HQ
    public final HR A4C() {
        return new C1215Ua(this.A00);
    }
}
