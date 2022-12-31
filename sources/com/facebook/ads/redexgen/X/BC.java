package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class BC implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ long A02;
    public final /* synthetic */ BF A03;

    public BC(BF bf, int i2, long j2, long j3) {
        this.A03 = bf;
        this.A00 = i2;
        this.A01 = j2;
        this.A02 = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BG bg;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            bg = this.A03.A01;
            bg.A9x(this.A00, this.A01, this.A02);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
