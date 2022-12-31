package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
/* loaded from: assets/audience_network.dex */
public class VU implements InterfaceC0789Dd {
    public final IU A00 = new IU(new byte[4]);
    public final /* synthetic */ VS A01;

    public VU(VS vs) {
        this.A01 = vs;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0789Dd
    public final void A46(IV iv) {
        int i2;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (iv.A0E() != 0) {
            return;
        }
        iv.A0Z(7);
        int A04 = iv.A04() / 4;
        for (int i3 = 0; i3 < A04; i3++) {
            iv.A0a(this.A00, 4);
            int A042 = this.A00.A04(16);
            this.A00.A08(3);
            if (A042 == 0) {
                this.A00.A08(13);
            } else {
                int A043 = this.A00.A04(13);
                sparseArray2 = this.A01.A06;
                sparseArray2.put(A043, new VX(new VT(this.A01, A043)));
                VS.A01(this.A01);
            }
        }
        i2 = this.A01.A05;
        if (i2 != 2) {
            sparseArray = this.A01.A06;
            sparseArray.remove(0);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0789Dd
    public final void A8C(C0919Ih c0919Ih, CR cr, C0795Dj c0795Dj) {
    }
}
