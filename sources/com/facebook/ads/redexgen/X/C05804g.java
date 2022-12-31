package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.4g  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C05804g {
    public static String[] A05 = {"IS69BmVCyt3r7rCL06vW", "i2lfi3JYyaWanuhNA9EoVixSZwQkBGPJ", "IP2snh2DbdtJP84nmUNUnat", "M7qM02aMAAjP0VsgCoHzcI67snq6Xoz6", "g2Y2aWNGMjfm3AzRUQfTQ", "z59QBS9AE5GFtdBn17xV89BNaNN5ntVX", "icRlwMXc031dCVyQa9g0z", "JdVLDxEugZkBcdzJI35N90WET0E7DRJI"};
    public int A00 = 0;
    public int A01;
    public int A02;
    public int A03;
    public int A04;

    private final int A00(int i2, int i3) {
        if (i2 > i3) {
            return 1;
        }
        if (i2 == i3) {
            return 2;
        }
        return 4;
    }

    public final void A01() {
        this.A00 = 0;
    }

    public final void A02(int i2) {
        this.A00 |= i2;
    }

    public final void A03(int i2, int i3, int i4, int i5) {
        this.A04 = i2;
        this.A03 = i3;
        this.A02 = i4;
        this.A01 = i5;
    }

    public final boolean A04() {
        int i2 = this.A00;
        if ((i2 & 7) == 0 || (i2 & (A00(this.A02, this.A04) << 0)) != 0) {
            int i3 = this.A00;
            int i4 = i3 & 112;
            String[] strArr = A05;
            if (strArr[5].charAt(13) != strArr[7].charAt(13)) {
                throw new RuntimeException();
            }
            A05[0] = "xw0gZhFc6GA1WyK2bJob";
            if (i4 == 0 || (i3 & (A00(this.A02, this.A03) << 4)) != 0) {
                int i5 = this.A00;
                if ((i5 & 1792) == 0 || (i5 & (A00(this.A01, this.A04) << 8)) != 0) {
                    int i6 = this.A00;
                    return (i6 & 28672) == 0 || (i6 & (A00(this.A01, this.A03) << 12)) != 0;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
