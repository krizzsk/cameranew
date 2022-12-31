package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
/* loaded from: assets/audience_network.dex */
public class J3 implements Runnable {
    public final /* synthetic */ Format A00;
    public final /* synthetic */ J8 A01;

    public J3(J8 j8, Format format) {
        this.A01 = j8;
        this.A00 = format;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J9 j9;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            j9 = this.A01.A01;
            j9.ACU(this.A00);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
