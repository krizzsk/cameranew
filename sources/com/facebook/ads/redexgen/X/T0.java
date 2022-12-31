package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public class T0 implements MS {
    public static String[] A01 = {"h2gmCgzeOSwPpQadyubORmPME", "FUsicmE", "hn4NyL1W4e9kqLwlHKvUfsHZQMREJpya", "eHNPFabCzKzaRImgdDwbhByrCj67ZmIn", "6elmdBIgNV", "KYWsfvA8UKVAEYMYl", "OScpkLbA9Akq1WCCJj9B2P18mljyrRf1", "CLPqh0UltEqIAscKXF8yE5GQF7q0sxf27"};
    public final /* synthetic */ C1185Sw A00;

    public T0(C1185Sw c1185Sw) {
        this.A00 = c1185Sw;
    }

    @Override // com.facebook.ads.redexgen.X.MS
    public final void AA8() {
        boolean A0Z;
        boolean z;
        C0937Jb c0937Jb;
        MU mu;
        InterfaceC1031Mw interfaceC1031Mw;
        AtomicBoolean atomicBoolean;
        boolean A0Y;
        AtomicBoolean atomicBoolean2;
        O8 o8;
        A0Z = this.A00.A0Z();
        if (A0Z) {
            C1185Sw c1185Sw = this.A00;
            if (A01[5].length() != 17) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "BQfapZ2cL00AEaaE3FSFtmiC2NvNVd8B";
            strArr[7] = "2Eilcj8Fw7KGtRQsL0qtkyDrsBY20NGQL";
            atomicBoolean2 = c1185Sw.A0Q;
            if (!atomicBoolean2.get()) {
                o8 = this.A00.A0O;
                o8.A07(this.A00);
                return;
            }
        }
        z = this.A00.A0S;
        if (z) {
            atomicBoolean = this.A00.A0Q;
            boolean z2 = atomicBoolean.get();
            String[] strArr2 = A01;
            if (strArr2[1].length() == strArr2[4].length()) {
                throw new RuntimeException();
            }
            A01[5] = "H8RzDb7PgK43jKvxQ";
            if (!z2) {
                A0Y = this.A00.A0Y();
                if (A0Y) {
                    this.A00.A0V.setToolbarActionMode(0);
                    C1185Sw c1185Sw2 = this.A00;
                    String[] strArr3 = A01;
                    if (strArr3[1].length() != strArr3[4].length()) {
                        A01[3] = "HnGIws8hCrqNeUOcBeXjDBOXn0GrcMNy";
                        c1185Sw2.A0M();
                        return;
                    }
                    c1185Sw2.A0M();
                    return;
                }
            }
        }
        c0937Jb = this.A00.A0I;
        c0937Jb.A02(EnumC0936Ja.A07, null);
        mu = this.A00.A0L;
        interfaceC1031Mw = this.A00.A0M;
        mu.A3q(interfaceC1031Mw.A6Q());
    }
}
