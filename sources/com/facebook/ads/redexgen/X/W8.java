package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class W8 implements CP {
    public static byte[] A0E;
    public static String[] A0F = {"ydp2W5xsf3wxxmCItZRtLRLpaCcQN61V", "ZzeQ67WJ6", "MfxT7BiZm", "QAZkmCdKFAHfN7ilsO4NsWCm7AIOdsAB", "uXA2W", "sq6CLgUZZ", "GhmTF3RrY3ydpwpSZCJZy8aIHeXkOr61", "710SvX7FP4z"};
    public static final CS A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public CR A04;
    public InterfaceC0771Cb A05;
    public W9 A06;
    public Metadata A07;
    public final int A08;
    public final long A09;
    public final CT A0A;
    public final CU A0B;
    public final CV A0C;
    public final IV A0D;

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 28);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0E = new byte[]{117, 82, 90, 83, 97, 87, 83, 64, 81, 90, 87, 86, 18, 70, 93, 93, 18, 95, 83, 92, 75, 18, 80, 75, 70, 87, 65, 28, 0, 20, 4, 31, 11, 58, 61, 52};
    }

    static {
        A05();
        A0G = new WA();
        A0J = C0923Il.A08(A04(32, 4, 79));
        A0H = C0923Il.A08(A04(0, 4, 32));
        A0I = C0923Il.A08(A04(28, 4, 74));
    }

    public W8() {
        this(0);
    }

    public W8(int i2) {
        this(i2, -9223372036854775807L);
    }

    public W8(int i2, long j2) {
        this.A08 = i2;
        this.A09 = j2;
        this.A0D = new IV(10);
        this.A0C = new CV();
        this.A0A = new CT();
        this.A02 = -9223372036854775807L;
        this.A0B = new CU();
    }

    private int A00(CQ cq) throws IOException, InterruptedException {
        if (this.A00 == 0) {
            cq.ADr();
            String[] strArr = A0F;
            if (strArr[1].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[0] = "k6Z5PTGWNQqxWVGEWp2g14fMjsllqw2H";
            strArr2[6] = "hJNgcdrxKvM79jF48EqDHnrsGOClnbxU";
            if (!cq.ACq(this.A0D.A00, 0, 4, true)) {
                return -1;
            }
            this.A0D.A0Y(0);
            int A08 = this.A0D.A08();
            if (!A06(A08, this.A01) || CV.A00(A08) == -1) {
                cq.AEh(1);
                this.A01 = 0;
                return 0;
            }
            CV.A04(A08, this.A0C);
            if (this.A02 == -9223372036854775807L) {
                this.A02 = this.A06.A7X(cq.A79());
                if (this.A09 != -9223372036854775807L) {
                    this.A02 += this.A09 - this.A06.A7X(0L);
                }
            }
            this.A00 = this.A0C.A02;
        }
        int AE3 = this.A05.AE3(cq, this.A00, true);
        if (AE3 == -1) {
            return -1;
        }
        this.A00 -= AE3;
        if (this.A00 > 0) {
            return 0;
        }
        this.A05.AE5(this.A02 + ((this.A03 * 1000000) / this.A0C.A03), 1, this.A0C.A02, 0, null);
        this.A03 += this.A0C.A04;
        this.A00 = 0;
        return 0;
    }

    public static int A01(IV iv, int i2) {
        if (iv.A07() >= i2 + 4) {
            iv.A0Y(i2);
            int A08 = iv.A08();
            if (A08 == A0J || A08 == A0H) {
                return A08;
            }
        }
        if (iv.A07() >= 40) {
            iv.A0Y(36);
            int A082 = iv.A08();
            int i3 = A0I;
            if (A082 == i3) {
                return i3;
            }
            return 0;
        }
        return 0;
    }

    private W9 A02(CQ cq) throws IOException, InterruptedException {
        cq.ACp(this.A0D.A00, 0, 4);
        this.A0D.A0Y(0);
        CV.A04(this.A0D.A08(), this.A0C);
        return new D6(cq.A6p(), cq.A79(), this.A0C);
    }

    private W9 A03(CQ cq) throws IOException, InterruptedException {
        IV iv = new IV(this.A0C.A02);
        cq.ACp(iv.A00, 0, this.A0C.A02);
        int i2 = 21;
        if ((this.A0C.A05 & 1) != 0) {
            if (this.A0C.A01 != 1) {
                i2 = 36;
            }
        } else {
            int seekHeader = this.A0C.A01;
            if (seekHeader == 1) {
                i2 = 13;
            }
        }
        int A01 = A01(iv, i2);
        int seekHeader2 = A0J;
        if (A01 != seekHeader2) {
            int seekHeader3 = A0H;
            if (A01 != seekHeader3) {
                int seekHeader4 = A0I;
                if (A01 == seekHeader4) {
                    D4 A00 = D4.A00(cq.A6p(), cq.A79(), this.A0C, iv);
                    cq.AEh(this.A0C.A02);
                    return A00;
                }
                cq.ADr();
                return null;
            }
        }
        D0 A012 = D0.A01(cq.A6p(), cq.A79(), this.A0C, iv);
        if (A012 != null && !this.A0A.A03()) {
            cq.ADr();
            int seekHeader5 = i2 + 141;
            cq.A3J(seekHeader5);
            cq.ACp(this.A0D.A00, 0, 3);
            this.A0D.A0Y(0);
            CT ct = this.A0A;
            int seekHeader6 = this.A0D.A0G();
            ct.A04(seekHeader6);
        }
        int seekHeader7 = this.A0C.A02;
        cq.AEh(seekHeader7);
        if (A012 == null || A012.A8Y()) {
            return A012;
        }
        int seekHeader8 = A0H;
        if (A01 == seekHeader8) {
            return A02(cq);
        }
        return A012;
    }

    public static boolean A06(int i2, long j2) {
        return ((long) ((-128000) & i2)) == ((-128000) & j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
        if (r15 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        r14.AEh(r5 + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
        r13.A01 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
        r14.ADr();
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x009b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean A07(com.facebook.ads.redexgen.X.CQ r14, boolean r15) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.W8.A07(com.facebook.ads.redexgen.X.CQ, boolean):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void A8A(CR cr) {
        this.A04 = cr;
        this.A05 = this.A04.AF1(0, 1);
        this.A04.A5A();
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final int ADD(CQ cq, CW cw) throws IOException, InterruptedException {
        if (this.A01 == 0) {
            try {
                A07(cq, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.A06 == null) {
            this.A06 = A03(cq);
            W9 w9 = this.A06;
            if (w9 == null || (!w9.A8Y() && (this.A08 & 1) != 0)) {
                W9 A02 = A02(cq);
                String[] strArr = A0F;
                if (strArr[2].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                A0F[3] = "vRoDRHRtSRtNnEEJ64K4r5ogXxosELXw";
                this.A06 = A02;
            }
            this.A04.AEA(this.A06);
            this.A05.A5S(Format.A05(null, this.A0C.A06, null, -1, 4096, this.A0C.A01, this.A0C.A03, -1, this.A0A.A00, this.A0A.A01, null, null, 0, null, (this.A08 & 2) != 0 ? null : this.A07));
        }
        return A00(cq);
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void AE9(long j2, long j3) {
        this.A01 = 0;
        this.A02 = -9223372036854775807L;
        this.A03 = 0L;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final boolean AEj(CQ cq) throws IOException, InterruptedException {
        return A07(cq, true);
    }
}
