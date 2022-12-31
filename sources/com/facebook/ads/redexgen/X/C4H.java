package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.4H  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C4H {
    public int A00;
    public int A01;
    public int A02;
    public int A03;

    private final C4H A00(AbstractC05784e abstractC05784e, int i2) {
        View view = abstractC05784e.A0H;
        this.A01 = view.getLeft();
        this.A03 = view.getTop();
        this.A02 = view.getRight();
        this.A00 = view.getBottom();
        return this;
    }

    public final C4H A01(AbstractC05784e abstractC05784e) {
        return A00(abstractC05784e, 0);
    }
}
