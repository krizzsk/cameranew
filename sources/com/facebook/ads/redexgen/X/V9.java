package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class V9 implements InterfaceC0844Fi {
    public static String[] A03 = {"Y0RqBQKF49030hyQzszDurtmlsUicf4U", "tAeRat44Mts19", "EPGGJhXl7bdoeZDT1hnWH0ijeyZXJvPV", "NBArrZMeyPwcwZbguPm4zDdVfStRBHKE", "9Syc9rzKlnhB1gjxfWOFcJRGeL88RA9A", "zPpMUsK8OtHy3XCHJzxzsSjo5boBV7qo", "d", "R"};
    public boolean A00;
    public final InterfaceC0844Fi A01;
    public final /* synthetic */ C0757Bm A02;

    public V9(C0757Bm c0757Bm, InterfaceC0844Fi interfaceC0844Fi) {
        this.A02 = c0757Bm;
        this.A01 = interfaceC0844Fi;
    }

    public final void A00() {
        this.A00 = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0844Fi
    public final boolean A8U() {
        return !this.A02.A03() && this.A01.A8U();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0844Fi
    public final void A9N() throws IOException {
        this.A01.A9N();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
        if (r7 == Long.MIN_VALUE) goto L29;
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0844Fi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int ADG(com.facebook.ads.redexgen.X.AM r12, com.facebook.ads.redexgen.X.WZ r13, boolean r14) {
        /*
            r11 = this;
            com.facebook.ads.redexgen.X.Bm r0 = r11.A02
            boolean r0 = r0.A03()
            r8 = -3
            if (r0 == 0) goto La
            return r8
        La:
            boolean r0 = r11.A00
            r5 = 4
            r4 = -4
            if (r0 == 0) goto L14
            r13.A02(r5)
            return r4
        L14:
            com.facebook.ads.redexgen.X.Fi r0 = r11.A01
            int r6 = r0.ADG(r12, r13, r14)
            r7 = -5
            r9 = -9223372036854775808
            if (r6 != r7) goto L4a
            com.facebook.ads.internal.exoplayer2.Format r8 = r12.A00
            int r0 = r8.A06
            if (r0 != 0) goto L29
            int r0 = r8.A07
            if (r0 == 0) goto L43
        L29:
            com.facebook.ads.redexgen.X.Bm r0 = r11.A02
            long r1 = r0.A01
            r5 = 0
            r4 = 0
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 == 0) goto L47
            r3 = 0
        L35:
            com.facebook.ads.redexgen.X.Bm r0 = r11.A02
            long r1 = r0.A00
            int r0 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r0 == 0) goto L44
        L3d:
            com.facebook.ads.internal.exoplayer2.Format r0 = r8.A0G(r3, r4)
            r12.A00 = r0
        L43:
            return r7
        L44:
            int r4 = r8.A07
            goto L3d
        L47:
            int r3 = r8.A06
            goto L35
        L4a:
            com.facebook.ads.redexgen.X.Bm r0 = r11.A02
            long r0 = r0.A00
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 == 0) goto L95
            if (r6 != r4) goto L5e
            long r2 = r13.A00
            com.facebook.ads.redexgen.X.Bm r0 = r11.A02
            long r0 = r0.A00
            int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r7 >= 0) goto L85
        L5e:
            if (r6 != r8) goto L95
            com.facebook.ads.redexgen.X.Bm r0 = r11.A02
            long r7 = r0.A5q()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.V9.A03
            r0 = 0
            r1 = r1[r0]
            r0 = 9
            char r1 = r1.charAt(r0)
            r0 = 68
            if (r1 == r0) goto L8f
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.V9.A03
            java.lang.String r1 = "5QKVTlH6XMkdzqZX2Kpnrvt1Zx1xK1pY"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "sZN1P6CG5u8rJaXjKPttrcVUDogJ8FeU"
            r0 = 5
            r2[r0] = r1
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 != 0) goto L95
        L85:
            r13.A07()
            r13.A02(r5)
            r0 = 1
            r11.A00 = r0
            return r4
        L8f:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L95:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.V9.ADG(com.facebook.ads.redexgen.X.AM, com.facebook.ads.redexgen.X.WZ, boolean):int");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0844Fi
    public final int AEg(long j2) {
        if (this.A02.A03()) {
            return -3;
        }
        return this.A01.AEg(j2);
    }
}
