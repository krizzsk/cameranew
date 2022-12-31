package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.bW  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1461bW implements InterfaceC05814h {
    public final /* synthetic */ C4M A00;

    public C1461bW(C4M c4m) {
        this.A00 = c4m;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05814h
    public final View A5v(int i2) {
        return this.A00.A0t(i2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05814h
    public final int A5x(View view) {
        return this.A00.A0n(view) + ((C4N) view.getLayoutParams()).rightMargin;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05814h
    public final int A5y(View view) {
        return this.A00.A0k(view) - ((C4N) view.getLayoutParams()).leftMargin;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05814h
    public final int A71() {
        return this.A00.A0h() - this.A00.A0f();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05814h
    public final int A72() {
        return this.A00.A0e();
    }
}
