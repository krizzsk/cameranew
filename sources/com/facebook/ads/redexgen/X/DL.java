package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public abstract class DL {
    public static String[] A0D = {"vdpx440NSg8M4CnGdydtu5qQkftaFl81", "8FBVTf92WyxNz1PbVx8WfEYVHOwD1jYA", "DKJKTeADHw9YeVFClTVADEpoqL7THNTT", "QMHe7Xu97ps4f3hWTDxnFcitcXlvMrzA", "cT681YGQWd9DutiYQJBSPFEBPfK5r2m4", "EyU4ukvYlXQau4YgIYVQwMEfY7bgqA6h", "DftqlnKuE3jyyUo0DxEITdlkAR2KkpEx", "3J2n16rNLfrexVGozCu5PKnUXiDeYKol"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public CR A06;
    public InterfaceC0771Cb A07;
    public DI A08;
    public DK A09;
    public boolean A0A;
    public boolean A0B;
    public final DG A0C = new DG();

    public abstract long A07(IV iv);

    public abstract boolean A0A(IV iv, long j2, DK dk) throws IOException, InterruptedException;

    private int A00(CQ cq) throws IOException, InterruptedException {
        boolean z = true;
        while (z) {
            if (!this.A0C.A05(cq)) {
                this.A01 = 3;
                return -1;
            }
            this.A03 = cq.A79() - this.A04;
            z = A0A(this.A0C.A02(), this.A04, this.A09);
            if (z) {
                this.A04 = cq.A79();
            }
        }
        this.A00 = this.A09.A00.A0C;
        if (!this.A0A) {
            this.A07.A5S(this.A09.A00);
            this.A0A = true;
        }
        if (this.A09.A01 != null) {
            DK dk = this.A09;
            String[] strArr = A0D;
            if (strArr[3].charAt(31) == strArr[7].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[2] = "bh7MBcJSzFDWGWL7bYV4RFdmzZ5DJPtg";
            strArr2[4] = "jbTTtcEVTbmVVWffnqyGAcPkGPEAibSD";
            this.A08 = dk.A01;
        } else if (cq.A6p() == -1) {
            this.A08 = new C1255Vr();
        } else {
            DH A01 = this.A0C.A01();
            this.A08 = new C1261Vx(this.A04, cq.A6p(), this, A01.A01 + A01.A00, A01.A05);
        }
        this.A09 = null;
        this.A01 = 2;
        this.A0C.A04();
        return 0;
    }

    private int A01(CQ cq, CW cw) throws IOException, InterruptedException {
        long ADE = this.A08.ADE(cq);
        if (ADE >= 0) {
            cw.A00 = ADE;
            return 1;
        }
        if (ADE < -1) {
            A08(-(2 + ADE));
        }
        boolean z = this.A0B;
        if (A0D[1].charAt(31) != 'Q') {
            A0D[6] = "YKdoYyhEaGRVIGwSTWAYioMwjJxRxWbM";
            if (!z) {
                this.A06.AEA(this.A08.A4Q());
                this.A0B = true;
            }
            if (this.A03 <= 0 && !this.A0C.A05(cq)) {
                this.A01 = 3;
                return -1;
            }
            this.A03 = 0L;
            IV A02 = this.A0C.A02();
            long A07 = A07(A02);
            if (A07 >= 0) {
                long j2 = this.A02;
                long granulesInPacket = j2 + A07;
                if (granulesInPacket >= this.A05) {
                    long A03 = A03(j2);
                    this.A07.AE4(A02, A02.A07());
                    this.A07.AE5(A03, 1, A02.A07(), 0, null);
                    this.A05 = -1L;
                }
            }
            long timeUs = this.A02;
            this.A02 = timeUs + A07;
            return 0;
        }
        throw new RuntimeException();
    }

    public final int A02(CQ cq, CW cw) throws IOException, InterruptedException {
        int i2 = this.A01;
        if (i2 != 0) {
            if (i2 == 1) {
                cq.AEh((int) this.A04);
                this.A01 = 2;
                return 0;
            } else if (i2 == 2) {
                int A01 = A01(cq, cw);
                if (A0D[6].charAt(6) != 'm') {
                    A0D[1] = "ecnT7ItXVuTi5H8Gayt4a9jA0qUq5vI3";
                    return A01;
                }
                throw new RuntimeException();
            } else {
                throw new IllegalStateException();
            }
        }
        return A00(cq);
    }

    public final long A03(long j2) {
        return (1000000 * j2) / this.A00;
    }

    public final long A04(long j2) {
        return (this.A00 * j2) / 1000000;
    }

    public final void A05(long j2, long j3) {
        this.A0C.A03();
        if (j2 == 0) {
            A09(!this.A0B);
        } else if (this.A01 == 0) {
        } else {
            this.A05 = this.A08.AEp(j3);
            this.A01 = 2;
        }
    }

    public final void A06(CR cr, InterfaceC0771Cb interfaceC0771Cb) {
        this.A06 = cr;
        this.A07 = interfaceC0771Cb;
        A09(true);
    }

    public void A08(long j2) {
        this.A02 = j2;
    }

    public void A09(boolean z) {
        if (z) {
            this.A09 = new DK();
            this.A04 = 0L;
            this.A01 = 0;
        } else {
            this.A01 = 1;
        }
        this.A05 = -1L;
        this.A02 = 0L;
    }
}
