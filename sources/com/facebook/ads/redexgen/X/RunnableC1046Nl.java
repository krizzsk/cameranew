package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Nl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC1046Nl implements Runnable {
    public final /* synthetic */ C1047Nm A00;
    public final /* synthetic */ InterfaceC1048Nn A01;

    public RunnableC1046Nl(C1047Nm c1047Nm, InterfaceC1048Nn interfaceC1048Nn) {
        this.A00 = c1047Nm;
        this.A01 = interfaceC1048Nn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A01.A9r();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
