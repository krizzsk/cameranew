package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Of  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC1064Of implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C06918x A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 44);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-44, -25, -30, -29, -19, -50, -22, -33, -9, -32, -33, -31, -23, -61, -16, -16, -19, -16};
    }

    public RunnableC1064Of(C06918x c06918x) {
        this.A00 = c06918x;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0I(A00(0, 18, 82));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
