package com.facebook.ads.redexgen.X;

import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: assets/audience_network.dex */
public final class GE implements RA {
    @VisibleForTesting
    public static boolean A04;
    public static byte[] A05;
    public static final R8 A06;
    public static final String A07;
    public long A00 = 0;
    @VisibleForTesting
    public final RC A01;
    public final R9 A02;
    public final RF A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{Byte.MAX_VALUE, -88, -85, -100, -94, -89, -96, 89, -89, -98, -79, -83, 89, -84, -78, -89, -100, 89, -102, -83, 89, -77, -57, -40, -47, -122, -57, -39, -122, -44, -43, -122, -39, -33, -44, -55, -50, -40, -43, -44, -49, -32, -57, -38, -49, -43, -44, -122, -39, -55, -50, -53, -54, -37, -46, -53, -54, -108, -122, -78, -57, -39, -38, -122, -39, -33, -44, -55, -122, -57, -38, -122, -117, -54, -108, -122, -76, -53, -34, -38, -122, -39, -33, -44, -55, -122, -57, -38, -122, -117, -54, -108, -51, -26, -33, -33, -22, -102, -32, -23, -20, -102, -97, -34, -102, -25, -29, -26, -26, -29, -19, -88, -14, -15, -43, -8, -15, -55, -20, -15, -20, -10, -21, -24, -25};
    }

    static {
        A02();
        A07 = GE.class.getSimpleName();
        A06 = new GF();
        A04 = false;
    }

    public GE(R9 r9, RF rf) {
        this.A02 = r9;
        this.A03 = rf;
        new Thread(new RB(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        while (true) {
            synchronized (this) {
                if (this.A00 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    long A4d = this.A03.A4d();
                    if (A4d < this.A00) {
                        int i2 = (int) ((this.A00 - A4d) / 1000000);
                        int millisToSleep = (i2 > 1L ? 1 : (i2 == 1L ? 0 : -1));
                        if (millisToSleep >= 0) {
                            String.format(Locale.US, A00(92, 20, 69), Integer.valueOf(i2));
                            try {
                                this.A03.AEi(this, i2);
                            } catch (InterruptedException unused2) {
                            }
                        }
                    }
                    this.A00 = 0L;
                    this.A02.AE2();
                    long A4d2 = this.A03.A4d();
                    if (this.A01 != null) {
                        break;
                    }
                    synchronized (this) {
                        int millisToSleep2 = (this.A00 > A4d2 ? 1 : (this.A00 == A4d2 ? 0 : -1));
                        if (millisToSleep2 < 0) {
                            String.format(Locale.US, A00(21, 71, 49), Long.valueOf(A4d2), Long.valueOf(this.A00));
                            this.A00 = 0L;
                        }
                    }
                }
            }
        }
        throw new NullPointerException(A00(112, 13, 78));
    }

    @Override // com.facebook.ads.redexgen.X.RA
    public final synchronized void A5P(int i2) {
        long A4d = this.A03.A4d() + (i2 * 1000000 * (A04 ? 1 : 1000));
        long requestedNextSync = this.A00;
        if (requestedNextSync == 0 || this.A00 > A4d) {
            this.A00 = A4d;
            notifyAll();
        }
    }

    @Override // com.facebook.ads.redexgen.X.RA
    public final synchronized void A5Q() {
        this.A00 = this.A03.A4d();
        String str = A00(0, 21, 4) + this.A00;
        notifyAll();
    }
}
