package com.facebook.ads.redexgen.X;

import androidx.core.location.LocationRequestCompat;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.Bm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0757Bm implements V3, V4 {
    public static String[] A06 = {"xZ98n6jXZ", "w0wM6S1AW5kwd8mBaLXb8IJFUPLi1ZSY", "", "5GeP1Ey0MjdLLaKEOlMigJbDmIHcG3Ps", "Q5WYazqpabUa99ZYxsI", "Gm0HQrfOciURdkrLDtJ", "cUS8ttxVNiquYZeS", "9hpvQN9G3pxye3p4YcQpNMMd2GK"};
    public long A00;
    public long A01;
    public long A02;
    public V4 A03;
    public V9[] A04 = new V9[0];
    public final V3 A05;

    public C0757Bm(V3 v3, boolean z, long j2, long j3) {
        this.A05 = v3;
        this.A02 = z ? j2 : -9223372036854775807L;
        this.A01 = j2;
        this.A00 = j3;
    }

    private C0730Ak A00(long j2, C0730Ak c0730Ak) {
        long A0E = C0923Il.A0E(c0730Ak.A01, 0L, j2 - this.A01);
        long j3 = c0730Ak.A00;
        long j4 = this.A00;
        long A0E2 = C0923Il.A0E(j3, 0L, j4 == Long.MIN_VALUE ? LocationRequestCompat.PASSIVE_INTERVAL : j4 - j2);
        if (A0E == c0730Ak.A01 && A0E2 == c0730Ak.A00) {
            return c0730Ak;
        }
        return new C0730Ak(A0E, A0E2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Fj
    /* renamed from: A01 */
    public final void AAD(V3 v3) {
        this.A03.AAD(this);
    }

    public static boolean A02(long j2, HD[] hdArr) {
        if (j2 != 0) {
            for (HD hd : hdArr) {
                if (hd != null && !IO.A09(hd.A7J().A0O)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean A03() {
        return this.A02 != -9223372036854775807L;
    }

    @Override // com.facebook.ads.redexgen.X.V3
    public final boolean A48(long j2) {
        return this.A05.A48(j2);
    }

    @Override // com.facebook.ads.redexgen.X.V3
    public final void A4n(long j2, boolean z) {
        this.A05.A4n(j2, z);
    }

    @Override // com.facebook.ads.redexgen.X.V3
    public final long A5b(long j2, C0730Ak c0730Ak) {
        long j3 = this.A01;
        if (j2 == j3) {
            return j3;
        }
        return this.A05.A5b(j2, A00(j2, c0730Ak));
    }

    @Override // com.facebook.ads.redexgen.X.V3
    public final long A5q() {
        long A5q = this.A05.A5q();
        if (A5q != Long.MIN_VALUE) {
            long j2 = this.A00;
            if (j2 == Long.MIN_VALUE || A5q < j2) {
                return A5q;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.X.V3
    public final long A6w() {
        long A6w = this.A05.A6w();
        if (A6w != Long.MIN_VALUE) {
            long j2 = this.A00;
            if (j2 == Long.MIN_VALUE || A6w < j2) {
                return A6w;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.X.V3
    public final TrackGroupArray A7a() {
        return this.A05.A7a();
    }

    @Override // com.facebook.ads.redexgen.X.V3
    public final void A9O() throws IOException {
        this.A05.A9O();
    }

    @Override // com.facebook.ads.redexgen.X.V4
    public final void ABh(V3 v3) {
        this.A03.ABh(this);
    }

    @Override // com.facebook.ads.redexgen.X.V3
    public final void ACy(V4 v4, long j2) {
        this.A03 = v4;
        this.A05.ACy(this, j2);
    }

    @Override // com.facebook.ads.redexgen.X.V3
    public final long ADH() {
        if (A03()) {
            long j2 = this.A02;
            this.A02 = -9223372036854775807L;
            long ADH = ADH();
            return ADH != -9223372036854775807L ? ADH : j2;
        }
        long ADH2 = this.A05.ADH();
        String[] strArr = A06;
        if (strArr[7].length() != strArr[2].length()) {
            String[] strArr2 = A06;
            strArr2[5] = "JN4lYhgdVtJugUzGLO1";
            strArr2[4] = "V7PIoeFvQi5pkabjQnk";
            if (ADH2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            boolean z = true;
            I6.A04(ADH2 >= this.A01);
            long discontinuityUs = this.A00;
            if (discontinuityUs != Long.MIN_VALUE && ADH2 > discontinuityUs) {
                z = false;
            }
            I6.A04(z);
            return ADH2;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.V3
    public final void ADO(long j2) {
        this.A05.ADO(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        if (r5 > r3) goto L18;
     */
    @Override // com.facebook.ads.redexgen.X.V3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long AED(long r9) {
        /*
            r8 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8.A02 = r0
            com.facebook.ads.redexgen.X.V9[] r3 = r8.A04
            int r2 = r3.length
            r7 = 0
            r1 = 0
        Lc:
            if (r1 >= r2) goto L18
            r0 = r3[r1]
            if (r0 == 0) goto L15
            r0.A00()
        L15:
            int r1 = r1 + 1
            goto Lc
        L18:
            com.facebook.ads.redexgen.X.V3 r0 = r8.A05
            long r5 = r0.AED(r9)
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 == 0) goto L34
            long r1 = r8.A01
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 < 0) goto L35
            long r3 = r8.A00
            r1 = -9223372036854775808
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L34
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 > 0) goto L35
        L34:
            r7 = 1
        L35:
            com.facebook.ads.redexgen.X.I6.A04(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0757Bm.AED(long):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
        if (r7 > r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    @Override // com.facebook.ads.redexgen.X.V3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long AEE(com.facebook.ads.redexgen.X.HD[] r16, boolean[] r17, com.facebook.ads.redexgen.X.InterfaceC0844Fi[] r18, boolean[] r19, long r20) {
        /*
            r15 = this;
            r4 = r18
            int r0 = r4.length
            com.facebook.ads.redexgen.X.V9[] r0 = new com.facebook.ads.redexgen.X.V9[r0]
            r15.A04 = r0
            int r0 = r4.length
            com.facebook.ads.redexgen.X.Fi[] r11 = new com.facebook.ads.redexgen.X.InterfaceC0844Fi[r0]
            r2 = 0
        Lb:
            int r0 = r4.length
            r3 = 0
            if (r2 >= r0) goto L24
            com.facebook.ads.redexgen.X.V9[] r1 = r15.A04
            r0 = r4[r2]
            com.facebook.ads.redexgen.X.V9 r0 = (com.facebook.ads.redexgen.X.V9) r0
            r1[r2] = r0
            r0 = r1[r2]
            if (r0 == 0) goto L1f
            r0 = r1[r2]
            com.facebook.ads.redexgen.X.Fi r3 = r0.A01
        L1f:
            r11[r2] = r3
            int r2 = r2 + 1
            goto Lb
        L24:
            com.facebook.ads.redexgen.X.V3 r8 = r15.A05
            r10 = r17
            r9 = r16
            r13 = r20
            r12 = r19
            long r7 = r8.AEE(r9, r10, r11, r12, r13)
            boolean r0 = r15.A03()
            if (r0 == 0) goto L92
            long r0 = r15.A01
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 != 0) goto L92
            boolean r0 = A02(r0, r9)
            if (r0 == 0) goto L92
            r0 = r7
        L45:
            r15.A02 = r0
            int r0 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r0 == 0) goto L5d
            long r1 = r15.A01
            int r0 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r0 < 0) goto L90
            long r1 = r15.A00
            r5 = -9223372036854775808
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 == 0) goto L5d
            int r0 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r0 > 0) goto L90
        L5d:
            r0 = 1
        L5e:
            com.facebook.ads.redexgen.X.I6.A04(r0)
            r5 = 0
        L62:
            int r0 = r4.length
            if (r5 >= r0) goto L98
            r0 = r11[r5]
            if (r0 != 0) goto L76
            com.facebook.ads.redexgen.X.V9[] r0 = r15.A04
            r0[r5] = r3
        L6d:
            com.facebook.ads.redexgen.X.V9[] r0 = r15.A04
            r0 = r0[r5]
            r4[r5] = r0
            int r5 = r5 + 1
            goto L62
        L76:
            r0 = r4[r5]
            if (r0 == 0) goto L84
            com.facebook.ads.redexgen.X.V9[] r0 = r15.A04
            r0 = r0[r5]
            com.facebook.ads.redexgen.X.Fi r1 = r0.A01
            r0 = r11[r5]
            if (r1 == r0) goto L6d
        L84:
            com.facebook.ads.redexgen.X.V9[] r2 = r15.A04
            r1 = r11[r5]
            com.facebook.ads.redexgen.X.V9 r0 = new com.facebook.ads.redexgen.X.V9
            r0.<init>(r15, r1)
            r2[r5] = r0
            goto L6d
        L90:
            r0 = 0
            goto L5e
        L92:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L45
        L98:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0757Bm.AEE(com.facebook.ads.redexgen.X.HD[], boolean[], com.facebook.ads.redexgen.X.Fi[], boolean[], long):long");
    }
}
