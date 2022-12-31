package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Dc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0788Dc {
    public int A00;
    public long A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final DV A05;
    public final IU A06 = new IU(new byte[64]);
    public final C0919Ih A07;

    public C0788Dc(DV dv, C0919Ih c0919Ih) {
        this.A05 = dv;
        this.A07 = c0919Ih;
    }

    private void A00() {
        this.A06.A08(8);
        this.A03 = this.A06.A0F();
        this.A02 = this.A06.A0F();
        this.A06.A08(6);
        this.A00 = this.A06.A04(8);
    }

    private void A01() {
        this.A01 = 0L;
        if (this.A03) {
            this.A06.A08(4);
            this.A06.A08(1);
            this.A06.A08(1);
            long A04 = (this.A06.A04(3) << 30) | (this.A06.A04(15) << 15) | this.A06.A04(15);
            this.A06.A08(1);
            if (!this.A04 && this.A02) {
                this.A06.A08(4);
                this.A06.A08(1);
                this.A06.A08(1);
                this.A06.A08(1);
                this.A07.A07((this.A06.A04(3) << 30) | (this.A06.A04(15) << 15) | this.A06.A04(15));
                this.A04 = true;
            }
            long pts = this.A07.A07(A04);
            this.A01 = pts;
        }
    }

    public final void A02() {
        this.A04 = false;
        this.A05.AE8();
    }

    public final void A03(IV iv) throws AS {
        iv.A0c(this.A06.A00, 0, 3);
        this.A06.A07(0);
        A00();
        iv.A0c(this.A06.A00, 0, this.A00);
        this.A06.A07(0);
        A01();
        this.A05.ACm(this.A01, true);
        this.A05.A46(iv);
        this.A05.ACl();
    }
}
