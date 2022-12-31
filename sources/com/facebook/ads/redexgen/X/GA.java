package com.facebook.ads.redexgen.X;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: assets/audience_network.dex */
public class GA implements InterfaceC1117Qg {
    public final /* synthetic */ C05503c A00;
    public final /* synthetic */ CountDownLatch A01;
    public final /* synthetic */ AtomicReference A02;
    public final /* synthetic */ AtomicReference A03;

    public GA(C05503c c05503c, AtomicReference atomicReference, AtomicReference atomicReference2, CountDownLatch countDownLatch) {
        this.A00 = c05503c;
        this.A03 = atomicReference;
        this.A02 = atomicReference2;
        this.A01 = countDownLatch;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1117Qg
    public final void AAA(InterfaceC1115Qe interfaceC1115Qe) {
        C05503c.A06(interfaceC1115Qe.A5m(), this.A03, this.A02);
        this.A01.countDown();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1117Qg
    public final void AAX(Exception exc) {
        this.A02.set(exc);
        this.A01.countDown();
    }
}
