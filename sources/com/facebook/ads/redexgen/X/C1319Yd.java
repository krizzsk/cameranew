package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.pm.PackageManager;
/* renamed from: com.facebook.ads.redexgen.X.Yd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1319Yd implements InterfaceC06356k {
    public final /* synthetic */ YQ A00;

    public C1319Yd(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        PackageManager packageManager;
        PackageManager packageManager2;
        Context context;
        packageManager = this.A00.A02;
        if (packageManager != null) {
            YQ yq = this.A00;
            packageManager2 = yq.A02;
            context = this.A00.A00;
            return yq.A08(packageManager2.getInstallerPackageName(context.getPackageName()));
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
