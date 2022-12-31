package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
/* loaded from: assets/audience_network.dex */
public class BB implements Runnable {
    public final /* synthetic */ Format A00;
    public final /* synthetic */ BF A01;

    public BB(BF bf, Format format) {
        this.A01 = bf;
        this.A00 = format;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BG bg;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            bg = this.A01.A01;
            bg.A9v(this.A00);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
