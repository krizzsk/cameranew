package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class U9 extends AbstractRunnableC0981Kv {
    public static String[] A01 = {"Ghau2wrk1frvp21ETj6mp24XqInrZhWz", "17fIRlTyn5cqQeNpKhzMID", "pR32sk291HY6M3I9Rqv7DOtrmJFLMHGG", "lklFRXjqHO02dLIfiJk5MunT6DW2lX4u", "pu6rG6tzkOYAls8kWhwJFGkhlkg8qDKn", "lnKlSHHeiiV2wTMqAgm3Jfjv4MIuVQTY", "NrilDOC5Woxhobx5Zl8i48KFnKR1bBLL", "sE8NFlpROkCeKIAQdfQPoEsulpgCWNDW"};
    public final /* synthetic */ U7 A00;

    public U9(U7 u7) {
        this.A00 = u7;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        long j2;
        long j3;
        U7.A00(this.A00);
        j2 = this.A00.A01;
        if (j2 > 0) {
            try {
                j3 = this.A00.A01;
                Thread.sleep(j3);
            } catch (InterruptedException unused) {
            }
        }
        this.A00.A0B();
        String[] strArr = A01;
        if (strArr[5].charAt(14) == strArr[6].charAt(14)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[5] = "LjJXLz5e9h3DI08dt7Kr5SwInwXqLWiO";
        strArr2[6] = "Pc0bl4Jkvuydlkjlb12SvYG2JTb7UQAm";
    }
}
