package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Fw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0856Fw {
    public static String[] A05 = {"mUl0ad45", "wOnHxFom99khzfrw556TP2S7iTnXdaDI", "F2b18zOkBdzPS6Rw7y0xeVy", "72pK6LdfIPudsj2MuQDeavvJ5e506zcn", "15GKEV160LP26gLZR3RCLRKabW82Co", "R2OsGPNc82TrpFQIYzL", "mRreVGJS4QtDd4oKVCrkQCvx0ML", "uB3KfkVK117X08r1dhVcVjbfa1nPKP9i"};
    public static final C0856Fw A06 = new C0856Fw(new long[0]);
    public final int A00;
    public final long A01;
    public final long A02;
    public final long[] A03;
    public final C0854Fu[] A04;

    public C0856Fw(long... jArr) {
        int length = jArr.length;
        this.A00 = length;
        this.A03 = Arrays.copyOf(jArr, length);
        this.A04 = new C0854Fu[length];
        for (int i2 = 0; i2 < length; i2++) {
            this.A04[i2] = new C0854Fu();
        }
        this.A01 = 0L;
        this.A02 = -9223372036854775807L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0078, code lost:
        if (r3 >= r9.A03.length) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A00(long r10) {
        /*
            r9 = this;
            r3 = 0
        L1:
            long[] r4 = r9.A03
            int r0 = r4.length
            if (r3 >= r0) goto L75
            r7 = r4[r3]
            r5 = -9223372036854775808
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0856Fw.A05
            r0 = 7
            r1 = r2[r0]
            r0 = 1
            r2 = r2[r0]
            r0 = 26
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L24
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L24:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0856Fw.A05
            java.lang.String r1 = "npAqm7bEBhy427JdaT1Ni0I7koiD7S"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "tFKaeO8lP01t1nMB1y4UInduFYw"
            r0 = 6
            r2[r0] = r1
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 == 0) goto L75
            r1 = r4[r3]
            int r0 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r0 >= 0) goto L62
            com.facebook.ads.redexgen.X.Fu[] r4 = r9.A04
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0856Fw.A05
            r0 = 2
            r1 = r2[r0]
            r0 = 5
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L65
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0856Fw.A05
            java.lang.String r1 = "Q7qi9RXitykg8APizUDlkxccyVnHWt3u"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "mzuq9lDyRMMzUIbIxWm25ivrGAnK4SRi"
            r0 = 1
            r2[r0] = r1
            r0 = r4[r3]
            boolean r0 = r0.A02()
            if (r0 != 0) goto L75
        L62:
            int r3 = r3 + 1
            goto L1
        L65:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0856Fw.A05
            java.lang.String r1 = "GUT9witaJOdRyBBc2tjzvJfymhz5uMqF"
            r0 = 3
            r2[r0] = r1
            r0 = r4[r3]
            boolean r0 = r0.A02()
            if (r0 != 0) goto L75
            goto L62
        L75:
            long[] r0 = r9.A03
            int r0 = r0.length
            if (r3 >= r0) goto L7b
        L7a:
            return r3
        L7b:
            r3 = -1
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0856Fw.A00(long):int");
    }

    public final int A01(long j2) {
        int length = this.A03.length - 1;
        while (length >= 0) {
            long[] jArr = this.A03;
            if (jArr[length] != Long.MIN_VALUE && jArr[length] <= j2) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.A04[length].A02()) {
            return -1;
        }
        return length;
    }
}
