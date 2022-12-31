package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.Dl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0797Dl {
    public final int A00;
    public final long A01;

    public C0797Dl(int i2, long j2) {
        this.A00 = i2;
        this.A01 = j2;
    }

    public static C0797Dl A00(CQ cq, IV iv) throws IOException, InterruptedException {
        cq.ACp(iv.A00, 0, 8);
        iv.A0Y(0);
        int id = iv.A08();
        return new C0797Dl(id, iv.A0K());
    }
}
