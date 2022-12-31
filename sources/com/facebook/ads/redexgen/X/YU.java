package com.facebook.ads.redexgen.X;

import android.content.pm.PackageInfo;
import android.os.Build;
/* loaded from: assets/audience_network.dex */
public class YU implements InterfaceC06356k {
    public static String[] A01 = {"zJajY9dZZxYFsLRzsvnBiwQWt0HnizLC", "gzFaheVOcPUMbI38nwUIVYmc91b5uR", "ce0KJPPQByTAaQ9ATxZk2kwW24DeaJ9j", "R6Wiv8wmYaZdmPdgU3hXsutSf", "job2ys34errF3to", "kwK9VFGEGX8wPEd", "j3AidPNHk3dBWfN6HPyZ7", "rfM1O6R1RyyEf1DP"};
    public final /* synthetic */ YQ A00;

    public YU(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        PackageInfo packageInfo;
        PackageInfo packageInfo2;
        packageInfo = this.A00.A01;
        if (packageInfo != null && Build.VERSION.SDK_INT >= 22) {
            YQ yq = this.A00;
            if (A01[1].length() != 30) {
                throw new RuntimeException();
            }
            A01[6] = "SsABSdrOWb5CHUfmSefeH";
            packageInfo2 = yq.A01;
            return yq.A04(packageInfo2.baseRevisionCode);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
