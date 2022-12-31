package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class VL implements E5 {
    public static byte[] A00;
    public static String[] A01 = {"aIgF7yW6te9d0giIJjPlgLYuMarqNmaI", "5uowvZFp", "cObh83RuJ2BcUv3u494pfG0SonjgkZ34", "vjRgY08J1B3TNMsxRteKWvE9VDogNaKh", "qNUTjYBqOOgeDCHuUlR3yEqIWp1K4VGN", "N6vmBeMb9YQ5y6AoxxD7YUaD7FUFK", "OjnTWYSeBoS9dL1Ai6OGe6VjE6jgVlWS", "CC64HnyKjXihB9EkxjxtlcenpS0"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 83);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{109, 88, 88, 73, 65, 92, 88, 73, 72, 12, 88, 67, 12, 79, 94, 73, 77, 88, 73, 12, 72, 73, 79, 67, 72, 73, 94, 12, 74, 67, 94, 12, 89, 66, 95, 89, 92, 92, 67, 94, 88, 73, 72, 12, 74, 67, 94, 65, 77, 88, 88, 73, 73, 85, 80, 90, 88, 77, 80, 86, 87, 22, 80, 93, 10, 14, 31, 31, 3, 6, 12, 14, 27, 6, 0, 1, 64, 23, 66, 10, 2, 28, 8, 50, 35, 35, 63, 58, 48, 50, 39, 58, 60, 61, 124, 43, 126, 32, 48, 39, 54, 96, 102};
    }

    static {
        A01();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    @Override // com.facebook.ads.redexgen.X.E5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.ads.redexgen.X.E3 A4D(com.facebook.ads.internal.exoplayer2.Format r9) {
        /*
            r8 = this;
            java.lang.String r5 = r9.A0O
            int r7 = r5.hashCode()
            r0 = -1248341703(0xffffffffb597d139, float:-1.1311269E-6)
            r4 = 2
            r3 = 1
            if (r7 == r0) goto L65
            r0 = 1154383568(0x44ce7ed0, float:1651.9629)
            if (r7 == r0) goto L53
            r6 = 1652648887(0x62816bb7, float:1.1936958E21)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.VL.A01
            r0 = 7
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L92
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.VL.A01
            java.lang.String r1 = "bTmSe2zy8D5qz7yeGIeNoRuS8tTOpcQK"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "fPfUohV67zMJVCtM8CPLt22RAENT6cGu"
            r0 = 6
            r2[r0] = r1
            if (r7 == r6) goto L42
        L35:
            r0 = -1
        L36:
            if (r0 == 0) goto L8c
            if (r0 == r3) goto L86
            if (r0 != r4) goto L77
            com.facebook.ads.redexgen.X.VE r0 = new com.facebook.ads.redexgen.X.VE
            r0.<init>()
            return r0
        L42:
            r2 = 83
            r1 = 20
            r0 = 0
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L35
            r0 = 2
            goto L36
        L53:
            r2 = 65
            r1 = 18
            r0 = 60
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L35
            r0 = 1
            goto L36
        L65:
            r2 = 50
            r1 = 15
            r0 = 106(0x6a, float:1.49E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L35
            r0 = 0
            goto L36
        L77:
            r2 = 0
            r1 = 50
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r1 = A00(r2, r1, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L86:
            com.facebook.ads.redexgen.X.VJ r0 = new com.facebook.ads.redexgen.X.VJ
            r0.<init>()
            return r0
        L8c:
            com.facebook.ads.redexgen.X.VH r0 = new com.facebook.ads.redexgen.X.VH
            r0.<init>()
            return r0
        L92:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.VL.A4D(com.facebook.ads.internal.exoplayer2.Format):com.facebook.ads.redexgen.X.E3");
    }

    @Override // com.facebook.ads.redexgen.X.E5
    public final boolean AEw(Format format) {
        String str = format.A0O;
        return A00(50, 15, 106).equals(str) || A00(65, 18, 60).equals(str) || A00(83, 20, 0).equals(str);
    }
}
