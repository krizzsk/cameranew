package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.PowerManager;
/* loaded from: assets/audience_network.dex */
public class YN implements InterfaceC06356k {
    public final /* synthetic */ YM A00;

    public YN(YM ym) {
        this.A00 = ym;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        PowerManager powerManager;
        PowerManager powerManager2;
        if (Build.VERSION.SDK_INT >= 21) {
            powerManager = this.A00.A00;
            if (powerManager != null) {
                YM ym = this.A00;
                powerManager2 = ym.A00;
                return ym.A0F(powerManager2.isPowerSaveMode());
            }
            return this.A00.A07(EnumC06466v.A07);
        }
        return this.A00.A07(EnumC06466v.A05);
    }
}
