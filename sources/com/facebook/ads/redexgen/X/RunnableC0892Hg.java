package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Hg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class RunnableC0892Hg implements Runnable {
    public final InterfaceC0891Hf A00;

    public RunnableC0892Hg(InterfaceC0891Hf interfaceC0891Hf) {
        this.A00 = interfaceC0891Hf;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.AB7();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
