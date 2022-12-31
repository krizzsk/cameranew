package com.facebook.ads.redexgen.X;

import android.view.Surface;
/* loaded from: assets/audience_network.dex */
public class J6 implements Runnable {
    public final /* synthetic */ Surface A00;
    public final /* synthetic */ J8 A01;

    public J6(J8 j8, Surface surface) {
        this.A01 = j8;
        this.A00 = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J9 j9;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            j9 = this.A01.A01;
            j9.ABs(this.A00);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
