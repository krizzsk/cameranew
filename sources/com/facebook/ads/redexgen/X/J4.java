package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class J4 implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ J8 A02;

    public J4(J8 j8, int i2, long j2) {
        this.A02 = j8;
        this.A00 = i2;
        this.A01 = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J9 j9;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            j9 = this.A02.A01;
            j9.AAS(this.A00, this.A01);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
