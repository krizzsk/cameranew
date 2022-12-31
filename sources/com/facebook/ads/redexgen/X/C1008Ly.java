package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.Ly  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1008Ly {
    public static byte[] A00;
    public static String[] A01 = {"XEo7ApDkixomJl", "UTo8fMhBtcAYVBkj97ZdrNE79DqyVdeE", "qjsfLXTzdQjFcrr1MQWDVCv1RezJVkpD", "uyyak5D0vLW0qS4el0H9V3NvWvs7WmEw", "dfkt", "aZ9WVO7oGzsQrfntNmAENBSB60kWMi8d", "vBzt6OuEytEA3fr2a70IMY3R4BM3PC0Z", "3Sjf17E3qVEfPkL5Ydo7ZoDPJxNqRPuV"};
    @VisibleForTesting
    public static final InterfaceC1007Lx A02 = null;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 25);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{-76, -67, -62, -11, 84, 81, 85, 86, 87, -83, -53, -40, -111, -34, -118, -48, -39, -36, -41, -53, -34, -118, -34, -45, -41, -49, -104};
    }

    static {
        A07();
    }

    public static long A00() {
        InterfaceC1007Lx interfaceC1007Lx = A02;
        if (interfaceC1007Lx != null) {
            return interfaceC1007Lx.A4e();
        }
        return System.currentTimeMillis();
    }

    public static long A01(long j2) {
        if (j2 == -1) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String[] strArr = A01;
        if (strArr[1].charAt(28) != strArr[2].charAt(28)) {
            throw new RuntimeException();
        }
        A01[3] = "urCZ1k15svGSg9r6LMSBF5zX9epx6b4x";
        return currentTimeMillis - j2;
    }

    public static String A02(double d2) {
        try {
            return String.format(Locale.US, A03(0, 4, 118), Double.valueOf(d2));
        } catch (Exception e2) {
            Log.e(C1008Ly.class.getSimpleName(), A03(9, 18, 81), e2);
            return A03(4, 5, 10);
        }
    }

    public static String A04(long j2) {
        return String.valueOf(A01(j2));
    }

    @Deprecated
    public static String A05(long j2) {
        return A02(j2 / 1000.0d);
    }

    public static String A06(long j2) {
        return Long.toString(j2);
    }
}
