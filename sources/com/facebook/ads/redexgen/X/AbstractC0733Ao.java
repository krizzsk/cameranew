package com.facebook.ads.redexgen.X;

import android.util.Pair;
/* renamed from: com.facebook.ads.redexgen.X.Ao  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0733Ao {
    public static String[] A00 = {"jU13W9NSebta1ZmimveRwiImSwvynw8G", "bR9yhpeYgYLfxjGn405sIF1CLUaNKRNv", "y6GS60dgSiOKDJGhj3wt9T6pcdF3KRzS", "kAdv6lw0fV2hZ8Ef8nLl5eDcrpXJ", "gDoO0sRHxUPo6SrSL989dqr7yWBZykVP", "xoqdGlgoaRmw7wZuwViSR5WxyeJjGGpo", "tn8QhSSQsmhaZqBgPW05rXLjjsf9pF2E", "LT5aPkpwV7"};
    public static final AbstractC0733Ao A01 = new C1275Wl();

    public abstract int A00();

    public abstract int A01();

    public abstract int A04(Object obj);

    public abstract C0731Am A0A(int i2, C0731Am c0731Am, boolean z);

    public abstract C0732An A0D(int i2, C0732An c0732An, boolean z, long j2);

    public int A02(int i2, int i3, boolean z) {
        if (i3 == 0) {
            if (i2 == A06(z)) {
                return -1;
            }
            return i2 + 1;
        } else if (i3 != 1) {
            if (i3 == 2) {
                if (i2 == A06(z)) {
                    return A05(z);
                }
                return i2 + 1;
            }
            throw new IllegalStateException();
        } else {
            return i2;
        }
    }

    public final int A03(int nextWindowIndex, C0731Am c0731Am, C0732An c0732An, int i2, boolean z) {
        int i3 = A09(nextWindowIndex, c0731Am).A00;
        if (A0B(i3, c0732An).A01 == nextWindowIndex) {
            int A02 = A02(i3, i2, z);
            if (A02 == -1) {
                return -1;
            }
            return A0B(A02, c0732An).A00;
        }
        return nextWindowIndex + 1;
    }

    public int A05(boolean z) {
        return A0E() ? -1 : 0;
    }

    public int A06(boolean z) {
        if (A0E()) {
            return -1;
        }
        return A01() - 1;
    }

    public final Pair<Integer, Long> A07(C0732An c0732An, C0731Am c0731Am, int i2, long j2) {
        return A08(c0732An, c0731Am, i2, j2, 0L);
    }

    public final Pair<Integer, Long> A08(C0732An c0732An, C0731Am c0731Am, int i2, long j2, long j3) {
        I6.A00(i2, 0, A01());
        A0D(i2, c0732An, false, j3);
        if (j2 == -9223372036854775807L) {
            j2 = c0732An.A01();
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i3 = c0732An.A00;
        long A03 = c0732An.A03() + j2;
        long A07 = A09(i3, c0731Am).A07();
        while (A07 != -9223372036854775807L) {
            int i4 = (A03 > A07 ? 1 : (A03 == A07 ? 0 : -1));
            if (A00[7].length() == 24) {
                throw new RuntimeException();
            }
            A00[7] = "t4u2YUU8OEdoMFYJ2jQWzxX4wha";
            if (i4 < 0 || i3 >= c0732An.A01) {
                break;
            }
            A03 -= A07;
            i3++;
            A07 = A09(i3, c0731Am).A07();
        }
        return Pair.create(Integer.valueOf(i3), Long.valueOf(A03));
    }

    public final C0731Am A09(int i2, C0731Am c0731Am) {
        return A0A(i2, c0731Am, false);
    }

    public final C0732An A0B(int i2, C0732An c0732An) {
        return A0C(i2, c0732An, false);
    }

    public final C0732An A0C(int i2, C0732An c0732An, boolean z) {
        return A0D(i2, c0732An, z, 0L);
    }

    public final boolean A0E() {
        return A01() == 0;
    }

    public final boolean A0F(int i2, C0731Am c0731Am, C0732An c0732An, int i3, boolean z) {
        return A03(i2, c0731Am, c0732An, i3, z) == -1;
    }
}
