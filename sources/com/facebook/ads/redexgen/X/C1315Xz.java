package com.facebook.ads.redexgen.X;

import android.telephony.TelephonyManager;
/* renamed from: com.facebook.ads.redexgen.X.Xz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1315Xz implements InterfaceC06356k {
    public final /* synthetic */ C1312Xw A00;

    public C1315Xz(C1312Xw c1312Xw) {
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
            return c1312Xw.A08(telephonyManager2.getSimOperator());
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
