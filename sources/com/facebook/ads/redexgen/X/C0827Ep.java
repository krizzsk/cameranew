package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Ep  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0827Ep extends C1468bd {
    public final /* synthetic */ AbstractC1454bO A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0827Ep(AbstractC1454bO abstractC1454bO, Context context) {
        super(context);
        this.A00 = abstractC1454bO;
    }

    @Override // com.facebook.ads.redexgen.X.C1468bd, com.facebook.ads.redexgen.X.C4Z
    public final void A0I(View view, C05754b c05754b, C4X c4x) {
        AbstractC1454bO abstractC1454bO = this.A00;
        int[] A0H = abstractC1454bO.A0H(abstractC1454bO.A00.getLayoutManager(), view);
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
}
