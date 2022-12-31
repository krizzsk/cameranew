package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class J1 implements Runnable {
    public final /* synthetic */ C0754Bj A00;
    public final /* synthetic */ J8 A01;

    public J1(J8 j8, C0754Bj c0754Bj) {
        this.A01 = j8;
        this.A00 = c0754Bj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J9 j9;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            j9 = this.A01.A01;
            j9.ACR(this.A00);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
