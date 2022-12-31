package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class VQ implements CP {
    public static byte[] A05;
    public static String[] A06 = {"TnN98hFrpPh0PRtpc088aNdcZccscvrw", "5aRpZ2NNsZI5w0o7DGq1eAqNryB", "mEVhsrU6MzIr1qyqOlGiN", "yrEmV4s21h7BLFfB7siMTKTjJQry3", "EfBKzRp", "ss80CflBP4AmUjPde3BocO42m8Tqd1M1", "kqV6vinpOYrD", "3vWKjffhrtNYzin5lJ6IQFsZaR1xXQhq"};
    public static final CS A07;
    public int A00;
    public int A01;
    public CR A02;
    public InterfaceC0771Cb A03;
    public VP A04;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 72);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{100, 95, 66, 68, 65, 65, 94, 67, 69, 84, 85, 17, 94, 67, 17, 68, 95, 67, 84, 82, 94, 86, 95, 88, 75, 84, 85, 17, 70, 80, 71, 17, 89, 84, 80, 85, 84, 67, 31, 107, Byte.MAX_VALUE, 110, 99, 101, 37, 120, 107, 125};
    }

    static {
        A01();
        A07 = new VR();
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void A8A(CR cr) {
        this.A02 = cr;
        this.A03 = cr.AF1(0, 1);
        this.A04 = null;
        cr.A5A();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a9, code lost:
        if (r6 != (-1)) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00ab, code lost:
        r18.A01 += r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b0, code lost:
        r8 = r18.A01 / r18.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b5, code lost:
        if (r8 <= 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b7, code lost:
        r9 = r18.A04.A05(r19.A79() - r18.A01);
        r12 = r18.A00 * r8;
        r18.A01 -= r12;
        r18.A03.AE5(r9, 1, r12, r18.A01, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00d6, code lost:
        if (r6 != r5) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d8, code lost:
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00d9, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e0, code lost:
        if (r6 != (-1)) goto L20;
     */
    @Override // com.facebook.ads.redexgen.X.CP
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int ADD(com.facebook.ads.redexgen.X.CQ r19, com.facebook.ads.redexgen.X.CW r20) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.VQ.ADD(com.facebook.ads.redexgen.X.CQ, com.facebook.ads.redexgen.X.CW):int");
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void AE9(long j2, long j3) {
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final boolean AEj(CQ cq) throws IOException, InterruptedException {
        return C0798Dm.A00(cq) != null;
    }
}
