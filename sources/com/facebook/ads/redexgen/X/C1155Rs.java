package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Rs  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1155Rs extends AbstractRunnableC0981Kv {
    public final /* synthetic */ C06838p A00;

    public C1155Rs(C06838p c06838p) {
        this.A00 = c06838p;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        OJ oj;
        int closeButtonStyle;
        AtomicBoolean atomicBoolean;
        OJ oj2;
        oj = this.A00.A00;
        if (oj != null) {
            oj2 = this.A00.A00;
            oj2.A0Z();
        }
        MT mt = this.A00.A07;
        closeButtonStyle = this.A00.getCloseButtonStyle();
        mt.setToolbarActionMode(closeButtonStyle);
        atomicBoolean = this.A00.A05;
        atomicBoolean.set(true);
    }
}
