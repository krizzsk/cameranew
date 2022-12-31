package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class Vf implements DV {
    public static byte[] A0E;
    public static String[] A0F = {"OaAtDjibDffMS", "aj2yyuicdEn8dhTDbWTrD1WtuleVGPEx", "a3NvGU2CXdpQvxvcysdReyA6yUgKGJjf", "4BBSavRiCGZis8TiCNo6nDJqjRzxnCkr", "3Isw3BGBXoN1VbjlJcagr5xDVNXHwLpI", "HfhncQp7sGaDAl", "zNtUp", "pzzsrx2QpEHePoyNV"};
    public long A00;
    public long A01;
    public InterfaceC0771Cb A02;
    public DZ A03;
    public String A04;
    public boolean A05;
    public final C0790De A09;
    public final boolean A0B;
    public final boolean A0C;
    public final boolean[] A0D = new boolean[3];
    public final C0787Db A08 = new C0787Db(7, 128);
    public final C0787Db A06 = new C0787Db(8, 128);
    public final C0787Db A07 = new C0787Db(6, 128);
    public final IV A0A = new IV();

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 52);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0E = new byte[]{37, 58, 55, 54, 60, 124, 50, 37, 48};
    }

    static {
        A01();
    }

    public Vf(C0790De c0790De, boolean z, boolean z2) {
        this.A09 = c0790De;
        this.A0B = z;
        this.A0C = z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0175, code lost:
        if (r4.A03() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0177, code lost:
        r24.A03.A04(com.facebook.ads.redexgen.X.IR.A05(r24.A06.A01, 3, r24.A06.A00));
        r24.A06.A00();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x019f, code lost:
        if (r4.A03() != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A02(long r25, int r27, int r28, long r29) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Vf.A02(long, int, int, long):void");
    }

    private void A03(long j2, int i2, long j3) {
        if (!this.A05 || this.A03.A07()) {
            this.A08.A01(i2);
            this.A06.A01(i2);
        }
        this.A07.A01(i2);
        String[] strArr = A0F;
        if (strArr[4].charAt(8) != strArr[2].charAt(8)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0F;
        strArr2[5] = "7DOfm1dA88ob89";
        strArr2[0] = "yqrgSqZS2XcB9";
        this.A03.A03(j2, i2, j3);
    }

    private void A04(byte[] bArr, int i2, int i3) {
        if (!this.A05 || this.A03.A07()) {
            this.A08.A02(bArr, i2, i3);
            this.A06.A02(bArr, i2, i3);
        }
        this.A07.A02(bArr, i2, i3);
        this.A03.A06(bArr, i2, i3);
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A46(IV iv) {
        int A06 = iv.A06();
        int A07 = iv.A07();
        byte[] bArr = iv.A00;
        this.A01 += iv.A04();
        this.A02.AE4(iv, iv.A04());
        while (true) {
            int A04 = IR.A04(bArr, A06, A07, this.A0D);
            if (A04 == A07) {
                A04(bArr, A06, A07);
                return;
            }
            int A01 = IR.A01(bArr, A04);
            int nalUnitOffset = A04 - A06;
            if (nalUnitOffset > 0) {
                A04(bArr, A06, A04);
            }
            int i2 = A07 - A04;
            long j2 = this.A01 - i2;
            int offset = nalUnitOffset < 0 ? -nalUnitOffset : 0;
            A02(j2, i2, offset, this.A00);
            A03(j2, A01, this.A00);
            A06 = A04 + 3;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A4T(CR cr, C0795Dj c0795Dj) {
        c0795Dj.A05();
        this.A04 = c0795Dj.A04();
        this.A02 = cr.AF1(c0795Dj.A03(), 2);
        this.A03 = new DZ(this.A02, this.A0B, this.A0C);
        this.A09.A03(cr, c0795Dj);
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACl() {
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACm(long j2, boolean z) {
        this.A00 = j2;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void AE8() {
        IR.A0B(this.A0D);
        this.A08.A00();
        this.A06.A00();
        this.A07.A00();
        this.A03.A01();
        this.A01 = 0L;
    }
}
