package com.facebook.ads.redexgen.X;

import java.util.concurrent.BlockingQueue;
/* loaded from: assets/audience_network.dex */
public class XU implements QM {
    public final /* synthetic */ C7E A00;

    public XU(C7E c7e) {
        this.A00 = c7e;
    }

    @Override // com.facebook.ads.redexgen.X.QM
    public final void AAM() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.A00.A00;
            blockingQueue.put(true);
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.facebook.ads.redexgen.X.QM
    public final void AAV() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.A00.A00;
            blockingQueue.put(false);
        } catch (InterruptedException unused) {
        }
    }
}
