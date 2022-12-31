package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.cu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1539cu implements C5U {
    public final /* synthetic */ FB A00;

    public C1539cu(FB fb) {
        this.A00 = fb;
    }

    @Override // com.facebook.ads.redexgen.X.C5U
    public final void A9p() {
        AtomicBoolean atomicBoolean;
        AnonymousClass12 anonymousClass12;
        atomicBoolean = this.A00.A0D;
        atomicBoolean.set(true);
        anonymousClass12 = this.A00.A01;
        anonymousClass12.ABx(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.C5U
    public final void A9q() {
        AnonymousClass12 anonymousClass12;
        anonymousClass12 = this.A00.A01;
        anonymousClass12.AC0(this.A00, AdError.CACHE_ERROR);
    }
}
