package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* loaded from: assets/audience_network.dex */
public class QK implements Runnable {
    public final /* synthetic */ QN A00;

    public QK(QN qn) {
        this.A00 = qn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A08();
            handler = this.A00.A05;
            handler.removeCallbacks(this);
            handler2 = this.A00.A05;
            handler2.postDelayed(this, 250L);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
