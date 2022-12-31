package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class D0 implements W9 {
    public static byte[] A05;
    public static String[] A06 = {"BIb1Y700RDmcL7JF9Fn", "lk1IRtv8jtyAOasrQbC6YrAcVcFJ9", "71nm4ncPUlnpG5PegzVfukIlQIS7yUOP", "GCiVubWGa77lALd1Rb0", "chLweuz0mMl4FbXf4CPkrAmx2V", "NRv5J71Oqm94bOZTTnySoFkmq1d86Acc", "fJm6FHaelFV0WMwBghon3E9Gns2th", "ObA7Byd4NJEP2M9ay6ZCFLfldVonyLqe"};
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long[] A04;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A06;
            if (strArr[0].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A06[5] = "xDmrh2CysME7FGpg0OVAAWQWrb1b5rm7";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 106);
            i5++;
        }
    }

    public static void A03() {
        String[] strArr = A06;
        if (strArr[6].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A06[5] = "O7i6ampyP1fRYbe4QOmd9JyFrRUTDP0J";
        A05 = new byte[]{87, 91, 99, 114, 117, 124, 27, 95, 90, 79, 90, 27, 72, 82, 65, 94, 27, 86, 82, 72, 86, 90, 79, 88, 83, 1, 27, 82, 99, 100, 109, 89, 111, 111, 97, 111, 120};
    }

    static {
        A03();
    }

    public D0(long j2, int i2, long j3) {
        this(j2, i2, j3, -1L, null);
    }

    public D0(long j2, int i2, long j3, long j4, long[] jArr) {
        this.A02 = j2;
        this.A00 = i2;
        this.A03 = j3;
        this.A01 = j4;
        this.A04 = jArr;
    }

    private long A00(int i2) {
        return (this.A03 * i2) / 100;
    }

    public static D0 A01(long j2, long j3, CV cv, IV iv) {
        int flags;
        int i2 = cv.A04;
        int i3 = cv.A03;
        int A08 = iv.A08();
        int samplesPerFrame = A08 & 1;
        if (samplesPerFrame != 1 || (flags = iv.A0H()) == 0) {
            return null;
        }
        long dataSize = C0923Il.A0F(flags, i2 * 1000000, i3);
        int samplesPerFrame2 = A08 & 6;
        if (samplesPerFrame2 != 6) {
            return new D0(j3, cv.A02, dataSize);
        }
        long A0H = iv.A0H();
        long[] jArr = new long[100];
        for (int i4 = 0; i4 < 100; i4++) {
            long durationUs = iv.A0E();
            jArr[i4] = durationUs;
        }
        if (j2 != -1 && j2 != j3 + A0H) {
            StringBuilder sb = new StringBuilder();
            sb.append(A02(2, 25, 81));
            sb.append(j2);
            sb.append(A02(0, 2, 17));
            long durationUs2 = j3 + A0H;
            sb.append(durationUs2);
            Log.w(A02(27, 10, 96), sb.toString());
        }
        return new D0(j3, cv.A02, dataSize, A0H, jArr);
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final long A6O() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final CX A7I(long j2) {
        long[] jArr;
        double scaledPosition;
        if (!A8Y()) {
            return new CX(new CZ(0L, this.A02 + this.A00));
        }
        long positionOffset = C0923Il.A0E(j2, 0L, this.A03);
        long timeUs = this.A03;
        double d2 = (positionOffset * 100.0d) / timeUs;
        if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            scaledPosition = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else if (d2 >= 100.0d) {
            scaledPosition = 256.0d;
        } else {
            int i2 = (int) d2;
            double d3 = this.A04[i2];
            if (A06[4].length() == 1) {
                throw new RuntimeException();
            }
            A06[4] = "";
            scaledPosition = d3 + (((i2 == 99 ? 256.0d : jArr[i2 + 1]) - d3) * (d2 - i2));
        }
        return new CX(new CZ(positionOffset, this.A02 + C0923Il.A0E(Math.round((scaledPosition / 256.0d) * this.A01), this.A00, this.A01 - 1)));
    }

    @Override // com.facebook.ads.redexgen.X.W9
    public final long A7X(long j2) {
        long j3;
        double d2;
        long positionOffset = j2 - this.A02;
        if (A8Y()) {
            long j4 = this.A00;
            if (A06[4].length() != 1) {
                A06[5] = "XBnVl7Vf2qRXlKywSNR3LOgq8shxQKKO";
                if (positionOffset > j4) {
                    double d3 = (positionOffset * 256.0d) / this.A01;
                    int A0B = C0923Il.A0B(this.A04, (long) d3, true, true);
                    long A00 = A00(A0B);
                    long j5 = this.A04[A0B];
                    long A002 = A00(A0B + 1);
                    if (j5 == (A0B == 99 ? 256L : this.A04[A0B + 1])) {
                        d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    } else {
                        d2 = (d3 - j5) / (j3 - j5);
                    }
                    long nextScaledPosition = Math.round((A002 - A00) * d2);
                    return nextScaledPosition + A00;
                }
                return 0L;
            }
            throw new RuntimeException();
        }
        return 0L;
    }

    @Override // com.facebook.ads.redexgen.X.CY
    public final boolean A8Y() {
        return this.A04 != null;
    }
}
