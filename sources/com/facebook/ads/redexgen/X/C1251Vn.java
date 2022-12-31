package com.facebook.ads.redexgen.X;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.ads.internal.exoplayer2.Format;
import com.tencent.connect.common.Constants;
/* renamed from: com.facebook.ads.redexgen.X.Vn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1251Vn implements DV {
    public static String[] A0C = {"nJiMpwDCR7ZAmhQyp9AOHiC56UVcRx0k", "lCnqxh0y89Em7p481QheNATB6nErTPja", "EOgZonHCFyaPw1rQOdlgFposS9KMweND", "oVFhsCJtzutno5RzvIOwcHRYGNjJYB0M", Constants.VIA_TO_TYPE_QZONE, ExifInterface.LATITUDE_SOUTH, "C7ZxqwSPJTae6vgKBRSPBAMVUD", "Gg5xSTo0LtnMpcaC7QBiBySoh1"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public Format A05;
    public InterfaceC0771Cb A06;
    public String A07;
    public boolean A08;
    public final IU A09;
    public final IV A0A;
    public final String A0B;

    public C1251Vn() {
        this(null);
    }

    public C1251Vn(String str) {
        this.A09 = new IU(new byte[128]);
        this.A0A = new IV(this.A09.A00);
        this.A02 = 0;
        this.A0B = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
        if (r1.A05 == r13.A05.A0O) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A00() {
        /*
            r13 = this;
            com.facebook.ads.redexgen.X.IU r1 = r13.A09
            r0 = 0
            r1.A07(r0)
            com.facebook.ads.redexgen.X.IU r0 = r13.A09
            com.facebook.ads.redexgen.X.Aw r1 = com.facebook.ads.redexgen.X.C0742Ax.A09(r0)
            com.facebook.ads.internal.exoplayer2.Format r0 = r13.A05
            if (r0 == 0) goto L47
            int r2 = r1.A00
            com.facebook.ads.internal.exoplayer2.Format r0 = r13.A05
            int r0 = r0.A05
            if (r2 != r0) goto L47
            int r5 = r1.A03
            com.facebook.ads.internal.exoplayer2.Format r4 = r13.A05
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.C1251Vn.A0C
            r0 = 5
            r2 = r3[r0]
            r0 = 4
            r0 = r3[r0]
            int r2 = r2.length()
            int r0 = r0.length()
            if (r2 == r0) goto L34
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L34:
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.C1251Vn.A0C
            java.lang.String r2 = "c77shWRMJ0xw1RnCUz3RaGOhMvVQh1Vq"
            r0 = 2
            r3[r0] = r2
            int r0 = r4.A0C
            if (r5 != r0) goto L47
            java.lang.String r2 = r1.A05
            com.facebook.ads.internal.exoplayer2.Format r0 = r13.A05
            java.lang.String r0 = r0.A0O
            if (r2 == r0) goto L64
        L47:
            java.lang.String r2 = r13.A07
            java.lang.String r3 = r1.A05
            r4 = 0
            r5 = -1
            r6 = -1
            int r7 = r1.A00
            int r8 = r1.A03
            r9 = 0
            r10 = 0
            r11 = 0
            java.lang.String r12 = r13.A0B
            com.facebook.ads.internal.exoplayer2.Format r0 = com.facebook.ads.internal.exoplayer2.Format.A07(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.A05 = r0
            com.facebook.ads.redexgen.X.Cb r2 = r13.A06
            com.facebook.ads.internal.exoplayer2.Format r0 = r13.A05
            r2.A5S(r0)
        L64:
            int r0 = r1.A01
            r13.A01 = r0
            r4 = 1000000(0xf4240, double:4.940656E-318)
            int r0 = r1.A02
            long r2 = (long) r0
            long r2 = r2 * r4
            com.facebook.ads.internal.exoplayer2.Format r0 = r13.A05
            int r0 = r0.A0C
            long r0 = (long) r0
            long r2 = r2 / r0
            r13.A03 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1251Vn.A00():void");
    }

    private boolean A01(IV iv) {
        while (true) {
            if (iv.A04() <= 0) {
                return false;
            }
            if (!this.A08) {
                this.A08 = iv.A0E() == 11;
            } else {
                int A0E = iv.A0E();
                if (A0E == 119) {
                    this.A08 = false;
                    return true;
                }
                this.A08 = A0E == 11;
            }
        }
    }

    private boolean A02(IV iv, byte[] bArr, int i2) {
        int min = Math.min(iv.A04(), i2 - this.A00);
        iv.A0c(bArr, this.A00, min);
        this.A00 += min;
        return this.A00 == i2;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A46(IV iv) {
        while (iv.A04() > 0) {
            int i2 = this.A02;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(iv.A04(), this.A01 - this.A00);
                        this.A06.AE4(iv, min);
                        this.A00 += min;
                        int i3 = this.A00;
                        int i4 = this.A01;
                        if (i3 == i4) {
                            this.A06.AE5(this.A04, 1, i4, 0, null);
                            this.A04 += this.A03;
                            this.A02 = 0;
                        }
                    }
                } else if (A02(iv, this.A0A.A00, 128)) {
                    A00();
                    this.A0A.A0Y(0);
                    this.A06.AE4(this.A0A, 128);
                    this.A02 = 2;
                }
            } else if (A01(iv)) {
                this.A02 = 1;
                this.A0A.A00[0] = 11;
                this.A0A.A00[1] = 119;
                this.A00 = 2;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A4T(CR cr, C0795Dj c0795Dj) {
        c0795Dj.A05();
        this.A07 = c0795Dj.A04();
        this.A06 = cr.AF1(c0795Dj.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACl() {
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACm(long j2, boolean z) {
        this.A04 = j2;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void AE8() {
        this.A02 = 0;
        this.A00 = 0;
        this.A08 = false;
    }
}
