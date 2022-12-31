package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* renamed from: com.facebook.ads.redexgen.X.Ps  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1103Ps extends AbstractRunnableC0981Kv {
    public final /* synthetic */ C1099Po A00;

    public C1103Ps(C1099Po c1099Po) {
        this.A00 = c1099Po;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        boolean z;
        C9O c9o;
        Handler handler;
        int i2;
        z = this.A00.A03;
        if (!z) {
            c9o = this.A00.A0A;
            final int currentPositionInMillis = this.A00.getCurrentPositionInMillis();
            c9o.A02(new AbstractC1019Mj(currentPositionInMillis) { // from class: com.facebook.ads.redexgen.X.7t
            });
            handler = this.A00.A06;
            i2 = this.A00.A00;
            handler.postDelayed(this, i2);
        }
    }
}
