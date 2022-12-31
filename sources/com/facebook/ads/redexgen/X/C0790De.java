package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.De  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0790De {
    public static byte[] A02;
    public final List<Format> A00;
    public final InterfaceC0771Cb[] A01;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 7);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-91, -54, -46, -67, -56, -59, -64, 124, -65, -56, -53, -49, -63, -64, 124, -65, -67, -52, -48, -59, -53, -54, 124, -55, -59, -55, -63, 124, -48, -43, -52, -63, 124, -52, -50, -53, -46, -59, -64, -63, -64, -106, 124, -110, -95, -95, -99, -102, -108, -110, -91, -102, -96, -97, 96, -108, -106, -110, 94, 103, 97, 105, -33, -18, -18, -22, -25, -31, -33, -14, -25, -19, -20, -83, -31, -29, -33, -85, -75, -82, -74};
    }

    public C0790De(List<Format> list) {
        this.A00 = list;
        this.A01 = new InterfaceC0771Cb[list.size()];
    }

    public final void A02(long j2, IV iv) {
        GV.A03(j2, iv, this.A01);
    }

    public final void A03(CR cr, C0795Dj c0795Dj) {
        for (int i2 = 0; i2 < this.A01.length; i2++) {
            c0795Dj.A05();
            InterfaceC0771Cb AF1 = cr.AF1(c0795Dj.A03(), 3);
            Format format = this.A00.get(i2);
            String str = format.A0O;
            boolean z = A00(43, 19, 42).equals(str) || A00(62, 19, 119).equals(str);
            I6.A05(z, A00(0, 43, 85) + str);
            AF1.A5S(Format.A08(format.A0M != null ? format.A0M : c0795Dj.A04(), str, null, -1, format.A0D, format.A0N, format.A03, null));
            this.A01[i2] = AF1;
        }
    }
}
