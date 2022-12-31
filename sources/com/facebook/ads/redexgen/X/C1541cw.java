package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.cw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1541cw implements C5U {
    public final /* synthetic */ FB A00;
    public final /* synthetic */ boolean A01;

    public C1541cw(FB fb, boolean z) {
        this.A00 = fb;
        this.A01 = z;
    }

    @Override // com.facebook.ads.redexgen.X.C5U
    public final void A9p() {
        XT xt;
        AtomicBoolean atomicBoolean;
        AnonymousClass12 anonymousClass12;
        XT xt2;
        AnonymousClass16 anonymousClass16;
        xt = this.A00.A04;
        if (!JD.A19(xt) || !this.A01) {
            atomicBoolean = this.A00.A0D;
            atomicBoolean.set(true);
            anonymousClass12 = this.A00.A01;
            anonymousClass12.ABx(this.A00);
            return;
        }
        FB fb = this.A00;
        xt2 = fb.A04;
        anonymousClass16 = this.A00.A03;
        fb.A07 = C1073Oo.A01(xt2, (C1524cf) anonymousClass16, 0, new C1542cx(this));
    }

    @Override // com.facebook.ads.redexgen.X.C5U
    public final void A9q() {
        AnonymousClass12 anonymousClass12;
        anonymousClass12 = this.A00.A01;
        anonymousClass12.AC0(this.A00, AdError.CACHE_ERROR);
    }
}
