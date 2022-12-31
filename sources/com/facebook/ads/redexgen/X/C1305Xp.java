package com.facebook.ads.redexgen.X;

import android.net.TrafficStats;
/* renamed from: com.facebook.ads.redexgen.X.Xp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1305Xp implements InterfaceC06356k {
    public final /* synthetic */ C1303Xn A00;

    public C1305Xp(C1303Xn c1303Xn) {
        this.A00 = c1303Xn;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        return this.A00.A06(AnonymousClass78.A02(TrafficStats.getTotalRxBytes()));
    }
}
