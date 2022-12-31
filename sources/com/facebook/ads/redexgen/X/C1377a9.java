package com.facebook.ads.redexgen.X;

import android.content.pm.ApplicationInfo;
/* renamed from: com.facebook.ads.redexgen.X.a9  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1377a9 implements InterfaceC06356k {
    public final /* synthetic */ C1371a3 A00;

    public C1377a9(C1371a3 c1371a3) {
        this.A00 = c1371a3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        applicationInfo = this.A00.A01;
        if (applicationInfo != null) {
            C1371a3 c1371a3 = this.A00;
            applicationInfo2 = c1371a3.A01;
            return c1371a3.A08(applicationInfo2.dataDir);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
