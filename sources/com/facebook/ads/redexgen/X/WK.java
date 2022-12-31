package com.facebook.ads.redexgen.X;

import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: assets/audience_network.dex */
public final class WK extends Cd {
    public static byte[] A03;
    public static String[] A04 = {"Es", "iHC9pRtfoWLcycijntiJYXN2", "TuGPNLSlit", "098OJ58R6u", "VNifGSmWt2UpuuC8pFHITdWilQmWPSdD", "nPBEvfeprzzMECJ3xuyevnTK", "FVZwpUplP67oS0xaMKq2ljUJ3jrVNcvU", "q6VKpvb2t6NLzvXLeBGroGgfRiC5SSnv"};
    public static final int[] A05;
    public int A00;
    public boolean A01;
    public boolean A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 15);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{77, 121, 104, 101, 99, 44, 106, 99, 126, 97, 109, 120, 44, 98, 99, 120, 44, Byte.MAX_VALUE, 121, 124, 124, 99, 126, 120, 105, 104, 54, 44, 99, 119, 102, 107, 109, 45, 101, 53, 51, 51, 47, 99, 110, 99, 117, 16, 4, 21, 24, 30, 94, 22, 70, 64, 64, 92, 28, 29, 16, 6, 49, 37, 52, 57, 63, Byte.MAX_VALUE, 61, 32, 100, 49, 125, 60, 49, 36, 61, 38, 50, 35, 46, 40, 104, 42, 55, 34, 32};
    }

    static {
        A01();
        A05 = new int[]{5512, 11025, 22050, 44100};
    }

    public WK(InterfaceC0771Cb interfaceC0771Cb) {
        super(interfaceC0771Cb);
    }

    @Override // com.facebook.ads.redexgen.X.Cd
    public final void A0B(IV iv, long j2) throws AS {
        if (this.A00 == 2) {
            int A042 = iv.A04();
            super.A00.AE4(iv, A042);
            super.A00.AE5(j2, 1, A042, 0, null);
            return;
        }
        int A0E = iv.A0E();
        if (A0E == 0) {
            boolean z = this.A01;
            String[] strArr = A04;
            if (strArr[7].charAt(9) != strArr[6].charAt(9)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[2] = "UGwyap6YoK";
            strArr2[3] = "84lnx1SX4s";
            if (!z) {
                byte[] bArr = new byte[iv.A04()];
                iv.A0c(bArr, 0, bArr.length);
                Pair<Integer, Integer> A032 = IA.A03(bArr);
                Format format = Format.A07(null, A00(58, 15, 95), null, -1, -1, ((Integer) A032.second).intValue(), ((Integer) A032.first).intValue(), Collections.singletonList(bArr), null, 0, null);
                super.A00.A5S(format);
                this.A01 = true;
                return;
            }
        }
        if (this.A00 == 10 && A0E != 1) {
            return;
        }
        int A043 = iv.A04();
        super.A00.AE4(iv, A043);
        super.A00.AE5(j2, 1, A043, 0, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0073, code lost:
        if (r7 == 8) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b3, code lost:
        if (r7 == 8) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b8, code lost:
        if (r7 != 10) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d9, code lost:
        throw new com.facebook.ads.redexgen.X.WG(A00(0, 28, 3) + r16.A00);
     */
    @Override // com.facebook.ads.redexgen.X.Cd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A0C(com.facebook.ads.redexgen.X.IV r17) throws com.facebook.ads.redexgen.X.WG {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.WK.A0C(com.facebook.ads.redexgen.X.IV):boolean");
    }
}
