package com.facebook.ads.redexgen.X;

import android.icu.util.TimeZone;
import android.os.Build;
/* renamed from: com.facebook.ads.redexgen.X.Xu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1310Xu implements InterfaceC06356k {
    public final /* synthetic */ C1308Xs A00;

    public C1310Xu(C1308Xs c1308Xs) {
        this.A00 = c1308Xs;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        if (Build.VERSION.SDK_INT < 24) {
            return this.A00.A07(EnumC06466v.A05);
        }
        return this.A00.A03(TimeZone.getDefault().getRawOffset() / 1000.0f);
    }
}
