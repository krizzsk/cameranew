package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class BA implements Runnable {
    public final /* synthetic */ long A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ BF A02;
    public final /* synthetic */ String A03;

    public BA(BF bf, String str, long j2, long j3) {
        this.A02 = bf;
        this.A03 = str;
        this.A01 = j2;
        this.A00 = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BG bg;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            bg = this.A02.A01;
            bg.A9s(this.A03, this.A01, this.A00);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
