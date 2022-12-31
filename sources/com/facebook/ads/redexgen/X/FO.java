package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class FO implements Runnable {
    public static String[] A02 = {"WoRssMEMKAHHv5eOYWv6bcyCNlOXOf", "pA2", "3fT7OOiQOTO0YPgLHZKt2Q997Hb2Xix9", "WvgPUzUWGb7Do3xsV3", "Ec3vTQmgAcMNirmUvkhwoL1JefVS29Et", "cLkVqjW9ihOrHUtkcRLXNZqcrrO72e", "NZCcSFELY0AlwKVNvcWKAmZ3Ywu7Rk3n", "YvU"};
    public final /* synthetic */ FY A00;
    public final /* synthetic */ InterfaceC0837Fb A01;

    public FO(FY fy, InterfaceC0837Fb interfaceC0837Fb) {
        this.A00 = fy;
        this.A01 = interfaceC0837Fb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A01.ABF(this.A00.A00, this.A00.A01);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            if (A02[4].charAt(31) != 't') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[7] = "YLN";
            strArr[1] = "t0z";
        }
    }
}
