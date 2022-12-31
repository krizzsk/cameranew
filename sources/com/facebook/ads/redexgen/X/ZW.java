package com.facebook.ads.redexgen.X;

import android.os.Build;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class ZW implements InterfaceC06356k {
    public final /* synthetic */ ZC A00;

    public ZW(ZC zc) {
        this.A00 = zc;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        if (Build.VERSION.SDK_INT < 21) {
            return this.A00.A07(EnumC06466v.A05);
        }
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null) {
            return this.A00.A0E(Arrays.asList(strArr));
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
