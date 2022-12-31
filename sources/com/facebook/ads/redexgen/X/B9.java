package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class B9 implements Runnable {
    public final /* synthetic */ BF A00;
    public final /* synthetic */ C0754Bj A01;

    public B9(BF bf, C0754Bj c0754Bj) {
        this.A00 = bf;
        this.A01 = c0754Bj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BG bg;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            bg = this.A00.A01;
            bg.A9u(this.A01);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
