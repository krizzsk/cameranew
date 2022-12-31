package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Eh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0819Eh implements Runnable {
    public final /* synthetic */ RunnableC0822Ek A00;

    public RunnableC0819Eh(RunnableC0822Ek runnableC0822Ek) {
        this.A00 = runnableC0822Ek;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A0F(5, 3);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
