package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class CU {
    public final IV A00 = new IV(10);

    @Nullable
    public final Metadata A00(CQ cq, @Nullable EF ef) throws IOException, InterruptedException {
        int i2 = 0;
        Metadata metadata = null;
        while (true) {
            try {
                cq.ACp(this.A00.A00, 0, 10);
                this.A00.A0Y(0);
                if (this.A00.A0G() != VH.A03) {
                    break;
                }
                this.A00.A0Z(3);
                int A0D = this.A00.A0D();
                int i3 = A0D + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i3];
                    byte[] id3Data = this.A00.A00;
                    System.arraycopy(id3Data, 0, bArr, 0, 10);
                    cq.ACp(bArr, 10, A0D);
                    metadata = new VH(ef).A0O(bArr, i3);
                } else {
                    cq.A3J(A0D);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        cq.ADr();
        cq.A3J(i2);
        return metadata;
    }
}
