package com.facebook.ads.redexgen.X;

import android.telephony.TelephonyManager;
/* loaded from: assets/audience_network.dex */
public class Y3 implements InterfaceC06356k {
    public final /* synthetic */ C1312Xw A00;

    public Y3(C1312Xw c1312Xw) {
        this.A00 = c1312Xw;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        TelephonyManager telephonyManager;
        TelephonyManager telephonyManager2;
        telephonyManager = this.A00.A00;
        if (telephonyManager != null) {
            C1312Xw c1312Xw = this.A00;
            telephonyManager2 = c1312Xw.A00;
            return c1312Xw.A04(telephonyManager2.getPhoneType());
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
