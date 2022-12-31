package com.facebook.ads.redexgen.X;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.location.LocationRequestCompat;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Vz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1263Vz implements CP, CY {
    public static byte[] A0J;
    public static String[] A0K = {"0jSfxoXEMfCjtmnyDugkNcQJRjSOySMa", "bnCyjA5DcUmWUqivzOXdDI", "awYt8cnKxKdhDKIItvFTiUYUED9yM0q1", "Luabopmg5NHaS5SoCXeHIbwAQFsLRvJ0", "odfzLqPoxtdmNhQ8QVXSS2", "Wo8IxRBaFRXe4oQbEdt7BomqryNllMGC", "1wQy", "sEQm6Nsu4XqoPKwwi3EdYrJfunZcOKFC"};
    public static final CS A0L;
    public static final int A0M;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public CR A09;
    public IV A0A;
    public boolean A0B;
    public D5[] A0C;
    public long[][] A0D;
    public final int A0E;
    public final IV A0F;
    public final IV A0G;
    public final IV A0H;
    public final ArrayDeque<W7> A0I;

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0J, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 28);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0J = new byte[]{57, 12, 23, 21, 88, 11, 17, 2, 29, 88, 20, 29, 11, 11, 88, 12, 16, 25, 22, 88, 16, 29, 25, 28, 29, 10, 88, 20, 29, 22, 31, 12, 16, 88, 80, Draft_75.CR, 22, 11, Draft_75.CR, 8, 8, 23, 10, 12, 29, 28, 81, 86, 4, 1, 85, 85};
    }

    static {
        A07();
        A0L = new W0();
        A0M = C0923Il.A08(A04(48, 4, 105));
    }

    public C1263Vz() {
        this(0);
    }

    public C1263Vz(int i2) {
        this.A0E = i2;
        this.A0F = new IV(16);
        this.A0I = new ArrayDeque<>();
        this.A0H = new IV(IR.A03);
        this.A0G = new IV(4);
        this.A06 = -1;
    }

    private int A00(long preferredSkipAmount) {
        long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
        int i2 = 1;
        int i3 = -1;
        long j3 = LocationRequestCompat.PASSIVE_INTERVAL;
        long j4 = LocationRequestCompat.PASSIVE_INTERVAL;
        int trackIndex = 1;
        int sampleIndex = -1;
        int i4 = 0;
        while (true) {
            D5[] d5Arr = this.A0C;
            if (i4 >= d5Arr.length) {
                break;
            }
            D5 d5 = d5Arr[i4];
            int i5 = d5.A00;
            if (i5 != d5.A03.A01) {
                long j5 = d5.A03.A06[i5];
                long j6 = this.A0D[i4][i5];
                long j7 = j5 - preferredSkipAmount;
                int i6 = (j7 < 0 || j7 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) ? 1 : 0;
                if ((i6 == 0 && i2 != 0) || (i6 == i2 && j7 < j2)) {
                    i2 = i6;
                    j2 = j7;
                    i3 = i4;
                    j3 = j6;
                }
                if (j6 < j4) {
                    j4 = j6;
                    trackIndex = i6;
                    sampleIndex = i4;
                }
            }
            i4++;
        }
        int i7 = (j4 > LocationRequestCompat.PASSIVE_INTERVAL ? 1 : (j4 == LocationRequestCompat.PASSIVE_INTERVAL ? 0 : -1));
        if (A0K[5].charAt(28) != 'l') {
            throw new RuntimeException();
        }
        String[] strArr = A0K;
        strArr[7] = "2rf3IkD44HipF2iEZWYVpECLVHr0uALb";
        strArr[0] = "2zlrhAiZVnIklu1FhIrlCsqVaSaq97eM";
        if (i7 == 0 || trackIndex == 0) {
            return i3;
        }
        long sampleOffset = 10485760 + j4;
        if (j3 < sampleOffset) {
            return i3;
        }
        return sampleIndex;
    }

    private int A01(CQ cq, CW cw) throws IOException, InterruptedException {
        int i2;
        long A79 = cq.A79();
        if (this.A06 == -1) {
            this.A06 = A00(A79);
            if (this.A06 == -1) {
                return -1;
            }
        }
        D5 d5 = this.A0C[this.A06];
        InterfaceC0771Cb interfaceC0771Cb = d5.A01;
        int i3 = d5.A00;
        long j2 = d5.A03.A06[i3];
        int i4 = d5.A03.A05[i3];
        long inputPosition = j2 - A79;
        long position = inputPosition + this.A04;
        int sampleSize = (position > 0L ? 1 : (position == 0L ? 0 : -1));
        if (sampleSize >= 0) {
            int sampleSize2 = (position > PlaybackStateCompat.ACTION_SET_REPEAT_MODE ? 1 : (position == PlaybackStateCompat.ACTION_SET_REPEAT_MODE ? 0 : -1));
            if (sampleSize2 < 0) {
                if (d5.A02.A02 == 1) {
                    position += 8;
                    i4 -= 8;
                }
                cq.AEh((int) position);
                if (d5.A02.A01 != 0) {
                    byte[] bArr = this.A0G.A00;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i5 = d5.A02.A01;
                    int i6 = 4 - d5.A02.A01;
                    while (this.A04 < i4) {
                        int i7 = this.A05;
                        if (i7 == 0) {
                            byte[] nalLengthData = this.A0G.A00;
                            cq.readFully(nalLengthData, i6, i5);
                            this.A0G.A0Y(0);
                            this.A05 = this.A0G.A0H();
                            this.A0H.A0Y(0);
                            interfaceC0771Cb.AE4(this.A0H, 4);
                            this.A04 += 4;
                            i4 += i6;
                        } else {
                            int writtenBytes = interfaceC0771Cb.AE3(cq, i7, false);
                            this.A04 += writtenBytes;
                            this.A05 -= writtenBytes;
                        }
                    }
                    i2 = 0;
                } else {
                    while (true) {
                        int i8 = this.A04;
                        if (i8 >= i4) {
                            break;
                        }
                        int AE3 = interfaceC0771Cb.AE3(cq, i4 - i8, false);
                        int writtenBytes2 = this.A04;
                        this.A04 = writtenBytes2 + AE3;
                        int writtenBytes3 = this.A05;
                        this.A05 = writtenBytes3 - AE3;
                    }
                    i2 = 0;
                }
                interfaceC0771Cb.AE5(d5.A03.A07[i3], d5.A03.A04[i3], i4, 0, null);
                d5.A00++;
                this.A06 = -1;
                this.A04 = i2;
                this.A05 = i2;
                return i2;
            }
        }
        cw.A00 = j2;
        return 1;
    }

    public static int A02(DE de2, long j2) {
        int A00 = de2.A00(j2);
        if (A00 == -1) {
            return de2.A01(j2);
        }
        return A00;
    }

    public static long A03(DE de2, long j2, long j3) {
        int A02 = A02(de2, j2);
        if (A02 == -1) {
            return j3;
        }
        return Math.min(de2.A06[A02], j3);
    }

    private ArrayList<DE> A05(W7 w7, CT ct, boolean z) throws AS {
        DB A0C;
        ArrayList<DE> arrayList = new ArrayList<>();
        int i2 = 0;
        while (true) {
            int size = w7.A01.size();
            String[] strArr = A0K;
            if (strArr[2].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[7] = "cCqXKTxpaVHnB5xhxhubewm2proDizNi";
            strArr2[0] = "XNMFZPcuybbaYtAFLaJvO7GLnY5oO3YZ";
            if (i2 < size) {
                W7 w72 = w7.A01.get(i2);
                if (((AbstractC0776Cq) w72).A00 == AbstractC0776Cq.A1L && (A0C = C0781Cv.A0C(w72, w7.A07(AbstractC0776Cq.A0n), -9223372036854775807L, null, z, this.A0B)) != null) {
                    DE A0E = C0781Cv.A0E(A0C, w72.A06(AbstractC0776Cq.A0d).A06(AbstractC0776Cq.A0h).A06(AbstractC0776Cq.A16), ct);
                    if (A0E.A01 != 0) {
                        arrayList.add(A0E);
                    }
                }
                i2++;
            } else {
                return arrayList;
            }
        }
    }

    private void A06() {
        this.A03 = 0;
        this.A00 = 0;
    }

    private void A08(long j2) throws AS {
        while (!this.A0I.isEmpty() && this.A0I.peek().A00 == j2) {
            W7 pop = this.A0I.pop();
            if (((AbstractC0776Cq) pop).A00 == AbstractC0776Cq.A0j) {
                A0A(pop);
                this.A0I.clear();
                this.A03 = 2;
            } else if (!this.A0I.isEmpty()) {
                this.A0I.peek().A08(pop);
            }
        }
        if (this.A03 != 2) {
            A06();
        }
    }

    private void A09(long j2) {
        D5[] d5Arr;
        for (D5 d5 : this.A0C) {
            DE de2 = d5.A03;
            int A00 = de2.A00(j2);
            if (A00 == -1) {
                A00 = de2.A01(j2);
            }
            d5.A00 = A00;
        }
    }

    private void A0A(W7 w7) throws AS {
        ArrayList<DE> A05;
        int i2 = -1;
        long j2 = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        Metadata metadata = null;
        CT ct = new CT();
        W6 A07 = w7.A07(AbstractC0776Cq.A1P);
        if (A07 != null && (metadata = C0781Cv.A0F(A07, this.A0B)) != null) {
            ct.A05(metadata);
        }
        boolean ignoreEditLists = (this.A0E & 1) != 0;
        try {
            A05 = A05(w7, ct, ignoreEditLists);
        } catch (W3 unused) {
            ct = new CT();
            A05 = A05(w7, ct, true);
        }
        int size = A05.size();
        for (int i3 = 0; i3 < size; i3++) {
            DE de2 = A05.get(i3);
            DB db = de2.A03;
            D5 d5 = new D5(db, de2, this.A09.AF1(i3, db.A03));
            int trackCount = de2.A00 + 30;
            Format A0F = db.A07.A0F(trackCount);
            if (db.A03 == 1) {
                if (ct.A03()) {
                    A0F = A0F.A0G(ct.A00, ct.A01);
                }
                if (metadata != null) {
                    A0F = A0F.A0J(metadata);
                }
            }
            d5.A01.A5S(A0F);
            j2 = Math.max(j2, db.A04 != -9223372036854775807L ? db.A04 : de2.A02);
            int maxInputSize = db.A03;
            if (maxInputSize == 2 && i2 == -1) {
                i2 = arrayList.size();
            }
            arrayList.add(d5);
        }
        this.A02 = i2;
        this.A08 = j2;
        this.A0C = (D5[]) arrayList.toArray(new D5[arrayList.size()]);
        this.A0D = A0G(this.A0C);
        this.A09.A5A();
        this.A09.AEA(this);
    }

    public static boolean A0B(int i2) {
        if (i2 != AbstractC0776Cq.A0j) {
            int i3 = AbstractC0776Cq.A1L;
            String[] strArr = A0K;
            if (strArr[4].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[2] = "xHWkCkmm9lwx55Xb6ilKRbCBaMi3tx91";
            strArr2[3] = "ufwmFaOIh4ETn2yFiF4b2v05oMaexVS8";
            if (i2 != i3 && i2 != AbstractC0776Cq.A0d && i2 != AbstractC0776Cq.A0h && i2 != AbstractC0776Cq.A16 && i2 != AbstractC0776Cq.A0N) {
                return false;
            }
        }
        return true;
    }

    public static boolean A0C(int i2) {
        if (i2 != AbstractC0776Cq.A0c && i2 != AbstractC0776Cq.A0n && i2 != AbstractC0776Cq.A0V && i2 != AbstractC0776Cq.A1A && i2 != AbstractC0776Cq.A1D && i2 != AbstractC0776Cq.A1B) {
            int i3 = AbstractC0776Cq.A0C;
            if (A0K[1].length() != 22) {
                throw new RuntimeException();
            }
            A0K[1] = "WjfYMB7jPbcUwDvfNOpuH1";
            if (i2 != i3 && i2 != AbstractC0776Cq.A0O && i2 != AbstractC0776Cq.A19 && i2 != AbstractC0776Cq.A1C && i2 != AbstractC0776Cq.A1E && i2 != AbstractC0776Cq.A17 && i2 != AbstractC0776Cq.A0B && i2 != AbstractC0776Cq.A1J && i2 != AbstractC0776Cq.A0U && i2 != AbstractC0776Cq.A1P) {
                return false;
            }
        }
        return true;
    }

    private boolean A0D(CQ cq) throws IOException, InterruptedException {
        if (this.A00 == 0) {
            if (!cq.ADI(this.A0F.A00, 0, 8, true)) {
                return false;
            }
            this.A00 = 8;
            this.A0F.A0Y(0);
            this.A07 = this.A0F.A0M();
            this.A01 = this.A0F.A08();
        }
        long j2 = this.A07;
        if (j2 == 1) {
            cq.readFully(this.A0F.A00, 8, 8);
            this.A00 += 8;
            this.A07 = this.A0F.A0N();
        } else if (j2 == 0) {
            long A6p = cq.A6p();
            if (A6p == -1 && !this.A0I.isEmpty()) {
                A6p = this.A0I.peek().A00;
            }
            if (A6p != -1) {
                this.A07 = (A6p - cq.A79()) + this.A00;
            }
        }
        if (this.A07 >= this.A00) {
            if (A0B(this.A01)) {
                long A79 = (cq.A79() + this.A07) - this.A00;
                this.A0I.push(new W7(this.A01, A79));
                if (this.A07 == this.A00) {
                    A08(A79);
                } else {
                    A06();
                }
            } else if (A0C(this.A01)) {
                I6.A04(this.A00 == 8);
                I6.A04(this.A07 <= 2147483647L);
                this.A0A = new IV((int) this.A07);
                System.arraycopy(this.A0F.A00, 0, this.A0A.A00, 0, 8);
                this.A03 = 1;
            } else {
                this.A0A = null;
                this.A03 = 1;
            }
            return true;
        }
        throw new AS(A04(0, 48, 100));
    }

    private boolean A0E(CQ cq, CW cw) throws IOException, InterruptedException {
        long j2 = this.A07 - this.A00;
        long A79 = cq.A79() + j2;
        boolean z = false;
        IV iv = this.A0A;
        if (iv != null) {
            cq.readFully(iv.A00, this.A00, (int) j2);
            if (this.A01 == AbstractC0776Cq.A0U) {
                this.A0B = A0F(this.A0A);
            } else if (!this.A0I.isEmpty()) {
                this.A0I.peek().A09(new W6(this.A01, this.A0A));
            }
        } else if (j2 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            cq.AEh((int) j2);
        } else {
            cw.A00 = cq.A79() + j2;
            z = true;
        }
        A08(A79);
        return z && this.A03 != 2;
    }

    public static boolean A0F(IV iv) {
        iv.A0Y(8);
        if (iv.A08() == A0M) {
            return true;
        }
        iv.A0Z(4);
        while (iv.A04() > 0) {
            if (iv.A08() == A0M) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x0036 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long[][] A0G(com.facebook.ads.redexgen.X.D5[] r14) {
        /*
            int r0 = r14.length
            long[][] r6 = new long[r0]
            int r0 = r14.length
            int[] r5 = new int[r0]
            int r0 = r14.length
            long[] r4 = new long[r0]
            int r0 = r14.length
            boolean[] r3 = new boolean[r0]
            r2 = 0
        Ld:
            int r0 = r14.length
            if (r2 >= r0) goto L28
            r0 = r14[r2]
            com.facebook.ads.redexgen.X.DE r0 = r0.A03
            int r0 = r0.A01
            long[] r0 = new long[r0]
            r6[r2] = r0
            r0 = r14[r2]
            com.facebook.ads.redexgen.X.DE r0 = r0.A03
            long[] r1 = r0.A07
            r0 = 0
            r0 = r1[r0]
            r4[r2] = r0
            int r2 = r2 + 1
            goto Ld
        L28:
            r12 = 0
            r2 = 0
        L2b:
            int r0 = r14.length
            if (r2 >= r0) goto L71
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r9 = -1
            r1 = 0
        L35:
            int r0 = r14.length
            if (r1 >= r0) goto L48
            boolean r0 = r3[r1]
            if (r0 != 0) goto L45
            r7 = r4[r1]
            int r0 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r0 > 0) goto L45
            r9 = r1
            r10 = r4[r1]
        L45:
            int r1 = r1 + 1
            goto L35
        L48:
            r7 = r5[r9]
            r0 = r6[r9]
            r0[r7] = r12
            r0 = r14[r9]
            com.facebook.ads.redexgen.X.DE r0 = r0.A03
            int[] r0 = r0.A05
            r0 = r0[r7]
            long r0 = (long) r0
            long r12 = r12 + r0
            r1 = 1
            int r7 = r7 + r1
            r5[r9] = r7
            r0 = r6[r9]
            int r0 = r0.length
            if (r7 >= r0) goto L6c
            r0 = r14[r9]
            com.facebook.ads.redexgen.X.DE r0 = r0.A03
            long[] r0 = r0.A07
            r0 = r0[r7]
            r4[r9] = r0
            goto L2b
        L6c:
            r3[r9] = r1
            int r2 = r2 + 1
            goto L2b
        L71:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1263Vz.A0G(com.facebook.ads.redexgen.X.D5[]):long[][]");
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final long A6O() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final CX A7I(long secondTimeUs) {
        long j2;
        long j3;
        int A01;
        D5[] d5Arr = this.A0C;
        if (d5Arr.length == 0) {
            return new CX(CZ.A04);
        }
        long j4 = -9223372036854775807L;
        long j5 = -1;
        int i2 = this.A02;
        if (i2 != -1) {
            DE de2 = d5Arr[i2].A03;
            int A02 = A02(de2, secondTimeUs);
            if (A02 == -1) {
                return new CX(CZ.A04);
            }
            j2 = de2.A07[A02];
            j3 = de2.A06[A02];
            if (j2 < secondTimeUs) {
                int i3 = de2.A01 - 1;
                if (A0K[5].charAt(28) == 'l') {
                    String[] strArr = A0K;
                    strArr[4] = "wZC6PUUkwbL39FGS7qgHi4";
                    strArr[6] = "ISWp";
                    if (A02 < i3 && (A01 = de2.A01(secondTimeUs)) != -1 && A01 != A02) {
                        j4 = de2.A07[A01];
                        j5 = de2.A06[A01];
                    }
                }
                throw new RuntimeException();
            }
        } else {
            j2 = secondTimeUs;
            j3 = LocationRequestCompat.PASSIVE_INTERVAL;
        }
        int i4 = 0;
        while (true) {
            D5[] d5Arr2 = this.A0C;
            if (A0K[5].charAt(28) != 'l') {
                break;
            }
            String[] strArr2 = A0K;
            strArr2[2] = "HuKpkwhwNffVsg1qOYm34WvQGcpzf7CA";
            strArr2[3] = "OpSxQ7AB5KpfVVm82hohcPrOWAs1xSas";
            if (i4 < d5Arr2.length) {
                if (i4 != this.A02) {
                    DE de3 = d5Arr2[i4].A03;
                    j3 = A03(de3, j2, j3);
                    if (j4 != -9223372036854775807L) {
                        j5 = A03(de3, j4, j5);
                    }
                }
                i4++;
            } else {
                CZ cz = new CZ(j2, j3);
                if (j4 == -9223372036854775807L) {
                    return new CX(cz);
                }
                return new CX(cz, new CZ(j4, j5));
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void A8A(CR cr) {
        this.A09 = cr;
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final boolean A8Y() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final int ADD(CQ cq, CW cw) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.A03;
            String[] strArr = A0K;
            if (strArr[2].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[7] = "qJxbwGisfZf9YKIw0pjhTsx78598m8MK";
            strArr2[0] = "kX2rligkfJBBB9teOSCW5LaSmFhGBJWo";
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return A01(cq, cw);
                    }
                    throw new IllegalStateException();
                } else if (A0E(cq, cw)) {
                    return 1;
                }
            } else if (!A0D(cq)) {
                return -1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void AE9(long j2, long j3) {
        this.A0I.clear();
        this.A00 = 0;
        this.A06 = -1;
        this.A04 = 0;
        this.A05 = 0;
        if (j2 == 0) {
            A06();
        } else if (this.A0C == null) {
        } else {
            A09(j3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final boolean AEj(CQ cq) throws IOException, InterruptedException {
        return D9.A04(cq);
    }
}
