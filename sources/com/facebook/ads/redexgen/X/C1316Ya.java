package com.facebook.ads.redexgen.X;

import android.content.pm.PackageManager;
import android.os.Build;
/* renamed from: com.facebook.ads.redexgen.X.Ya  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1316Ya implements InterfaceC06356k {
    public final /* synthetic */ YQ A00;

    public C1316Ya(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        PackageManager packageManager;
        PackageManager packageManager2;
        if (Build.VERSION.SDK_INT >= 26) {
            packageManager = this.A00.A02;
            if (packageManager != null) {
                YQ yq = this.A00;
                packageManager2 = yq.A02;
                return yq.A0F(packageManager2.canRequestPackageInstalls());
            }
            return this.A00.A07(EnumC06466v.A07);
        }
        return this.A00.A07(EnumC06466v.A05);
    }
}
