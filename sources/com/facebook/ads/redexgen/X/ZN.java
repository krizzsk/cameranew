package com.facebook.ads.redexgen.X;

import android.os.Build;
/* loaded from: assets/audience_network.dex */
public class ZN implements InterfaceC06356k {
    public final /* synthetic */ ZC A00;

    public ZN(ZC zc) {
        this.A00 = zc;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.A00.A07(EnumC06466v.A05);
        }
        return this.A00.A08(Build.VERSION.SECURITY_PATCH);
    }
}
