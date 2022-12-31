package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.bV  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1460bV implements InterfaceC05814h {
    public final /* synthetic */ C4M A00;

    public C1460bV(C4M c4m) {
        this.A00 = c4m;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05814h
    public final View A5v(int i2) {
        return this.A00.A0t(i2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05814h
    public final int A5x(View view) {
        return this.A00.A0j(view) + ((C4N) view.getLayoutParams()).bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05814h
    public final int A5y(View view) {
        return this.A00.A0o(view) - ((C4N) view.getLayoutParams()).topMargin;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05814h
    public final int A71() {
        return this.A00.A0X() - this.A00.A0d();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05814h
    public final int A72() {
        return this.A00.A0g();
    }
}
