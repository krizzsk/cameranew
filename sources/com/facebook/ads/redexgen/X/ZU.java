package com.facebook.ads.redexgen.X;

import android.os.Build;
/* loaded from: assets/audience_network.dex */
public class ZU implements InterfaceC06356k {
    public final /* synthetic */ ZC A00;

    public ZU(ZC zc) {
        this.A00 = zc;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        return this.A00.A06(Build.TIME / 1000);
    }
}
