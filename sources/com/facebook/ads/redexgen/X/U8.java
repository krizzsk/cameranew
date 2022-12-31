package com.facebook.ads.redexgen.X;

import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: assets/audience_network.dex */
public class U8 extends AbstractRunnableC0981Kv {
    public final /* synthetic */ U7 A00;

    public U8(U7 u7) {
        this.A00 = u7;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        ThreadPoolExecutor threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2;
        Runnable runnable;
        this.A00.A0C = false;
        threadPoolExecutor = this.A00.A0B;
        if (threadPoolExecutor.getQueue().isEmpty()) {
            threadPoolExecutor2 = this.A00.A0B;
            runnable = this.A00.A0A;
            threadPoolExecutor2.execute(runnable);
        }
    }
}
