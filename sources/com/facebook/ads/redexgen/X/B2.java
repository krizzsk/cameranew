package com.facebook.ads.redexgen.X;

import java.util.Comparator;
import java.util.TreeSet;
/* loaded from: assets/audience_network.dex */
public final class B2 implements UL, Comparator<C0906Hu> {
    public static String[] A03 = {"qrCZDebBZXOMsu5PI8FdamZv", "usPTrKdLrE7MLvxS6mJMRwkls4hZpcPz", "BDrpv9J1bckqz2zbQbGMwvdv", "cHdTuf55w1r5Lcr9n47avjSAGBdp9rLc", "v1mI", "NFtkBlX9Mz", "lz", "jBDMosIM65rjrOuIbY8WA7ZUxyDm84U3"};
    public long A00;
    public final long A01;
    public final TreeSet<C0906Hu> A02 = new TreeSet<>(this);

    public B2(long j2) {
        this.A01 = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* renamed from: A00 */
    public final int compare(C0906Hu c0906Hu, C0906Hu c0906Hu2) {
        if (c0906Hu.A00 - c0906Hu2.A00 == 0) {
            return c0906Hu.compareTo(c0906Hu2);
        }
        return c0906Hu.A00 < c0906Hu2.A00 ? -1 : 1;
    }

    private void A01(InterfaceC0902Hq interfaceC0902Hq, long j2) {
        while (this.A00 + j2 > this.A01) {
            boolean isEmpty = this.A02.isEmpty();
            if (A03[4].length() == 25) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "3qXh8T5e4LOlD1IWJEc6SNWF";
            strArr[2] = "YJzC3pPkQPrTmiUzc4g95RWz";
            if (!isEmpty) {
                try {
                    interfaceC0902Hq.ADd(this.A02.first());
                } catch (C0900Ho unused) {
                }
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0901Hp
    public final void AC7(InterfaceC0902Hq interfaceC0902Hq, C0906Hu c0906Hu) {
        this.A02.add(c0906Hu);
        this.A00 += c0906Hu.A01;
        A01(interfaceC0902Hq, 0L);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0901Hp
    public final void AC8(InterfaceC0902Hq interfaceC0902Hq, C0906Hu c0906Hu) {
        this.A02.remove(c0906Hu);
        this.A00 -= c0906Hu.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0901Hp
    public final void AC9(InterfaceC0902Hq interfaceC0902Hq, C0906Hu c0906Hu, C0906Hu c0906Hu2) {
        AC8(interfaceC0902Hq, c0906Hu);
        AC7(interfaceC0902Hq, c0906Hu2);
    }

    @Override // com.facebook.ads.redexgen.X.UL
    public final void ACA(InterfaceC0902Hq interfaceC0902Hq, String str, long j2, long j3) {
        A01(interfaceC0902Hq, j3);
    }
}
