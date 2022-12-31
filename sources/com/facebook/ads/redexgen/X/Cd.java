package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public abstract class Cd {
    public final InterfaceC0771Cb A00;

    public abstract void A0B(IV iv, long j2) throws AS;

    public abstract boolean A0C(IV iv) throws AS;

    public Cd(InterfaceC0771Cb interfaceC0771Cb) {
        this.A00 = interfaceC0771Cb;
    }

    public final void A00(IV iv, long j2) throws AS {
        if (A0C(iv)) {
            A0B(iv, j2);
        }
    }
}
