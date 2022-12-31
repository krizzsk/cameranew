package com.facebook.ads.redexgen.X;

import us.pinguo.paylibcenter.bean.PayResult;
/* renamed from: com.facebook.ads.redexgen.X.2G  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2G extends B3 {
    public final int A00;
    public final int A01;
    public final InterfaceC0898Hm<? super HR> A02;
    public final String A03;
    public final boolean A04;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hm != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.DataSource> */
    public C2G(String str, InterfaceC0898Hm<? super HR> interfaceC0898Hm) {
        this(str, interfaceC0898Hm, PayResult.PAY_RESULT_ALIPAY_CHECK_IN, PayResult.PAY_RESULT_ALIPAY_CHECK_IN, false);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hm != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.DataSource> */
    public C2G(String str, InterfaceC0898Hm<? super HR> interfaceC0898Hm, int i2, int i3, boolean z) {
        this.A03 = str;
        this.A02 = interfaceC0898Hm;
        this.A00 = i2;
        this.A01 = i3;
        this.A04 = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.B3
    /* renamed from: A00 */
    public final B4 A01(C0887Hb c0887Hb) {
        return new B4(this.A03, null, this.A02, this.A00, this.A01, this.A04, c0887Hb);
    }
}
