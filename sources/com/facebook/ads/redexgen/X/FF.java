package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class FF implements Runnable {
    public final /* synthetic */ C0755Bk A00;

    public FF(C0755Bk c0755Bk) {
        this.A00 = c0755Bk;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A09();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
