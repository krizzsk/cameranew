package com.facebook.ads.redexgen.X;

import androidx.annotation.RequiresApi;
/* loaded from: assets/audience_network.dex */
public class SY extends AbstractRunnableC0981Kv {
    public final /* synthetic */ O4 A00;

    public SY(O4 o4) {
        this.A00 = o4;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    @RequiresApi(api = 16)
    public final void A06() {
        Runnable runnable;
        int i2;
        if (this.A00.isPressed()) {
            O4 o4 = this.A00;
            i2 = o4.A07;
            o4.postDelayed(this, i2);
            return;
        }
        this.A00.setPressed(true);
        O4 o42 = this.A00;
        runnable = o42.A09;
        o42.postOnAnimationDelayed(runnable, 250L);
    }
}
