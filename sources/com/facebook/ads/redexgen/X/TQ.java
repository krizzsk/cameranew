package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* loaded from: assets/audience_network.dex */
public class TQ extends AbstractRunnableC0981Kv {
    public final /* synthetic */ LS A00;

    public TQ(LS ls) {
        this.A00 = ls;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        Handler handler;
        if (this.A00.A05()) {
            this.A00.A01();
            handler = this.A00.A03;
            handler.postDelayed(this, 250L);
        }
    }
}
