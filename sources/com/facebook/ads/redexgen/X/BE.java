package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class BE implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ BF A01;

    public BE(BF bf, int i2) {
        this.A01 = bf;
        this.A00 = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BG bg;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            bg = this.A01.A01;
            bg.A9w(this.A00);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
