package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* renamed from: com.facebook.ads.redexgen.X.7d  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C06547d extends KO {
    public final /* synthetic */ JX A00;

    public C06547d(JX jx) {
        this.A00 = jx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9P
    /* renamed from: A00 */
    public final void A03(KP kp) {
        C1099Po c1099Po;
        Handler handler;
        c1099Po = this.A00.A01;
        if (c1099Po == null || kp.A00().getAction() != 0) {
            return;
        }
        handler = this.A00.A04;
        handler.removeCallbacksAndMessages(null);
        this.A00.A07(new C1105Pu(this));
    }
}
