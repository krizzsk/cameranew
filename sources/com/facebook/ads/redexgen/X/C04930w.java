package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.0w  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04930w extends C2F implements InterfaceC0951Jp {
    public A1 A00;
    @Nullable
    public List<PE> A01;

    public C04930w(XT xt) {
        super(xt);
        this.A00 = new A1(this, 1, null, null, null);
    }

    public final void A22(QZ qz) {
        A1 a1 = this.A00;
        if (a1 != null) {
            a1.A0d(qz);
        }
    }

    public A1 getCarouselCardBehaviorHelper() {
        return this.A00;
    }

    public void setCardsInfo(ArrayList arrayList) {
        this.A01 = arrayList;
        this.A00.A0e(this.A01);
    }
}
