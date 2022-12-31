package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
import android.os.Build;
/* renamed from: com.facebook.ads.redexgen.X.aY  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1402aY implements InterfaceC06356k {
    public final /* synthetic */ C1392aO A00;

    public C1402aY(C1392aO c1392aO) {
        this.A00 = c1392aO;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ActivityManager activityManager;
        ActivityManager activityManager2;
        if (Build.VERSION.SDK_INT >= 23) {
            activityManager = this.A00.A02;
            if (activityManager != null) {
                C1392aO c1392aO = this.A00;
                activityManager2 = c1392aO.A02;
                return c1392aO.A04(activityManager2.getLockTaskModeState());
            }
            return this.A00.A07(EnumC06466v.A07);
        }
        return this.A00.A07(EnumC06466v.A05);
    }
}
