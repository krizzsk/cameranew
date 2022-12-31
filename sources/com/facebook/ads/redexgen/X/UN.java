package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class UN implements HR {
    public static byte[] A0L;
    public static String[] A0M = {"xvXnimfZlroovEtMoHYEYdvHQmTptcRb", "VShQwZMBIZykoEi", "P7iiojcQSdjMkPZizdNAiKDH8422CMpJ", "OxKv", "P8zJvNho1beYtiBqU3s9pOljEd8sbOL5", "Bz35mpVTEU3xTv8hVu6cT493QseTsu6A", "YnRJs9xpv2Ig79N4M2dWIXRLqnd73xG0", "iIjgXD4YmMEy6XOGrZ4fgbIBHD"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public Uri A05;
    public Uri A06;
    public HR A07;
    public C0906Hu A08;
    public String A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final HR A0D;
    public final HR A0E;
    public final HR A0F;
    public final InterfaceC0902Hq A0G;
    @Nullable
    public final InterfaceC0904Hs A0H;
    public final boolean A0I;
    public final boolean A0J;
    public final boolean A0K;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0L, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0M[1].length() != 15) {
                throw new RuntimeException();
            }
            A0M[1] = "0DeGlGnSrcDo9YH";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 36);
            i5++;
        }
    }

    public static void A06() {
        A0L = new byte[]{28, 29, 48, 18, 16, 27, 22, 23, 49, 10, 7, 22, 0, 33, 22, 18, 23};
    }

    static {
        A06();
    }

    public UN(InterfaceC0902Hq interfaceC0902Hq, HR hr, HR hr2, @Nullable HP hp, int i2, @Nullable InterfaceC0904Hs interfaceC0904Hs) {
        this.A0G = interfaceC0902Hq;
        this.A0D = hr2;
        this.A0I = (i2 & 1) != 0;
        this.A0K = (i2 & 2) != 0;
        this.A0J = (i2 & 4) != 0;
        this.A0F = hr;
        if (hp != null) {
            this.A0E = new UQ(hr, hp);
        } else {
            this.A0E = null;
        }
        this.A0H = interfaceC0904Hs;
    }

    private int A00(HV hv) {
        if (this.A0K && this.A0C) {
            return 0;
        }
        if (this.A0J && hv.A02 == -1) {
            return 1;
        }
        return -1;
    }

    public static Uri A01(InterfaceC0902Hq interfaceC0902Hq, String str, Uri uri) {
        I0 contentMetadata = interfaceC0902Hq.A65(str);
        Uri A01 = I1.A01(contentMetadata);
        return A01 == null ? uri : A01;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.facebook.ads.redexgen.X.HR, com.facebook.ads.redexgen.X.Hu] */
    private void A03() throws IOException {
        HR hr = this.A07;
        if (hr == null) {
            return;
        }
        try {
            hr.close();
        } finally {
            this.A07 = null;
            this.A0A = false;
            C0906Hu c0906Hu = this.A08;
            if (c0906Hu != null) {
                this.A0G.ADW(c0906Hu);
                this.A08 = null;
            }
        }
    }

    private void A04() {
        if (this.A0H != null && this.A04 > 0) {
            this.A0G.A5r();
            throw new NullPointerException(A02(0, 17, 87));
        }
    }

    private void A05() throws IOException {
        this.A01 = 0L;
        if (A0C()) {
            this.A0G.AEK(this.A09, this.A03);
        }
    }

    private void A07(IOException iOException) {
        if (A0A() || (iOException instanceof C0900Ho)) {
            this.A0C = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x01b9, code lost:
        if (r4 != (-1)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01bb, code lost:
        r2 = java.lang.Math.min(r2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01d0, code lost:
        if (r4 != (-1)) goto L85;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A08(boolean r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.UN.A08(boolean):void");
    }

    private boolean A09() {
        return this.A07 == this.A0F;
    }

    private boolean A0A() {
        return this.A07 == this.A0D;
    }

    private boolean A0B() {
        return !A0A();
    }

    private boolean A0C() {
        return this.A07 == this.A0E;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A0D(java.io.IOException r3) {
        /*
        L0:
            if (r3 == 0) goto L14
            boolean r0 = r3 instanceof com.facebook.ads.redexgen.X.HS
            if (r0 == 0) goto Lf
            r0 = r3
            com.facebook.ads.redexgen.X.HS r0 = (com.facebook.ads.redexgen.X.HS) r0
            int r0 = r0.A00
            if (r0 != 0) goto Lf
            r0 = 1
            return r0
        Lf:
            java.lang.Throwable r3 = r3.getCause()
            goto L0
        L14:
            r3 = 0
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.UN.A0M
            r0 = 5
            r1 = r1[r0]
            r0 = 13
            char r1 = r1.charAt(r0)
            r0 = 118(0x76, float:1.65E-43)
            if (r1 == r0) goto L2a
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L2a:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.UN.A0M
            java.lang.String r1 = "Fi50x9pU4R4a4ch"
            r0 = 1
            r2[r0] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.UN.A0D(java.io.IOException):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final Uri A7d() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final long ACf(HV hv) throws IOException {
        try {
            this.A09 = C0908Hw.A02(hv);
            this.A06 = hv.A04;
            this.A05 = A01(this.A0G, this.A09, this.A06);
            this.A00 = hv.A00;
            this.A03 = hv.A03;
            this.A0B = A00(hv) != -1;
            boolean z = this.A0B;
            if (hv.A02 != -1 || this.A0B) {
                this.A01 = hv.A02;
            } else {
                this.A01 = this.A0G.A64(this.A09);
                if (this.A01 != -1) {
                    this.A01 -= hv.A03;
                    if (this.A01 <= 0) {
                        throw new HS(0);
                    }
                }
            }
            A08(false);
            return this.A01;
        } catch (IOException e2) {
            A07(e2);
            throw e2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final void close() throws IOException {
        this.A06 = null;
        this.A05 = null;
        A04();
        try {
            A03();
        } catch (IOException e2) {
            A07(e2);
            throw e2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        if (this.A01 == 0) {
            return -1;
        }
        try {
            int i4 = (this.A03 > this.A02 ? 1 : (this.A03 == this.A02 ? 0 : -1));
            String[] strArr = A0M;
            if (strArr[4].charAt(0) != strArr[2].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[7] = "DFL6VfCjI9oAtZuqjooU4v3Ar2";
            strArr2[3] = "hOjd";
            if (i4 >= 0) {
                A08(true);
            }
            int read = this.A07.read(bArr, i2, i3);
            if (read != -1) {
                if (A0A()) {
                    this.A04 += read;
                }
                this.A03 += read;
                if (this.A01 != -1) {
                    this.A01 -= read;
                }
            } else if (this.A0A) {
                A05();
            } else if (this.A01 > 0 || this.A01 == -1) {
                A03();
                A08(false);
                return read(bArr, i2, i3);
            }
            return read;
        } catch (IOException e2) {
            if (this.A0A && A0D(e2)) {
                A05();
                return -1;
            }
            A07(e2);
            throw e2;
        }
    }
}
