package com.facebook.ads.redexgen.X;

import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.Format;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: assets/audience_network.dex */
public final class Vg implements DV {
    public static byte[] A0D;
    public static String[] A0E = {"YsqY7Lk0NG7yMwVwuR3aCKQ1vCFnnoD7", "imTBT5eeu9SEESxnKVa9Th5", "O0aT", "zBRiiCG0AgE79WafkQACjpG1QDeKkcp1", "wwjqIDfPN4cSDtn9coCmQZMwbPpUFodD", "uPTa", "JD3sFkMXr2jLKKNxvTNpqQokakbynhd6", "fAZgloKcDeiXibtKpEsUxRbbQwdcutNH"};
    public static final double[] A0F;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public InterfaceC0771Cb A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final boolean[] A0C = new boolean[4];
    public final DW A0B = new DW(128);

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0E[1].length() != 23) {
                throw new RuntimeException();
            }
            A0E[4] = "Ri5OGo1CF8gLgqNPBzhcn52enWrdUOS9";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 59);
            i5++;
        }
    }

    public static void A02() {
        A0D = new byte[]{-2, -15, -20, -19, -9, -73, -11, -8, -19, -17, -70};
    }

    static {
        A02();
        A0F = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    }

    public static Pair<Format, Long> A00(DW dw, String str) {
        byte[] copyOf = Arrays.copyOf(dw.A02, dw.A00);
        int i2 = copyOf[4] & Draft_75.END_OF_FRAME;
        int i3 = copyOf[5] & Draft_75.END_OF_FRAME;
        int firstByte = copyOf[6] & Draft_75.END_OF_FRAME;
        int aspectRatioCode = (i2 << 4) | (i3 >> 4);
        int width = i3 & 15;
        int i4 = (width << 8) | firstByte;
        float f2 = 1.0f;
        int i5 = (copyOf[7] & 240) >> 4;
        if (i5 != 2) {
            String[] strArr = A0E;
            String str2 = strArr[2];
            String str3 = strArr[5];
            int firstByte2 = str2.length();
            if (firstByte2 == str3.length()) {
                String[] strArr2 = A0E;
                strArr2[3] = "HgbrGKSiwbnHfsjka25a0ZgViwBErbAQ";
                strArr2[6] = "kgfZHtVXJwuxNbqkZAemlWCJOmm9Ylqd";
                if (i5 != 3) {
                    if (i5 == 4) {
                        float pixelWidthHeightRatio = aspectRatioCode * 100;
                        f2 = (i4 * 121) / pixelWidthHeightRatio;
                    }
                } else {
                    float pixelWidthHeightRatio2 = aspectRatioCode * 9;
                    f2 = (i4 * 16) / pixelWidthHeightRatio2;
                }
            }
            throw new RuntimeException();
        }
        float pixelWidthHeightRatio3 = aspectRatioCode * 3;
        f2 = (i4 * 4) / pixelWidthHeightRatio3;
        Format A03 = Format.A03(str, A01(0, 11, 77), null, -1, -1, aspectRatioCode, i4, -1.0f, Collections.singletonList(copyOf), -1, f2, null);
        long j2 = 0;
        int i6 = (copyOf[7] & 15) - 1;
        if (i6 >= 0) {
            double[] dArr = A0F;
            int frameRateCodeMinusOne = dArr.length;
            if (i6 < frameRateCodeMinusOne) {
                double d2 = dArr[i6];
                int i7 = dw.A01;
                int sequenceExtensionPosition = i7 + 9;
                int i8 = (copyOf[sequenceExtensionPosition] & 96) >> 5;
                int i9 = i7 + 9;
                if (A0E[1].length() == 23) {
                    A0E[1] = "JkGh2MRG0HwgK9dbH7jOqv6";
                    int frameRateExtensionN = copyOf[i9];
                    int height = frameRateExtensionN & 31;
                    if (i8 != height) {
                        double frameRate = i8;
                        int firstByte3 = height + 1;
                        d2 *= (frameRate + 1.0d) / firstByte3;
                    }
                    j2 = (long) (1000000.0d / d2);
                }
                throw new RuntimeException();
            }
        }
        return Pair.create(A03, Long.valueOf(j2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d2, code lost:
        if (r3 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d6, code lost:
        if (r21.A07 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d8, code lost:
        r21.A05.AE5(r21.A03, r21.A09 ? 1 : 0, ((int) (r21.A04 - r21.A02)) - r4, r4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0122, code lost:
        if (r2 != (-9223372036854775807L)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0124, code lost:
        r21.A03 = r2;
        r21.A09 = false;
        r21.A01 = r4;
        r21.A0A = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0140, code lost:
        if (r2 != (-9223372036854775807L)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0145, code lost:
        if (r21.A0A == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0147, code lost:
        r2 = r21.A03 + r21.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014d, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0157, code lost:
        if (r3 != false) goto L40;
     */
    @Override // com.facebook.ads.redexgen.X.DV
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A46(com.facebook.ads.redexgen.X.IV r22) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Vg.A46(com.facebook.ads.redexgen.X.IV):void");
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A4T(CR cr, C0795Dj c0795Dj) {
        c0795Dj.A05();
        this.A06 = c0795Dj.A04();
        this.A05 = cr.AF1(c0795Dj.A03(), 2);
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACl() {
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACm(long j2, boolean z) {
        this.A01 = j2;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void AE8() {
        IR.A0B(this.A0C);
        this.A0B.A00();
        this.A04 = 0L;
        this.A0A = false;
    }
}
