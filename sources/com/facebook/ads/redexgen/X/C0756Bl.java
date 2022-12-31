package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Bl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0756Bl extends Thread {
    public final /* synthetic */ WX A00;

    public C0756Bl(WX wx) {
        this.A00 = wx;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A0M();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
