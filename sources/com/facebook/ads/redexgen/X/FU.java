package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class FU implements Runnable {
    public final /* synthetic */ FY A00;
    public final /* synthetic */ InterfaceC0837Fb A01;

    public FU(FY fy, InterfaceC0837Fb interfaceC0837Fb) {
        this.A00 = fy;
        this.A01 = interfaceC0837Fb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A01.ABo(this.A00.A00, this.A00.A01);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
