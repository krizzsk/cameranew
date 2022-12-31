package com.facebook.ads.redexgen.X;

import android.os.Build;
/* loaded from: assets/audience_network.dex */
public class ZX implements InterfaceC06356k {
    public final /* synthetic */ ZC A00;

    public ZX(ZC zc) {
        this.A00 = zc;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        if (Build.VERSION.SDK_INT < 26) {
            return this.A00.A08(Build.SERIAL);
        }
        return this.A00.A08(Build.getSerial());
    }
}
