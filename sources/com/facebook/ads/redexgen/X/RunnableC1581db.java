package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* renamed from: com.facebook.ads.redexgen.X.db  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC1581db implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1580da A01;

    public RunnableC1581db(C1580da c1580da, int i2) {
        this.A01 = c1580da;
        this.A00 = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        InterfaceC1150Rn interfaceC1150Rn;
        Handler handler;
        Runnable runnable;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            z = this.A01.A01;
            if (z) {
                C1580da c1580da = this.A01;
                interfaceC1150Rn = this.A01.A05;
                c1580da.A06(interfaceC1150Rn.A9Y());
                handler = this.A01.A04;
                runnable = this.A01.A09;
                handler.postDelayed(runnable, this.A00);
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
