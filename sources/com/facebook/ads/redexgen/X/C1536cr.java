package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.cr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1536cr extends AbstractRunnableC0981Kv {
    public static byte[] A01;
    public final /* synthetic */ C1535cq A00;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 95);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-20, -29, -8, -29, -11, -27, -12, -21, -14, -10, -68};
    }

    public C1536cr(C1535cq c1535cq) {
        this.A00 = c1535cq;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        XT xt;
        AbstractC1045Nk abstractC1045Nk;
        C1537cs c1537cs;
        xt = this.A00.A02;
        xt.A0D().AFL();
        abstractC1045Nk = this.A00.A04;
        StringBuilder sb = new StringBuilder();
        sb.append(A00(0, 11, 35));
        c1537cs = this.A00.A00;
        sb.append(c1537cs.A03());
        abstractC1045Nk.loadUrl(sb.toString());
    }
}
