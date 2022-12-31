package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class WP implements InterfaceC0771Cb {
    @Override // com.facebook.ads.redexgen.X.InterfaceC0771Cb
    public final void A5S(Format format) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0771Cb
    public final int AE3(CQ cq, int i2, boolean z) throws IOException, InterruptedException {
        int AEe = cq.AEe(i2);
        if (AEe == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        return AEe;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0771Cb
    public final void AE4(IV iv, int i2) {
        iv.A0Z(i2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0771Cb
    public final void AE5(long j2, int i2, int i3, int i4, C0770Ca c0770Ca) {
    }
}
