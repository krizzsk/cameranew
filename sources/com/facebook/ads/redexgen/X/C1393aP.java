package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
/* renamed from: com.facebook.ads.redexgen.X.aP  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1393aP implements InterfaceC06356k {
    public final /* synthetic */ C1392aO A00;

    public C1393aP(C1392aO c1392aO) {
        this.A00 = c1392aO;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ActivityManager activityManager;
        activityManager = this.A00.A02;
        if (activityManager != null) {
            return this.A00.A0F(ActivityManager.isRunningInTestHarness());
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
