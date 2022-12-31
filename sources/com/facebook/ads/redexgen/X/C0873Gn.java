package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Gn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0873Gn implements RF {
    @Override // com.facebook.ads.redexgen.X.RF
    public final long A4d() {
        return System.nanoTime();
    }

    @Override // com.facebook.ads.redexgen.X.RF
    public final void AEi(Object obj, long j2) throws InterruptedException {
        obj.wait(j2);
    }
}
