package com.facebook.ads.redexgen.X;

import android.content.pm.PackageManager;
/* renamed from: com.facebook.ads.redexgen.X.Yc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1318Yc implements InterfaceC06356k {
    public final /* synthetic */ YQ A00;

    public C1318Yc(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        PackageManager packageManager;
        PackageManager packageManager2;
        packageManager = this.A00.A02;
        if (packageManager != null) {
            YQ yq = this.A00;
            packageManager2 = yq.A02;
            return yq.A0F(packageManager2.isSafeMode());
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
