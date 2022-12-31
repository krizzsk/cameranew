package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.ac  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1406ac extends C6X implements C6S {
    public C6H A00;
    public final AnonymousClass61 A01;
    public final Map<Integer, C06326h> A02;

    @SuppressLint({"UseSparseArrays"})
    public C1406ac(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A02 = new HashMap();
        this.A01 = anonymousClass61;
    }

    public final void A02(C06326h c06326h) {
        this.A02.put(Integer.valueOf(c06326h.A00()), c06326h);
    }

    public final void A03(EnumC06366l enumC06366l, Context context) {
        this.A00 = C6H.A00(context, this.A01);
        this.A00.A04(this.A02, enumC06366l);
    }

    @Override // com.facebook.ads.redexgen.X.C6S
    public final void ACo() {
        C6H c6h = this.A00;
        if (c6h != null) {
            c6h.A03();
        }
    }
}
