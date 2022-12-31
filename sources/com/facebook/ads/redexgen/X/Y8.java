package com.facebook.ads.redexgen.X;

import android.telephony.TelephonyManager;
/* loaded from: assets/audience_network.dex */
public class Y8 implements InterfaceC06356k {
    public static String[] A01 = {"z8dx8jcAs7HM5esb7c49HgQlCMJUD3t9", "Z27XjLV71jIj1KfRNg7i9pb54cjqos2V", "6E0WXe0HHFnnwQetVOp4LyZJXKm0EhYW", "5n0zxjSh5lrA6YdkKKdKdPto", "m3yiGl3d5h8kg9DGPr7qvl1tLoj9C1EY", "6Zd3QoWt03yEzQBhZFxcVO7q01Uelitn", "t47YK6eEHNb1t1eyBeM4t0RbN9Ph57Vj", "OvhOKFZHGYEQ5NA3UMfcxvSqe0D108CD"};
    public final /* synthetic */ C1312Xw A00;

    public Y8(C1312Xw c1312Xw) {
        this.A00 = c1312Xw;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        TelephonyManager telephonyManager;
        TelephonyManager telephonyManager2;
        telephonyManager = this.A00.A00;
        if (telephonyManager != null) {
            C1312Xw c1312Xw = this.A00;
            if (A01[6].charAt(15) != 'y') {
                throw new RuntimeException();
            }
            A01[6] = "Ct76XBGNMfDXyoQyHbEHQKjczjA9HjKg";
            telephonyManager2 = c1312Xw.A00;
            return c1312Xw.A04(telephonyManager2.getSimState());
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
