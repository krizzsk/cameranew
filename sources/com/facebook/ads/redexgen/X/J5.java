package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class J5 implements Runnable {
    public static String[] A05 = {"DJpTE", "hjmigejYKbOgwmfvV1nc5iE8IDOYmXil", "2YKNaj9Qlm", "qxfanbBXI2ZjoCTgG7w8KuDdJjLlXH62", "XtZaZ3wYkBKmpvCnemS2yQk1T2uyfDPG", "Gw99gcoZxN", "lvDFpJS29mpdODJdSJz5AdBwktpN", "hlGH8f80A3YyARPnHLcSnfRHIOI89tOr"};
    public final /* synthetic */ float A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ int A02;
    public final /* synthetic */ int A03;
    public final /* synthetic */ J8 A04;

    public J5(J8 j8, int i2, int i3, int i4, float f2) {
        this.A04 = j8;
        this.A03 = i2;
        this.A01 = i3;
        this.A02 = i4;
        this.A00 = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        J9 j9;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            j9 = this.A04.A01;
            j9.ACZ(this.A03, this.A01, this.A02, this.A00);
        } catch (Throwable th) {
            if (A05[0].length() != 5) {
                throw new RuntimeException();
            }
            A05[3] = "OXxSdVemaS9DNqMoLNSyLFOeF9oFC1IL";
            C0974Kn.A00(th, this);
        }
    }
}
