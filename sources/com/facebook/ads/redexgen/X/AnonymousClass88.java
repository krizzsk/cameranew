package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
/* renamed from: com.facebook.ads.redexgen.X.88  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass88 extends M3 {
    public final /* synthetic */ AnonymousClass87 A00;

    public AnonymousClass88(AnonymousClass87 anonymousClass87) {
        this.A00 = anonymousClass87;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9P
    /* renamed from: A00 */
    public final void A03(C1017Mh c1017Mh) {
        new Handler(Looper.getMainLooper()).post(new P6(this));
    }
}
