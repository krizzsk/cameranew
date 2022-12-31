package com.facebook.ads.redexgen.X;

import androidx.core.location.LocationRequestCompat;
import com.facebook.ads.internal.exoplayer2.Format;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: assets/audience_network.dex */
public final class V2 implements InterfaceC0771Cb {
    public static String[] A0F = {"I0oQBEUbvXwmLkE4WWtRMgz", "xnniIxRr7DxSpuMWabRYn3WDpy4qBN9b", "Y7uRaXgz80uNyvcPATB9r3b0PwOkuM1V", "hSCUvOutOZqOqVGgCzlnUKxaNOAoeOWK", "Xz3O4WRIuCzLKbQHyaIDpuywePn7", "cSGy8Fn9cMgpPa", "oA7ibzMCvoxqvUcH1m6Eely4XW9nrCN1", "6CG0cGfKidBjxaDlKmMoUzgrmHvkLCHY"};
    public long A00;
    public long A01;
    public Format A02;
    public Format A03;
    public C0842Fg A04;
    public C0842Fg A05;
    public C0842Fg A06;
    public InterfaceC0843Fh A07;
    public boolean A08;
    public boolean A09;
    public final int A0A;
    public final HJ A0D;
    public final C0841Ff A0C = new C0841Ff();
    public final C0840Fe A0B = new C0840Fe();
    public final IV A0E = new IV(32);

    public V2(HJ hj) {
        this.A0D = hj;
        this.A0A = hj.A6k();
        this.A04 = new C0842Fg(0L, this.A0A);
        C0842Fg c0842Fg = this.A04;
        this.A05 = c0842Fg;
        this.A06 = c0842Fg;
    }

    private int A00(int i2) {
        if (!this.A06.A02) {
            this.A06.A02(this.A0D.A3K(), new C0842Fg(this.A06.A03, this.A0A));
        }
        return Math.min(i2, (int) (this.A06.A03 - this.A01));
    }

    public static Format A01(Format format, long j2) {
        if (format == null) {
            return null;
        }
        if (j2 != 0 && format.A0G != LocationRequestCompat.PASSIVE_INTERVAL) {
            return format.A0H(format.A0G + j2);
        }
        return format;
    }

    private void A02(int i2) {
        this.A01 += i2;
        if (this.A01 == this.A06.A03) {
            this.A06 = this.A06.A00;
        }
    }

    private void A03(long j2) {
        while (j2 >= this.A05.A03) {
            this.A05 = this.A05.A00;
        }
    }

