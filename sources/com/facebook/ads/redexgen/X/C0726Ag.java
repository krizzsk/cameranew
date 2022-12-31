package com.facebook.ads.redexgen.X;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Ag  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0726Ag extends C1468bd {
    public final /* synthetic */ C0720Aa A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0726Ag(C0720Aa c0720Aa, XT xt) {
        super(xt);
        this.A00 = c0720Aa;
    }

    @Override // com.facebook.ads.redexgen.X.C1468bd
    public final float A0J(DisplayMetrics displayMetrics) {
        float f2;
        f2 = this.A00.A00;
        return f2 / displayMetrics.densityDpi;
    }

    @Override // com.facebook.ads.redexgen.X.C1468bd
    public final int A0K() {
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.C1468bd
    public final int A0O(View view, int left) {
        int i2;
        C4M A08 = A08();
        if (!A08.A24()) {
            return 0;
        }
        C4N c4n = (C4N) view.getLayoutParams();
        int start = A08.A0k(view) - c4n.leftMargin;
        int end = A08.A0n(view) + c4n.rightMargin;
        int A0N = A0N(start, end, A08.A0e(), A08.A0h() - A08.A0f(), left);
        i2 = this.A00.A02;
        return A0N + i2;
    }

    @Override // com.facebook.ads.redexgen.X.C1468bd
    public final PointF A0P(int i2) {
        return this.A00.A43(i2);
    }
}
