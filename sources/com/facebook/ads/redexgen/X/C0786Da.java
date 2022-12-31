package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Da  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0786Da {
    public static String[] A0D = {"AytN1i9iULWpAtR2eIfx7QogEUuyUUX4", "EimBg0", "4eNGQSgLmn9gvaK14R8kSqnFmk3YDtSi", "2fyuIcJ7pz76VyZl9SMNa1chyaGQvScm", "P7Bhpggufyl3vqAGq89SAtaTbaXWozcC", "R5XBsX91lZ7HUyZ9KaLj5rOllXZCV26j", "kcg4Z6bP9bO4onTQZ6Z5ctV", "10vbbYYZLuUPLbeNO2JvVvesRy5vOtek"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final InterfaceC0771Cb A0C;

    public C0786Da(InterfaceC0771Cb interfaceC0771Cb) {
        this.A0C = interfaceC0771Cb;
    }

    private void A00(int i2) {
        boolean z = this.A0A;
        this.A0C.AE5(this.A04, z ? 1 : 0, (int) (this.A01 - this.A03), i2, null);
    }

    public final void A01() {
        this.A07 = false;
        this.A06 = false;
        this.A05 = false;
        this.A09 = false;
        this.A0B = false;
    }

    public final void A02(long j2, int i2) {
        if (this.A0B && this.A06) {
            this.A0A = this.A08;
            String[] strArr = A0D;
            if (strArr[1].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A0D[7] = "hh10uoQ2wjGgTUsUevn281NORx98TkB1";
            this.A0B = false;
        } else if (!this.A05 && !this.A06) {
        } else {
            if (this.A09) {
                A00(i2 + ((int) (j2 - this.A01)));
            }
            this.A03 = this.A01;
            this.A04 = this.A02;
            this.A09 = true;
            this.A0A = this.A08;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0065, code lost:
        if (r10 >= 16) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
        if (r10 > 21) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
        if (r10 >= 16) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A03(long r7, int r9, int r10, long r11) {
        /*
            r6 = this;
            r3 = 0
            r6.A06 = r3
            r6.A05 = r3
            r6.A02 = r11
            r6.A00 = r3
            r6.A01 = r7
            r4 = 1
            r0 = 32
            if (r10 < r0) goto L48
            boolean r0 = r6.A0B
            if (r0 != 0) goto L1d
            boolean r0 = r6.A09
            if (r0 == 0) goto L1d
            r6.A00(r9)
            r6.A09 = r3
        L1d:
            r0 = 34
            if (r10 > r0) goto L48
            boolean r5 = r6.A0B
            r5 = r5 ^ r4
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0786Da.A0D
            r0 = 2
            r1 = r2[r0]
            r0 = 3
            r2 = r2[r0]
            r0 = 16
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L7f
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0786Da.A0D
            java.lang.String r1 = "wqfZZQZmQi2aSzTJgSnfuEG5zpWvg4YI"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "uUijDIjLUkfNDtGFhTuIbp3J3vWPjHax"
            r0 = 3
            r2[r0] = r1
            r6.A05 = r5
            r6.A0B = r4
        L48:
            r4 = 16
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0786Da.A0D
            r0 = 2
            r1 = r2[r0]
            r0 = 3
            r2 = r2[r0]
            r0 = 16
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L7a
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0786Da.A0D
            java.lang.String r1 = "VgXbI0fWsc6LBLXRTGKiMc1TRthchDi6"
            r0 = 7
            r2[r0] = r1
            if (r10 < r4) goto L7d
        L67:
            r0 = 21
            if (r10 > r0) goto L7d
            r0 = 1
        L6c:
            r6.A08 = r0
            boolean r0 = r6.A08
            if (r0 != 0) goto L76
            r0 = 9
            if (r10 > r0) goto L77
        L76:
            r3 = 1
        L77:
            r6.A07 = r3
            return
        L7a:
            if (r10 < r4) goto L7d
            goto L67
        L7d:
            r0 = 0
            goto L6c
        L7f:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0786Da.A03(long, int, int, long):void");
    }

    public final void A04(byte[] bArr, int i2, int i3) {
        if (this.A07) {
            int i4 = this.A00;
            int i5 = (i2 + 2) - i4;
            if (i5 < i3) {
                this.A06 = (bArr[i5] & 128) != 0;
                this.A07 = false;
                return;
            }
            int i6 = i4 + (i3 - i2);
            if (A0D[0].charAt(24) != 'E') {
                throw new RuntimeException();
            }
            A0D[0] = "OWSyVtAwrfkSOzobpeDsxETSEBQPa9qP";
            this.A00 = i6;
        }
    }
}
