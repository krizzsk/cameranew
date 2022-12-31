package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class AP {
    public static byte[] A0F;
    public static String[] A0G = {"veEP335vIU", "oLB3f1kinZ5WOxb9JrKF9bI12rnC7Hj4", "JTOn230cVZ0r3ImY4sjYKOAnliXJWsYG", "qI3jAuZXuqqi9ieUnmB3HYz1RRsZ6ptY", "FV6PRsoISyO05pqLoteca44", "2aqdzlIyDZTOMtMqQXI", "yc78GsDKEqwKVvSYIw58zbgjS6oh7wuT", "vKvp49qN2fZ5TwJRBPfaEcKl4xZFQEWJ"};
    public long A00;
    public AP A01;
    public AQ A02;
    public TrackGroupArray A03;
    public HH A04;
    public boolean A05;
    public boolean A06;
    public HH A07;
    public final V3 A08;
    public final Object A09;
    public final InterfaceC0844Fi[] A0A;
    public final boolean[] A0B;
    public final FN A0C;
    public final HG A0D;
    public final InterfaceC0727Ah[] A0E;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 105);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0F = new byte[]{42, 66, 65, 70, 62, 45, 66, 79, 70, 76, 65, 37, 76, 73, 65, 66, 79, 50, 71, 84, 75, 81, 70, 2, 84, 71, 78, 71, 67, 85, 71, 2, 72, 67, 75, 78, 71, 70, 16};
    }

    static {
        A01();
    }

    public AP(InterfaceC0727Ah[] interfaceC0727AhArr, long j2, HG hg, HJ hj, FN fn, Object obj, AQ aq) {
        this.A0E = interfaceC0727AhArr;
        this.A00 = j2 - aq.A03;
        this.A0D = hg;
        this.A0C = fn;
        this.A09 = I6.A01(obj);
        this.A02 = aq;
        this.A0A = new InterfaceC0844Fi[interfaceC0727AhArr.length];
        this.A0B = new boolean[interfaceC0727AhArr.length];
        V3 A4O = fn.A4O(aq.A04, hj);
        this.A08 = aq.A02 != Long.MIN_VALUE ? new C0757Bm(A4O, true, 0L, aq.A02) : A4O;
    }

    private void A02(HH hh) {
        int i2 = 0;
        while (true) {
            int i3 = hh.A00;
            String[] strArr = A0G;
            if (strArr[1].charAt(21) != strArr[6].charAt(21)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[2] = "zTmDI2eB0pskJnfpVdGiT2gSjaG941UO";
            strArr2[3] = "GwIuNKKr0Vh704cWvV3fzSTRpdmwONBr";
            if (i2 < i3) {
                boolean A00 = hh.A00(i2);
                HD A002 = hh.A01.A00(i2);
                if (A00 && A002 != null) {
                    A002.A56();
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void A03(HH hh) {
        HH hh2 = this.A07;
        this.A07 = hh;
        HH hh3 = this.A07;
        if (hh3 != null) {
            A02(hh3);
        }
    }

    private void A04(InterfaceC0844Fi[] interfaceC0844FiArr) {
        int i2 = 0;
        while (true) {
            InterfaceC0727Ah[] interfaceC0727AhArr = this.A0E;
            if (i2 < interfaceC0727AhArr.length) {
                if (interfaceC0727AhArr[i2].A7b() == 5 && this.A04.A00(i2)) {
                    interfaceC0844FiArr[i2] = new V8();
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void A05(InterfaceC0844Fi[] interfaceC0844FiArr) {
        int i2 = 0;
        while (true) {
            InterfaceC0727Ah[] interfaceC0727AhArr = this.A0E;
            if (i2 < interfaceC0727AhArr.length) {
                if (interfaceC0727AhArr[i2].A7b() == 5) {
                    interfaceC0844FiArr[i2] = null;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public final long A06() {
        if (this.A06) {
            return this.A08.A6w();
        }
        return 0L;
    }

    public final long A07() {
        return this.A00;
    }

    public final long A08(long j2) {
        return j2 - A07();
    }

    public final long A09(long j2) {
        return A07() + j2;
    }

    public final long A0A(long j2, boolean z) {
        return A0B(j2, z, new boolean[this.A0E.length]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
        if (r6 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0087, code lost:
        com.facebook.ads.redexgen.X.I6.A04(r12.A04.A00(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:
        if (r12.A0E[r5].A7b() == 5) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009b, code lost:
        r12.A05 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a7, code lost:
        if (r6 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ae, code lost:
        if (r4.A00(r5) != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b0, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b1, code lost:
        com.facebook.ads.redexgen.X.I6.A04(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b5, code lost:
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long A0B(long r13, boolean r15, boolean[] r16) {
        /*
            r12 = this;
            r4 = 0
        L1:
            com.facebook.ads.redexgen.X.HH r0 = r12.A04
            int r0 = r0.A00
            r2 = 0
            r3 = 1
            if (r4 >= r0) goto L1d
            boolean[] r3 = r12.A0B
            if (r15 != 0) goto L18
            com.facebook.ads.redexgen.X.HH r1 = r12.A04
            com.facebook.ads.redexgen.X.HH r0 = r12.A07
            boolean r0 = r1.A02(r0, r4)
            if (r0 == 0) goto L18
            r2 = 1
        L18:
            r3[r4] = r2
            int r4 = r4 + 1
            goto L1
        L1d:
            com.facebook.ads.redexgen.X.Fi[] r0 = r12.A0A
            r12.A05(r0)
            com.facebook.ads.redexgen.X.HH r0 = r12.A04
            r12.A03(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AP.A0G
            r0 = 7
            r1 = r1[r0]
            r0 = 5
            char r1 = r1.charAt(r0)
            r0 = 57
            if (r1 == r0) goto L3b
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3b:
            java.lang.String[] r4 = com.facebook.ads.redexgen.X.AP.A0G
            java.lang.String r1 = "QjaNyuHuRXZwiIdLefV3JnB"
            r0 = 4
            r4[r0] = r1
            java.lang.String r1 = "qMpMOgpNZnnJVrHuPMC"
            r0 = 5
            r4[r0] = r1
            com.facebook.ads.redexgen.X.HH r0 = r12.A04
            com.facebook.ads.redexgen.X.HE r4 = r0.A01
            com.facebook.ads.redexgen.X.V3 r5 = r12.A08
            com.facebook.ads.redexgen.X.HD[] r6 = r4.A01()
            boolean[] r7 = r12.A0B
            com.facebook.ads.redexgen.X.Fi[] r8 = r12.A0A
            r10 = r13
            r9 = r16
            long r7 = r5.AEE(r6, r7, r8, r9, r10)
            com.facebook.ads.redexgen.X.Fi[] r0 = r12.A0A
            r12.A04(r0)
            r12.A05 = r2
            r5 = 0
        L64:
            com.facebook.ads.redexgen.X.Fi[] r1 = r12.A0A
            int r0 = r1.length
            if (r5 >= r0) goto Lb7
            r6 = r1[r5]
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AP.A0G
            r0 = 7
            r1 = r1[r0]
            r0 = 5
            char r1 = r1.charAt(r0)
            r0 = 57
            if (r1 == r0) goto La0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AP.A0G
            java.lang.String r1 = "ECZNN42Owql1H3dvmIySnd1"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "Y1ZBsUrBheVlA6CxnB4"
            r0 = 5
            r2[r0] = r1
            if (r6 == 0) goto Laa
        L87:
            com.facebook.ads.redexgen.X.HH r0 = r12.A04
            boolean r0 = r0.A00(r5)
            com.facebook.ads.redexgen.X.I6.A04(r0)
            com.facebook.ads.redexgen.X.Ah[] r0 = r12.A0E
            r0 = r0[r5]
            int r1 = r0.A7b()
            r0 = 5
            if (r1 == r0) goto L9d
            r12.A05 = r3
        L9d:
            int r5 = r5 + 1
            goto L64
        La0:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AP.A0G
            java.lang.String r1 = "F5cg"
            r0 = 0
            r2[r0] = r1
            if (r6 == 0) goto Laa
            goto L87
        Laa:
            com.facebook.ads.redexgen.X.HD r0 = r4.A00(r5)
            if (r0 != 0) goto Lb5
            r0 = 1
        Lb1:
            com.facebook.ads.redexgen.X.I6.A04(r0)
            goto L9d
        Lb5:
            r0 = 0
            goto Lb1
        Lb7:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AP.A0B(long, boolean, boolean[]):long");
    }

    public final long A0C(boolean z) {
        if (!this.A06) {
            return this.A02.A03;
        }
        long A5q = this.A08.A5q();
        if (A5q == Long.MIN_VALUE && z) {
            AQ aq = this.A02;
            String[] strArr = A0G;
            if (strArr[1].charAt(21) != strArr[6].charAt(21)) {
                throw new RuntimeException();
            }
            A0G[0] = "Yxep602BeUF0L8l";
            return aq.A01;
        }
        return A5q;
    }

    public final void A0D() {
        A03(null);
        try {
            if (this.A02.A02 != Long.MIN_VALUE) {
                this.A0C.ADX(((C0757Bm) this.A08).A05);
            } else {
                this.A0C.ADX(this.A08);
            }
        } catch (RuntimeException e2) {
            Log.e(A00(0, 17, 116), A00(17, 22, 121), e2);
        }
    }

    public final void A0E(float f2) throws A9 {
        this.A06 = true;
        this.A03 = this.A08.A7a();
        A0I(f2);
        long A0A = A0A(this.A02.A03, false);
        this.A00 += this.A02.A03 - A0A;
        this.A02 = this.A02.A01(A0A);
    }

    public final void A0F(long j2) {
        this.A08.A48(A08(j2));
    }

    public final void A0G(long j2) {
        if (this.A06) {
            this.A08.ADO(A08(j2));
        }
    }

    public final boolean A0H() {
        return this.A06 && (!this.A05 || this.A08.A5q() == Long.MIN_VALUE);
    }

    public final boolean A0I(float f2) throws A9 {
        HD[] A01;
        HH A0T = this.A0D.A0T(this.A0E, this.A03);
        if (A0T.A01(this.A07)) {
            return false;
        }
        this.A04 = A0T;
        for (HD trackSelection : this.A04.A01.A01()) {
            if (trackSelection != null) {
                trackSelection.ABa(f2);
            }
        }
        return true;
    }
}
