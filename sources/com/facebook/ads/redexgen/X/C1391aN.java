package com.facebook.ads.redexgen.X;

import android.content.pm.ApplicationInfo;
/* renamed from: com.facebook.ads.redexgen.X.aN  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1391aN implements InterfaceC06356k {
    public static String[] A01 = {"273FKnw5fEMMMPHYpDWr2uCxLH", "MURfYE", "2MrWxfjycJYz8CRz8nVEoUtgAppiNGkb", "dgs6GO1Bgwq7bEpFzLz1V7Vq3FkVRsxg", "uUhMN1Ac0a0MVvdzsNpT9rjxKSsemVru", "HLxj17LMU0ZLExoNf0E99eYx3QTlHuEl", "3ccBwYNuPT2bbHKd70up9vlieZX79PEX", "FpcSlILO2LyEt0C9jtDQqRZtHAa4Q2N9"};
    public final /* synthetic */ C1371a3 A00;

    public C1391aN(C1371a3 c1371a3) {
        this.A00 = c1371a3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        applicationInfo = this.A00.A01;
        if (applicationInfo != null) {
            C1371a3 c1371a3 = this.A00;
            applicationInfo2 = c1371a3.A01;
            if (A01[1].length() != 3) {
                A01[3] = "Yec9tINwCXE8zEgRYPM9thJfbPEs0Pqz";
                return c1371a3.A08(applicationInfo2.taskAffinity);
            }
            throw new RuntimeException();
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
