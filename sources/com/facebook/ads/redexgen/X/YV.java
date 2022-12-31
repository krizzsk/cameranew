package com.facebook.ads.redexgen.X;

import android.content.pm.PackageInfo;
/* loaded from: assets/audience_network.dex */
public class YV implements InterfaceC06356k {
    public final /* synthetic */ YQ A00;

    public YV(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        PackageInfo packageInfo;
        PackageInfo packageInfo2;
        packageInfo = this.A00.A01;
        if (packageInfo != null) {
            YQ yq = this.A00;
            packageInfo2 = yq.A01;
            return yq.A08(packageInfo2.packageName);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
