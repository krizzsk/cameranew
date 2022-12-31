package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
/* renamed from: com.facebook.ads.redexgen.X.aR  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1395aR implements InterfaceC06356k {
    public final /* synthetic */ C1392aO A00;

    public C1395aR(C1392aO c1392aO) {
        this.A00 = c1392aO;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo2;
        runningAppProcessInfo = this.A00.A01;
        if (runningAppProcessInfo != null) {
            C1392aO c1392aO = this.A00;
            runningAppProcessInfo2 = c1392aO.A01;
            return c1392aO.A04(runningAppProcessInfo2.importance);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
