package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class HW implements Runnable {
    public final /* synthetic */ int A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ long A02;
    public final /* synthetic */ C1220Uf A03;

    public HW(C1220Uf c1220Uf, int i2, long j2, long j3) {
        this.A03 = c1220Uf;
        this.A00 = i2;
        this.A02 = j2;
        this.A01 = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HL hl;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            hl = this.A03.A07;
            hl.A9z(this.A00, this.A02, this.A01);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
