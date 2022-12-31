package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class FW implements Runnable {
    public final /* synthetic */ FY A00;
    public final /* synthetic */ C0836Fa A01;
    public final /* synthetic */ InterfaceC0837Fb A02;

    public FW(FY fy, InterfaceC0837Fb interfaceC0837Fb, C0836Fa c0836Fa) {
        this.A00 = fy;
        this.A02 = interfaceC0837Fb;
        this.A01 = c0836Fa;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A02.AAN(this.A00.A00, this.A00.A01, this.A01);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
