package com.facebook.ads.redexgen.X;

import androidx.annotation.RequiresApi;
/* loaded from: assets/audience_network.dex */
public class SX extends AbstractRunnableC0981Kv {
    public final /* synthetic */ O4 A00;

    public SX(O4 o4) {
        this.A00 = o4;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    @RequiresApi(api = 16)
    public final void A06() {
        Runnable runnable;
        int i2;
        this.A00.setPressed(false);
        O4 o4 = this.A00;
        runnable = o4.A08;
        i2 = this.A00.A07;
        o4.postOnAnimationDelayed(runnable, i2);
    }
}
