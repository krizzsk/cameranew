package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* renamed from: com.facebook.ads.redexgen.X.Sc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1165Sc extends AbstractRunnableC0981Kv {
    public final /* synthetic */ C1053Ns A00;

    public C1165Sc(C1053Ns c1053Ns) {
        this.A00 = c1053Ns;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        boolean z;
        Handler handler;
        Runnable runnable;
        this.A00.A03();
        z = this.A00.A08;
        if (z) {
            handler = this.A00.A0D;
            runnable = this.A00.A0F;
            handler.postDelayed(runnable, 250L);
        }
    }
}
