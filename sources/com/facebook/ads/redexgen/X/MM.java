package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class MM {
    public static byte[] A00;
    public static final String A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 23);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{100, -105, -126, -124, -113, -109, -120, -114, -115, 63, -120, -115, 63, -110, -126, -111, -124, -124, -115, 63, -120, -115, -109, -124, -111, Byte.MIN_VALUE, -126, -109, -120, -107, -124, 63, -126, -121, -124, -126, -118, 75, 63, Byte.MIN_VALUE, -110, -110, -108, -116, -120, -115, -122, 63, -120, -115, -109, -124, -111, Byte.MIN_VALUE, -126, -109, -120, -107, -124, 77, -103, -104, -96, -114, -101, -46, -55, -45, -53, -39};
    }

    static {
        A01();
        A01 = MM.class.getSimpleName();
    }

    public static boolean A02(XT xt) {
        return A03(xt) && MN.A03(xt);
    }

    public static boolean A03(XT xt) {
        if (xt == null) {
            return true;
        }
        try {
            PowerManager powerManager = (PowerManager) xt.getSystemService(A00(60, 5, 18));
            if (Build.VERSION.SDK_INT >= 20) {
                return powerManager.isInteractive();
            }
            return powerManager.isScreenOn();
        } catch (Exception e2) {
            Log.e(A01, A00(0, 60, 8), e2);
            xt.A06().A8q(A00(65, 5, 73), C06808m.A2E, new C06818n(e2));
            return true;
        }
    }
}
