package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class DZ {
    public static String[] A0I = {"4oBn500ONSa7zUcj69ZejwliI7fNkQe9", "sao3", "S05M", "dUQbnZGK3vs92wXndxl51oc8w6Wzg5UK", "r2dYBwwJ6wCRp20YpqJDniAkemsUTuNE", "fcxFuh", "wirhT", "AIyirGzN48rHG0XGibSi5d9zNx7vdYO1"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final InterfaceC0771Cb A0E;
    public final boolean A0G;
    public final boolean A0H;
    public final SparseArray<IQ> A0D = new SparseArray<>();
    public final SparseArray<IP> A0C = new SparseArray<>();
    public DY A06 = new DY();
    public DY A07 = new DY();
    public byte[] A0B = new byte[128];
    public final IW A0F = new IW(this.A0B, 0, 0);

    public DZ(InterfaceC0771Cb interfaceC0771Cb, boolean z, boolean z2) {
        this.A0E = interfaceC0771Cb;
        this.A0G = z;
        this.A0H = z2;
        A01();
    }

    private void A00(int i2) {
        boolean z = this.A0A;
        this.A0E.AE5(this.A05, z ? 1 : 0, (int) (this.A02 - this.A04), i2, null);
    }

    public final void A01() {
        this.A08 = false;
        this.A09 = false;
        this.A07.A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r0 != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A02(long r6, int r8) {
        /*
            r5 = this;
            int r1 = r5.A01
            r3 = 0
            r4 = 1
            r0 = 9
            if (r1 == r0) goto L16
            boolean r0 = r5.A0H
            if (r0 == 0) goto L2e
            com.facebook.ads.redexgen.X.DY r1 = r5.A07
            com.facebook.ads.redexgen.X.DY r0 = r5.A06
            boolean r0 = com.facebook.ads.redexgen.X.DY.A01(r1, r0)
            if (r0 == 0) goto L2e
        L16:
            boolean r0 = r5.A09
            if (r0 == 0) goto L22
            long r0 = r5.A02
            long r6 = r6 - r0
            int r0 = (int) r6
            int r8 = r8 + r0
            r5.A00(r8)
        L22:
            long r0 = r5.A02
            r5.A04 = r0
            long r0 = r5.A03
            r5.A05 = r0
            r5.A0A = r3
            r5.A09 = r4
        L2e:
            boolean r2 = r5.A0A
            int r1 = r5.A01
            r0 = 5
            if (r1 == r0) goto L43
            boolean r0 = r5.A0G
            if (r0 == 0) goto L44
            if (r1 != r4) goto L44
            com.facebook.ads.redexgen.X.DY r0 = r5.A07
            boolean r0 = r0.A05()
            if (r0 == 0) goto L44
        L43:
            r3 = 1
        L44:
            r2 = r2 | r3
            r5.A0A = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DZ.A02(long, int):void");
    }

    public final void A03(long j2, int i2, long j3) {
        this.A01 = i2;
        this.A03 = j3;
        this.A02 = j2;
        if (!this.A0G || this.A01 != 1) {
            if (!this.A0H) {
                return;
            }
            int i3 = this.A01;
            if (i3 != 5 && i3 != 1 && i3 != 2) {
                return;
            }
        }
        DY dy = this.A06;
        this.A06 = this.A07;
        this.A07 = dy;
        this.A07.A02();
        this.A00 = 0;
        this.A08 = true;
    }

    public final void A04(IP ip) {
        this.A0C.append(ip.A00, ip);
    }

    public final void A05(IQ iq) {
        this.A0D.append(iq.A05, iq);
    }

    public final void A06(byte[] bArr, int readLength, int i2) {
        if (!this.A08) {
            return;
        }
        int i3 = i2 - readLength;
        byte[] bArr2 = this.A0B;
        int length = bArr2.length;
        int i4 = this.A00;
        if (length < i4 + i3) {
            this.A0B = Arrays.copyOf(bArr2, (i4 + i3) * 2);
        }
        System.arraycopy(bArr, readLength, this.A0B, this.A00, i3);
        this.A00 += i3;
        this.A0F.A08(this.A0B, 0, this.A00);
        if (!this.A0F.A0B(8)) {
            return;
        }
        this.A0F.A06();
        int deltaPicOrderCnt1 = this.A0F.A05(2);
        this.A0F.A07(5);
        if (!this.A0F.A09()) {
            return;
        }
        this.A0F.A04();
        if (!this.A0F.A09()) {
            return;
        }
        int A04 = this.A0F.A04();
        if (!this.A0H) {
            this.A08 = false;
            this.A07.A03(A04);
        } else if (!this.A0F.A09()) {
        } else {
            int A042 = this.A0F.A04();
            String[] strArr = A0I;
            if (strArr[0].charAt(5) != strArr[3].charAt(5)) {
                A0I[6] = "2v7XO";
                int picParameterSetId = this.A0C.indexOfKey(A042);
                if (picParameterSetId < 0) {
                    this.A08 = false;
                    return;
                }
                IP ppsData = this.A0C.get(A042);
                IQ iq = this.A0D.get(ppsData.A01);
                if (iq.A09) {
                    if (!this.A0F.A0B(2)) {
                        return;
                    }
                    this.A0F.A07(2);
                }
                if (!this.A0F.A0B(iq.A01)) {
                    return;
                }
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                int A05 = this.A0F.A05(iq.A01);
                boolean bottomFieldFlagPresent = iq.A08;
                if (!bottomFieldFlagPresent) {
                    boolean bottomFieldFlagPresent2 = this.A0F.A0B(1);
                    if (!bottomFieldFlagPresent2) {
                        return;
                    }
                    z = this.A0F.A0A();
                    if (z) {
                        boolean bottomFieldFlagPresent3 = this.A0F.A0B(1);
                        if (!bottomFieldFlagPresent3) {
                            return;
                        }
                        z3 = this.A0F.A0A();
                        z2 = true;
                    } else {
                        String[] strArr2 = A0I;
                        if (strArr2[2].length() == strArr2[1].length()) {
                            A0I[4] = "qwcYbvbtciQlsge07t8jnpQbFFEGYRzL";
                        }
                    }
                }
                boolean z4 = this.A01 == 5;
                int i5 = 0;
                if (z4) {
                    if (!this.A0F.A09()) {
                        return;
                    }
                    IW iw = this.A0F;
                    if (A0I[5].length() == 32) {
                        throw new RuntimeException();
                    }
                    String[] strArr3 = A0I;
                    strArr3[0] = "CUn0EGRMZuaxcZmcWt6bm8g2eSLscmSu";
                    strArr3[3] = "AO4oaRrhS9J5INJLsqTeqW6rWo7URvM3";
                    i5 = iw.A04();
                }
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int picOrderCntLsb = iq.A04;
                if (picOrderCntLsb == 0) {
                    IW iw2 = this.A0F;
                    int deltaPicOrderCnt12 = iq.A03;
                    if (!iw2.A0B(deltaPicOrderCnt12)) {
                        return;
                    }
                    IW iw3 = this.A0F;
                    int i10 = iq.A03;
                    int picOrderCntLsb2 = A0I[7].charAt(28);
                    if (picOrderCntLsb2 != 108) {
                        A0I[4] = "13MW05H83xonKdXxuFb2nSy24rNhSBqM";
                        i6 = iw3.A05(i10);
                        if (ppsData.A02 && !z) {
                            if (!this.A0F.A09()) {
                                return;
                            }
                            i7 = this.A0F.A03();
                        }
                    }
                } else {
                    int picOrderCntLsb3 = iq.A04;
                    if (A0I[7].charAt(28) == 'l') {
                        throw new RuntimeException();
                    }
                    A0I[7] = "MOrewcskpOrth27AIRJiHCsaXTOPbZzW";
                    if (picOrderCntLsb3 == 1 && !iq.A07) {
                        if (!this.A0F.A09()) {
                            return;
                        }
                        i8 = this.A0F.A03();
                        if (ppsData.A02 && !z) {
                            if (!this.A0F.A09()) {
                                return;
                            }
                            i9 = this.A0F.A03();
                        }
                    }
                }
                this.A07.A04(iq, deltaPicOrderCnt1, A04, A05, A042, z, z2, z3, z4, i5, i6, i7, i8, i9);
                this.A08 = false;
                return;
            }
            throw new RuntimeException();
        }
    }

    public final boolean A07() {
        return this.A0H;
    }
}
