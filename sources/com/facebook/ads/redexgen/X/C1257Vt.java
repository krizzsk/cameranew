package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Vt  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1257Vt implements CP {
    public static byte[] A03;
    public static final CS A04;
    public CR A00;
    public DL A01;
    public boolean A02;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 114);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{95, 120, 112, 117, 124, 125, 57, 109, 118, 57, 125, 124, 109, 124, 107, 116, 112, 119, 124, 57, 123, 112, 109, 106, 109, 107, 124, 120, 116, 57, 109, 96, 105, 124};
    }

    static {
        A02();
        A04 = new C1258Vu();
    }

    public static IV A00(IV iv) {
        iv.A0Y(0);
        return iv;
    }

    private boolean A03(CQ cq) throws IOException, InterruptedException {
        DH dh = new DH();
        if (dh.A03(cq, true) && (dh.A04 & 2) == 2) {
            int length = Math.min(dh.A00, 8);
            IV iv = new IV(length);
            cq.ACp(iv.A00, 0, length);
            IV scratch = A00(iv);
            if (C1259Vv.A04(scratch)) {
                this.A01 = new C1259Vv();
            } else {
                IV scratch2 = A00(iv);
                if (C1254Vq.A06(scratch2)) {
                    this.A01 = new C1254Vq();
                } else {
                    IV scratch3 = A00(iv);
                    if (!C1256Vs.A04(scratch3)) {
                        return false;
                    }
                    this.A01 = new C1256Vs();
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void A8A(CR cr) {
        this.A00 = cr;
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final int ADD(CQ cq, CW cw) throws IOException, InterruptedException {
        if (this.A01 == null) {
            if (A03(cq)) {
                cq.ADr();
            } else {
                throw new AS(A01(0, 34, 107));
            }
        }
        if (!this.A02) {
            InterfaceC0771Cb AF1 = this.A00.AF1(0, 1);
            this.A00.A5A();
            this.A01.A06(this.A00, AF1);
            this.A02 = true;
        }
        return this.A01.A02(cq, cw);
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void AE9(long j2, long j3) {
        DL dl = this.A01;
        if (dl != null) {
            dl.A05(j2, j3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final boolean AEj(CQ cq) throws IOException, InterruptedException {
        try {
            return A03(cq);
        } catch (AS unused) {
            return false;
        }
    }
}
