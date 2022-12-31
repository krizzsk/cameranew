package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Ri  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1145Ri implements OY {
    public final /* synthetic */ C1144Rh A00;

    public C1145Ri(C1144Rh c1144Rh) {
        this.A00 = c1144Rh;
    }

    @Override // com.facebook.ads.redexgen.X.OY
    public final void ACV(View view) {
        if (this.A00.A09) {
            this.A00.A07 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.OY
    public final void ACX(View view) {
        SJ sj = (SJ) view;
        sj.A0g();
        if (this.A00.A09) {
            this.A00.A07 = true;
        }
        if (this.A00.A04.A0Z() && ((Integer) sj.getTag(-1593835536)).intValue() == 0) {
            this.A00.A04.A0U();
        }
    }
}
