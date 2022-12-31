package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class J2 implements Runnable {
    public final /* synthetic */ long A00;
    public final /* synthetic */ long A01;
    public final /* synthetic */ J8 A02;
    public final /* synthetic */ String A03;

    public J2(J8 j8, String str, long j2, long j3) {
        this.A02 = j8;
        this.A03 = str;
        this.A01 = j2;
        this.A00 = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J9 j9;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            j9 = this.A02.A01;
            j9.ACP(this.A03, this.A01, this.A00);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
