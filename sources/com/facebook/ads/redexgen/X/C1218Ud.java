package com.facebook.ads.redexgen.X;

import android.content.Context;
/* renamed from: com.facebook.ads.redexgen.X.Ud  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1218Ud implements HQ {
    public final Context A00;
    public final HQ A01;
    public final InterfaceC0898Hm<? super HR> A02;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hm != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.DataSource> */
    public C1218Ud(Context context, InterfaceC0898Hm<? super HR> interfaceC0898Hm, HQ hq) {
        this.A00 = context.getApplicationContext();
        this.A02 = interfaceC0898Hm;
        this.A01 = hq;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hm != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.DataSource> */
    public C1218Ud(Context context, String str, InterfaceC0898Hm<? super HR> interfaceC0898Hm) {
        this(context, interfaceC0898Hm, new C2G(str, interfaceC0898Hm));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.HQ
    /* renamed from: A00 */
    public final C1219Ue A4C() {
        return new C1219Ue(this.A00, this.A02, this.A01.A4C());
    }
}
