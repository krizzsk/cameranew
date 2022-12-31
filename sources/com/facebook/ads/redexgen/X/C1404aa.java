package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.aa  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1404aa extends C6X {
    public final List<C06326h> A00;

    public C1404aa(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A00 = new ArrayList();
    }

    public final void A02(C06326h c06326h) {
        if (!c06326h.A03().contains(EnumC06396o.A0B)) {
            this.A00.add(c06326h);
        }
    }

    public final void A03(EnumC06366l enumC06366l) {
        A01(enumC06366l, this.A00);
    }
}
