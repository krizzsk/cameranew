package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Bs  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0762Bs implements Runnable {
    public final /* synthetic */ C0766Bw A00;
    public final /* synthetic */ InterfaceC0767Bx A01;
    public final /* synthetic */ Exception A02;

    public RunnableC0762Bs(C0766Bw c0766Bw, InterfaceC0767Bx interfaceC0767Bx, Exception exc) {
        this.A00 = c0766Bw;
        this.A01 = interfaceC0767Bx;
        this.A02 = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A01.AAR(this.A02);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
