package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class VY implements CP {
    public static String[] A08 = {"", "mExdGVP0maPlz", "mtU4GW9lJGPRgwi7WTtJ47xTDMOD9Jvz", "mnVK2jaR5CYO63Y95SEKprVffrLm5k0s", "WHnhbYArFQVibafDHBFVvoYN0aOa9WUH", "bzekXst0bt0AdcZvIiwJXkkJcIHRgIjU", "gyTL2jV1VgKAzlNybmW", "q"};
    public static final CS A09 = new VZ();
    public long A00;
    public CR A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final SparseArray<C0788Dc> A05;
    public final IV A06;
    public final C0919Ih A07;

    public VY() {
        this(new C0919Ih(0L));
    }

    public VY(C0919Ih c0919Ih) {
        this.A07 = c0919Ih;
        this.A06 = new IV(4096);
        this.A05 = new SparseArray<>();
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void A8A(CR cr) {
        this.A01 = cr;
        cr.AEA(new WN(-9223372036854775807L));
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0133, code lost:
        if (r4 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0135, code lost:
        r10.AEh(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0139, code lost:
        if (r4 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x013c, code lost:
        r9.A06.A0W(r5);
        r10.readFully(r9.A06.A00, 0, r5);
        r9.A06.A0Y(6);
        r4.A03(r9.A06);
        r1 = r9.A06;
        r1.A0X(r1.A05());
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0102  */
    @Override // com.facebook.ads.redexgen.X.CP
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int ADD(com.facebook.ads.redexgen.X.CQ r10, com.facebook.ads.redexgen.X.CW r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.VY.ADD(com.facebook.ads.redexgen.X.CQ, com.facebook.ads.redexgen.X.CW):int");
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void AE9(long j2, long j3) {
        this.A07.A08();
        for (int i2 = 0; i2 < this.A05.size(); i2++) {
            this.A05.valueAt(i2).A02();
        }
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final boolean AEj(CQ cq) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        cq.ACp(bArr, 0, 14);
        if (442 == (((bArr[0] & Draft_75.END_OF_FRAME) << 24) | ((bArr[1] & Draft_75.END_OF_FRAME) << 16) | ((bArr[2] & Draft_75.END_OF_FRAME) << 8) | (bArr[3] & Draft_75.END_OF_FRAME)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            if (A08[7].length() != 3) {
                A08[4] = "dWjhqjXulz1hd3AtKzuGBSPNQhOMyT1H";
                cq.A3J(bArr[13] & 7);
                cq.ACp(bArr, 0, 3);
                return 1 == ((bArr[2] & Draft_75.END_OF_FRAME) | (((bArr[0] & Draft_75.END_OF_FRAME) << 16) | ((bArr[1] & Draft_75.END_OF_FRAME) << 8)));
            }
            throw new RuntimeException();
        }
        return false;
    }
}
