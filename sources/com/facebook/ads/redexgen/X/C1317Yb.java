package com.facebook.ads.redexgen.X;

import android.content.pm.PackageManager;
import android.os.Build;
/* renamed from: com.facebook.ads.redexgen.X.Yb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1317Yb implements InterfaceC06356k {
    public static String[] A01 = {"eOUuWViEzFdpoMILAqmgKfGD", "kQ8zGky5wq3o9AT", "ncGQnuO4sM8XFQVxbr6Mt1Vf36DFujo3", "a4nYvm2BizGaG1Ug1SxTpBLIw0WxQ6vz", "jAlZY9MHNrHTDDv2DRP1sCieuZx8QBhv", "RCRcS7R4oQOTyLjlpIEX5API7Ni0gnf1", "stcG16G11KY1ooFu5mTwbs8KzP9kRkND", "k7goAJY4JhsqFIUQ56a5dCg3eq5QWQcp"};
    public final /* synthetic */ YQ A00;

    public C1317Yb(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        PackageManager packageManager;
        PackageManager packageManager2;
        PackageManager packageManager3;
        PackageManager packageManager4;
        if (Build.VERSION.SDK_INT >= 26) {
            packageManager = this.A00.A02;
            if (packageManager != null) {
                packageManager2 = this.A00.A02;
                if (packageManager2.getPackageInstaller() != null) {
                    packageManager3 = this.A00.A02;
                    if (packageManager3.getPackageInstaller().getSessionInfo(0) != null) {
                        YQ yq = this.A00;
                        packageManager4 = yq.A02;
                        return yq.A04(packageManager4.getPackageInstaller().getSessionInfo(0).getInstallReason());
                    }
                }
            }
            YQ yq2 = this.A00;
            EnumC06466v enumC06466v = EnumC06466v.A07;
            if (A01[4].charAt(16) != 'D') {
                throw new RuntimeException();
            }
            A01[4] = "aumDgxyAyTkwYeibDzhpdrzSDvCJmfPb";
            return yq2.A07(enumC06466v);
        }
        return this.A00.A07(EnumC06466v.A05);
    }
}
