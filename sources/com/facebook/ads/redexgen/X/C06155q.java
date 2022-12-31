package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5q  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06155q {
    @Nullable
    public static InterfaceC06165r A00;
    public static boolean A01;
    public static byte[] A02;
    public static String[] A03 = {"dhICO", "mxKq80OLCiD", "i2W9TrIDW1srZxkJxV7foM0MgZvVXbWR", "HI2hESQONWq4EaTE0poPF0OJaSIxJaLc", "DAl184VBvvXhRHJ82dj3bqQv5TXH8TG3", "HKaWDYwPLWKyKiUqhpuc4RGInXEUU", "cSOfcLeIkAX6sPpwLxmVuA24IrFfyR3p", "KnRyMDjzSPNAoacBq98iQYDM8U9nlYJB"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 25);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-24, -21, -12, -23, -18, -13, -25, -8, -15};
    }

    static {
        A02();
        A01 = false;
        A00 = null;
    }

    public static void A01() {
        synchronized (C06155q.class) {
            if (A00 == null) {
                return;
            }
            C06818n c06818n = new C06818n(A00.ADi());
            c06818n.A03(1);
            XS sdkContext = C8I.A00();
            if (sdkContext != null) {
                sdkContext.A06().A8q(A00(0, 9, 109), 3401, c06818n);
            }
            InterfaceC06165r interfaceC06165r = A00;
            if (A03[1].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "kDYng9EYBsgXNgOEIL1h1gMPzmVJxAMa";
            strArr[6] = "TYxT1mxIdvKOfg1hbfM6O4XMHE5Nitia";
            interfaceC06165r.reset();
        }
    }

    public static void A03(final long j2) {
        if (j2 > 0) {
            A00 = new C1417an();
            new Thread(j2) { // from class: com.facebook.ads.redexgen.X.5s
                public final long A00;

                {
                    this.A00 = j2;
                    start();
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    if (C0974Kn.A02(this)) {
                        return;
                    }
                    while (true) {
                        try {
                            try {
                                Thread.sleep(this.A00);
                            } catch (Throwable th) {
                                C0974Kn.A00(th, this);
                                return;
                            }
                        } catch (InterruptedException unused) {
                        }
                        C06155q.A01();
                    }
                }
            };
        }
    }
}
