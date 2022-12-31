package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class AE implements Runnable {
    public static byte[] A02;
    public final /* synthetic */ DT A00;
    public final /* synthetic */ C0725Af A01;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 119);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-20, 31, 22, -9, 19, 8, 32, 12, 25, -16, 20, 23, 19, -16, 21, 27, 12, 25, 21, 8, 19, -30, -5, -14, 5, -3, -14, -16, 1, -14, -15, -83, -14, -1, -1, -4, -1, -83, -15, -14, -7, -10, 3, -14, -1, -10, -5, -12, -83, -6, -14, 0, 0, -18, -12, -14, -83, -4, -5, -83, -14, 5, 1, -14, -1, -5, -18, -7, -83, 1, -11, -1, -14, -18, -15, -69};
    }

    public AE(DT dt, C0725Af c0725Af) {
        this.A00 = dt;
        this.A01 = c0725Af;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            try {
                this.A00.A0X(this.A01);
            } catch (A9 e2) {
                Log.e(A00(0, 21, 48), A00(21, 55, 22), e2);
                throw new RuntimeException(e2);
            }
        } catch (Throwable e3) {
            C0974Kn.A00(e3, this);
        }
    }
}
