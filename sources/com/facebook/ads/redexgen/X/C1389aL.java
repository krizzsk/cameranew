package com.facebook.ads.redexgen.X;

import android.content.pm.ApplicationInfo;
import android.os.Build;
/* renamed from: com.facebook.ads.redexgen.X.aL  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1389aL implements InterfaceC06356k {
    public final /* synthetic */ C1371a3 A00;

    public C1389aL(C1371a3 c1371a3) {
        this.A00 = c1371a3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        if (Build.VERSION.SDK_INT >= 26) {
            applicationInfo = this.A00.A01;
            if (applicationInfo != null) {
                C1371a3 c1371a3 = this.A00;
                applicationInfo2 = c1371a3.A01;
                return c1371a3.A04(applicationInfo2.category);
            }
            return this.A00.A07(EnumC06466v.A07);
        }
        return this.A00.A07(EnumC06466v.A05);
    }
}
