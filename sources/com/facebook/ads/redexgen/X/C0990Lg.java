package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.Lg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0990Lg {
    public static byte[] A02;
    public long A00;
    public long A01;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 88);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{9, 46, 54, 33, 44, 41, 36, 96, 46, 53, 45, 34, 37, 50, 96, 47, 38, 96, 46, 33, 46, 47, 51, 37, 35, 47, 46, 36, 51, 96, 38, 47, 50, 96, 52, 40, 37, 96, 52, 41, 45, 37, 50, 122, 96, 101, 36};
    }

    public C0990Lg(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, A00(0, 47, 24), Long.valueOf(j2)));
        }
        this.A01 = j2;
        this.A00 = System.nanoTime() + j2;
    }

    public final synchronized void A02() {
        this.A00 = System.nanoTime();
        notifyAll();
    }

    public final synchronized void A03() {
        this.A00 = System.nanoTime() + this.A01;
    }

    public final synchronized void A04() throws InterruptedException {
        while (!A05()) {
            long max = Math.max(this.A00 - System.nanoTime(), 1L);
            wait(max / 1000000, (int) (max % 1000000));
        }
    }

    public final synchronized boolean A05() {
        return System.nanoTime() >= this.A00;
    }
}
