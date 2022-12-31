package com.facebook.ads.redexgen.X;

import android.content.pm.PackageInfo;
import android.os.Build;
/* loaded from: assets/audience_network.dex */
public class YX implements InterfaceC06356k {
    public final /* synthetic */ YQ A00;

    public YX(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        PackageInfo packageInfo;
        PackageInfo packageInfo2;
        PackageInfo packageInfo3;
        packageInfo = this.A00.A01;
        if (packageInfo != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                YQ yq = this.A00;
                packageInfo3 = yq.A01;
                return yq.A06(packageInfo3.getLongVersionCode());
            }
            YQ yq2 = this.A00;
            packageInfo2 = yq2.A01;
            return yq2.A04(packageInfo2.versionCode);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