    private void A04(long j2) {
        if (j2 == -1) {
            return;
        }
        while (j2 >= this.A04.A03) {
            HJ hj = this.A0D;
            HI hi = this.A04.A01;
            if (A0F[7].charAt(20) != 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[3] = "uyKFH8oWQ0ou8mdxvkWufQ8fbIwtl6Z0";
            strArr[1] = "5GODjm0a5UxNqoFNrNo0AvXndV19DDx4";
            hj.ADT(hi);
            this.A04 = this.A04.A01();
        }
        if (this.A05.A04 < this.A04.A04) {
            this.A05 = this.A04;
        }
    }

    private void A05(long j2, ByteBuffer byteBuffer, int i2) {
        A03(j2);
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.A05.A03 - j2));
            byteBuffer.put(this.A05.A01.A01, this.A05.A00(j2), min);
            i2 -= min;
            j2 += min;
            if (j2 == this.A05.A03) {
                this.A05 = this.A05.A00;
            }
        }
    }

    private void A06(long j2, byte[] bArr, int i2) {
        A03(j2);
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, (int) (this.A05.A03 - j2));
            System.arraycopy(this.A05.A01.A01, this.A05.A00(j2), bArr, i2 - i3, min);
            i3 -= min;
            j2 += min;
            if (j2 == this.A05.A03) {
                this.A05 = this.A05.A00;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ae, code lost:
        if (r10 < r11) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A07(com.facebook.ads.redexgen.X.WZ r20, com.facebook.ads.redexgen.X.C0840Fe r21) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.V2.A07(com.facebook.ads.redexgen.X.WZ, com.facebook.ads.redexgen.X.Fe):void");
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0019 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A08(com.facebook.ads.redexgen.X.C0842Fg r6) {
        /*
            r5 = this;
            boolean r0 = r6.A02
            if (r0 != 0) goto L5
            return
        L5:
            com.facebook.ads.redexgen.X.Fg r0 = r5.A06
            boolean r4 = r0.A02
            com.facebook.ads.redexgen.X.Fg r0 = r5.A06
            long r2 = r0.A04
            long r0 = r6.A04
            long r2 = r2 - r0
            int r1 = (int) r2
            int r0 = r5.A0A
            int r1 = r1 / r0
            int r4 = r4 + r1
            com.facebook.ads.redexgen.X.HI[] r2 = new com.facebook.ads.redexgen.X.HI[r4]
            r1 = 0
        L18:
            int r0 = r2.length
            if (r1 >= r0) goto L26
            com.facebook.ads.redexgen.X.HI r0 = r6.A01
            r2[r1] = r0
            com.facebook.ads.redexgen.X.Fg r6 = r6.A01()
            int r1 = r1 + 1
            goto L18
        L26:
            com.facebook.ads.redexgen.X.HJ r0 = r5.A0D
            r0.ADU(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.V2.A08(com.facebook.ads.redexgen.X.Fg):void");
    }

    private final void A09(boolean z) {
        this.A0C.A0H(z);
        A08(this.A04);
        this.A04 = new C0842Fg(0L, this.A0A);
        C0842Fg c0842Fg = this.A04;
        this.A05 = c0842Fg;
        this.A06 = c0842Fg;
        this.A01 = 0L;
        this.A0D.AF2();
    }

    public final int A0A() {
        return this.A0C.A07();
    }

    public final int A0B() {
        return this.A0C.A05();
    }

    public final int A0C() {
        return this.A0C.A06();
    }

    public final int A0D(long j2, boolean z, boolean z2) {
        return this.A0C.A08(j2, z, z2);
    }

    public final int A0E(AM am, WZ wz, boolean z, boolean z2, long j2) {
        int A09 = this.A0C.A09(am, wz, z, z2, this.A02, this.A0B);
        if (A09 == -5) {
            this.A02 = am.A00;
            return -5;
        } else if (A09 != -4) {
            if (A09 == -3) {
                return -3;
            }
            throw new IllegalStateException();
        } else {
            if (!wz.A04()) {
                long j3 = wz.A00;
                if (A0F[7].charAt(20) != 'U') {
                    throw new RuntimeException();
                }
                A0F[2] = "VD6eroQucXdNz3MsoKHIT4kATW1JDfRN";
                if (j3 < j2) {
                    wz.A00(Integer.MIN_VALUE);
                }
                if (wz.A0A()) {
                    A07(wz, this.A0B);
                }
                wz.A09(this.A0B.A00);
                A05(this.A0B.A01, wz.A01, this.A0B.A00);
            }
            return -4;
        }
    }

    public final long A0F() {
        return this.A0C.A0B();
    }

    public final Format A0G() {
        return this.A0C.A0E();
    }

    public final void A0H() {
        A04(this.A0C.A0A());
    }

    public final void A0I() {
        A09(false);
    }

    public final void A0J() {
        this.A0C.A0F();
        this.A05 = this.A04;
    }

    public final void A0K(long j2, boolean z, boolean z2) {
        A04(this.A0C.A0D(j2, z, z2));
    }

    public final void A0L(InterfaceC0843Fh interfaceC0843Fh) {
        this.A07 = interfaceC0843Fh;
    }

    public final boolean A0M() {
        return this.A0C.A0I();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0771Cb
    public final void A5S(Format format) {
        Format A01 = A01(format, this.A00);
        boolean A0K = this.A0C.A0K(A01);
        this.A03 = format;
        this.A08 = false;
        InterfaceC0843Fh interfaceC0843Fh = this.A07;
        if (interfaceC0843Fh != null && A0K) {
            interfaceC0843Fh.ACN(A01);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0771Cb
    public final int AE3(CQ cq, int i2, boolean z) throws IOException, InterruptedException {
        int read = cq.read(this.A06.A01.A01, this.A06.A00(this.A01), A00(i2));
        if (read == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        A02(read);
        if (A0F[4].length() != 13) {
            String[] strArr = A0F;
            strArr[0] = "gj56WjutkODHGuBsULoCjgk";
            strArr[5] = "cXoHIYif5j6YkS";
            return read;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0771Cb
    public final void AE4(IV iv, int i2) {
        while (i2 > 0) {
            int A00 = A00(i2);
            iv.A0c(this.A06.A01.A01, this.A06.A00(this.A01), A00);
            i2 -= A00;
            A02(A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0771Cb
    public final void AE5(long j2, int i2, int i3, int i4, C0770Ca c0770Ca) {
        if (this.A08) {
            A5S(this.A03);
        }
        if (this.A09) {
            if ((i2 & 1) != 0) {
                C0841Ff c0841Ff = this.A0C;
                if (A0F[4].length() == 13) {
                    throw new RuntimeException();
                }
                String[] strArr = A0F;
                strArr[3] = "x9Xeu0fQ5laTPGHIgNPQILpO6czCAzIw";
                strArr[1] = "ozcoxAULLkb5oe9KcRf5sNeK93qRoKsz";
                if (!c0841Ff.A0J(j2)) {
                    return;
                }
                String[] strArr2 = A0F;
                if (strArr2[0].length() == strArr2[5].length()) {
                    throw new RuntimeException();
                }
                A0F[7] = "2aF6Rrv8pvM6dW2iEnwFUFag8sTvrLLb";
                this.A09 = false;
            } else {
                return;
            }
        }
        long timeUs = j2 + this.A00;
        this.A0C.A0G(timeUs, i2, (this.A01 - i3) - i4, i3, c0770Ca);
    }
}
