package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ve  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1245Ve implements DV {
    public static byte[] A0E;
    public static String[] A0F = {"a", "PSzfdfjRZC0XN6VxjsgcztfFaZhzgWb7", "1Gl4YGiW2C7ithS", "fAa", "AJgx", "lYVk", "kBtUfz7weItcbZk1MBk54uJpUuqD7Dj9", "de5NTYCoeu4fZv0TXl8jvZIWd"};
    public long A00;
    public long A01;
    public InterfaceC0771Cb A02;
    public C0786Da A03;
    public String A04;
    public boolean A05;
    public final C0790De A0B;
    public final boolean[] A0D = new boolean[3];
    public final C0787Db A0A = new C0787Db(32, 128);
    public final C0787Db A08 = new C0787Db(33, 128);
    public final C0787Db A06 = new C0787Db(34, 128);
    public final C0787Db A07 = new C0787Db(39, 128);
    public final C0787Db A09 = new C0787Db(40, 128);
    public final IV A0C = new IV();

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 87);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0E = new byte[]{-65, -87, -83, -84, -55, -36, -40, -37, -36, -23, -20, 5, -4, 15, 7, -4, -6, 11, -4, -5, -73, -8, 10, 7, -4, -6, 11, -10, 9, -8, 11, 0, 6, -10, 0, -5, -6, -73, Draft_75.CR, -8, 3, 12, -4, -47, -73, 49, 36, 31, 32, 42, -22, 35, 32, 49, 30};
    }

    static {
        A02();
    }

    public C1245Ve(C0790De c0790De) {
        this.A0B = c0790De;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x01d2, code lost:
        if (r6 == 255) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01d4, code lost:
        r1 = r3.A05(16);
        r0 = r3.A05(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01de, code lost:
        if (r1 == 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01e0, code lost:
        if (r0 == 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01e2, code lost:
        r4 = r1 / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0205, code lost:
        if (r6 == 255) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x020b, code lost:
        if (r6 >= com.facebook.ads.redexgen.X.IR.A04.length) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x020d, code lost:
        r4 = com.facebook.ads.redexgen.X.IR.A04[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0212, code lost:
        android.util.Log.w(A01(0, 10, 32), A01(10, 35, 64) + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0243, code lost:
        throw new java.lang.RuntimeException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.ads.internal.exoplayer2.Format A00(java.lang.String r17, com.facebook.ads.redexgen.X.C0787Db r18, com.facebook.ads.redexgen.X.C0787Db r19, com.facebook.ads.redexgen.X.C0787Db r20) {
        /*
            Method dump skipped, instructions count: 586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1245Ve.A00(java.lang.String, com.facebook.ads.redexgen.X.Db, com.facebook.ads.redexgen.X.Db, com.facebook.ads.redexgen.X.Db):com.facebook.ads.internal.exoplayer2.Format");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a9, code lost:
        if (r3.A03() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ab, code lost:
        r5.A02.A5S(A00(r5.A04, r5.A0A, r5.A08, r5.A06));
        r2 = com.facebook.ads.redexgen.X.C1245Ve.A0F;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00cc, code lost:
        if (r2[5].length() == r2[4].length()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00df, code lost:
        if (r3.A03() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e2, code lost:
        com.facebook.ads.redexgen.X.C1245Ve.A0F[1] = "ZjqETcMPlDZxu07sDnjN9sy4wI9cybTG";
        r5.A05 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A03(long r6, int r8, int r9, long r10) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1245Ve.A03(long, int, int, long):void");
    }

    private void A04(long j2, int i2, int i3, long j3) {
        if (this.A05) {
            this.A03.A03(j2, i2, i3, j3);
        } else {
            this.A0A.A01(i3);
            this.A08.A01(i3);
            this.A06.A01(i3);
        }
        this.A07.A01(i3);
        this.A09.A01(i3);
    }

    public static void A05(IW iw) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = 0;
            while (i3 < 6) {
                if (!iw.A0A()) {
                    iw.A04();
                } else {
                    int min = Math.min(64, 1 << ((i2 << 1) + 4));
                    if (i2 > 1) {
                        iw.A03();
                    }
                    for (int i4 = 0; i4 < min; i4++) {
                        iw.A03();
                    }
                }
                int i5 = 3;
                if (i2 != 3) {
                    i5 = 1;
                }
                i3 += i5;
            }
        }
    }

    public static void A06(IW iw) {
        int A04 = iw.A04();
        boolean z = false;
        int stRpsIdx = 0;
        for (int numNegativePics = 0; numNegativePics < A04; numNegativePics++) {
            if (numNegativePics != 0) {
                z = iw.A0A();
            }
            if (z) {
                iw.A06();
                iw.A04();
                for (int i2 = 0; i2 <= stRpsIdx; i2++) {
                    if (iw.A0A()) {
                        iw.A06();
                    }
                }
            } else {
                int numPositivePics = iw.A04();
                int A042 = iw.A04();
                stRpsIdx = numPositivePics + A042;
                for (int i3 = 0; i3 < numPositivePics; i3++) {
                    iw.A04();
                    iw.A06();
                }
                for (int i4 = 0; i4 < A042; i4++) {
                    iw.A04();
                    if (A0F[2].length() != 15) {
                        throw new RuntimeException();
                    }
                    A0F[7] = "29HJBmKLkgSGGX3jFY36NCeZA";
                    iw.A06();
                }
                continue;
            }
        }
    }

    private void A07(byte[] bArr, int i2, int i3) {
        if (this.A05) {
            this.A03.A04(bArr, i2, i3);
        } else {
            this.A0A.A02(bArr, i2, i3);
            this.A08.A02(bArr, i2, i3);
            this.A06.A02(bArr, i2, i3);
        }
        this.A07.A02(bArr, i2, i3);
        this.A09.A02(bArr, i2, i3);
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A46(IV iv) {
        while (iv.A04() > 0) {
            int A06 = iv.A06();
            int A07 = iv.A07();
            byte[] bArr = iv.A00;
            this.A01 += iv.A04();
            this.A02.AE4(iv, iv.A04());
            while (A06 < A07) {
                int A04 = IR.A04(bArr, A06, A07, this.A0D);
                if (A04 == A07) {
                    A07(bArr, A06, A07);
                    return;
                }
                int A00 = IR.A00(bArr, A04);
                int nalUnitType = A04 - A06;
                if (nalUnitType > 0) {
                    A07(bArr, A06, A04);
                }
                int lengthToNalUnit = A07 - A04;
                long j2 = this.A01 - lengthToNalUnit;
                A03(j2, lengthToNalUnit, nalUnitType < 0 ? -nalUnitType : 0, this.A00);
                long absolutePosition = this.A00;
                A04(j2, lengthToNalUnit, A00, absolutePosition);
                A06 = A04 + 3;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A4T(CR cr, C0795Dj c0795Dj) {
        c0795Dj.A05();
        this.A04 = c0795Dj.A04();
        this.A02 = cr.AF1(c0795Dj.A03(), 2);
        this.A03 = new C0786Da(this.A02);
        this.A0B.A03(cr, c0795Dj);
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
        this.A0A.A00();
        this.A08.A00();
        this.A06.A00();
        this.A07.A00();
        this.A09.A00();
        this.A03.A01();
        this.A01 = 0L;
    }
}
