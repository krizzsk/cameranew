package com.facebook.ads.redexgen.X;

import android.os.SystemClock;
/* loaded from: assets/audience_network.dex */
public class YE implements InterfaceC06356k {
    public final /* synthetic */ YD A00;

    public YE(YD yd) {
        this.A00 = yd;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        return this.A00.A03(((float) SystemClock.uptimeMillis()) / 1000.0f);
    }
}
