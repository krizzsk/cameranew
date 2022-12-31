package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class FG implements Runnable {
    public final /* synthetic */ C0755Bk A00;

    public FG(C0755Bk c0755Bk) {
        this.A00 = c0755Bk;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        V4 v4;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            z = this.A00.A0G;
            if (!z) {
                v4 = this.A00.A08;
                v4.AAD(this.A00);
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
