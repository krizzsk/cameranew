package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.PowerManager;
/* loaded from: assets/audience_network.dex */
public class YP implements InterfaceC06356k {
    public final /* synthetic */ YM A00;

    public YP(YM ym) {
        this.A00 = ym;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        PowerManager powerManager;
        boolean A04;
        powerManager = this.A00.A00;
        if (powerManager != null && Build.VERSION.SDK_INT >= 7) {
            YM ym = this.A00;
            A04 = ym.A04();
            return ym.A0F(A04);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
