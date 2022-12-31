package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.bq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1480bq implements InterfaceC05332l {
    public final Rect A00 = new Rect();
    public final /* synthetic */ C3F A01;

    public C1480bq(C3F c3f) {
        this.A01 = c3f;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05332l
    public final C3I A9o(View view, C3I c3i) {
        C3I A06 = AnonymousClass31.A06(view, c3i);
        if (A06.A07()) {
            return A06;
        }
        Rect rect = this.A00;
        rect.left = A06.A03();
        rect.top = A06.A05();
        rect.right = A06.A04();
        rect.bottom = A06.A02();
        int childCount = this.A01.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            C3I A05 = AnonymousClass31.A05(this.A01.getChildAt(i2), A06);
            rect.left = Math.min(A05.A03(), rect.left);
            rect.top = Math.min(A05.A05(), rect.top);
            rect.right = Math.min(A05.A04(), rect.right);
            rect.bottom = Math.min(A05.A02(), rect.bottom);
        }
        return A06.A06(rect.left, rect.top, rect.right, rect.bottom);
    }
}
