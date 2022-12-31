package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.4j  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05834j {
    public C05804g A00 = new C05804g();
    public final InterfaceC05814h A01;

    public C05834j(InterfaceC05814h interfaceC05814h) {
        this.A01 = interfaceC05814h;
    }

    public final View A00(int end, int next, int i2, int i3) {
        int childStart = this.A01.A72();
        int A71 = this.A01.A71();
        int i4 = next > end ? 1 : -1;
        View view = null;
        while (end != next) {
            View A5v = this.A01.A5v(end);
            this.A00.A03(childStart, A71, this.A01.A5y(A5v), this.A01.A5x(A5v));
            if (i2 != 0) {
                this.A00.A01();
                this.A00.A02(i2);
                if (this.A00.A04()) {
                    return A5v;
                }
            }
            if (i3 != 0) {
                this.A00.A01();
                this.A00.A02(i3);
                if (this.A00.A04()) {
                    view = A5v;
                }
            }
            end += i4;
        }
        return view;
    }
}
