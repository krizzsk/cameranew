package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class Eu extends C1468bd {
    public final /* synthetic */ C0831Et A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Eu(C0831Et c0831Et, Context context) {
        super(context);
        this.A00 = c0831Et;
    }

    @Override // com.facebook.ads.redexgen.X.C1468bd, com.facebook.ads.redexgen.X.C4Z
    public final void A0I(View view, C05754b c05754b, C4X c4x) {
        C0831Et c0831Et = this.A00;
        int[] A0H = c0831Et.A0H(((AbstractC1454bO) c0831Et).A00.getLayoutManager(), view);
        int i2 = A0H[0];
        int i3 = A0H[1];
        int A0M = A0M(Math.max(Math.abs(i2), Math.abs(i3)));
        if (A0M > 0) {
            c4x.A04(i2, i3, A0M, ((C1468bd) this).A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1468bd
    public final float A0J(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // com.facebook.ads.redexgen.X.C1468bd
    public final int A0L(int i2) {
        return Math.min(100, super.A0L(i2));
    }
}
