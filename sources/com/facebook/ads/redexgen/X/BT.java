package com.facebook.ads.redexgen.X;

import android.media.AudioTrack;
/* loaded from: assets/audience_network.dex */
public class BT extends Thread {
    public final /* synthetic */ AudioTrack A00;
    public final /* synthetic */ C1270Wg A01;

    public BT(C1270Wg c1270Wg, AudioTrack audioTrack) {
        this.A01 = c1270Wg;
        this.A00 = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.release();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
