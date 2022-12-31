package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.ab  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1405ab extends C6X {
    public final List<C06326h> A00;

    public C1405ab(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A00 = new ArrayList();
    }

    public final List<C06326h> A02() {
        return Collections.unmodifiableList(this.A00);
    }

    public final void A03(C06326h c06326h) {
        if (c06326h.A03().contains(EnumC06396o.A0B)) {
            this.A00.add(c06326h);
        }
    }

    public final void A04(EnumC06366l enumC06366l) {
        A01(enumC06366l, this.A00);
    }
}
