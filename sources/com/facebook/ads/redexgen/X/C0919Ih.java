package com.facebook.ads.redexgen.X;

import androidx.core.location.LocationRequestCompat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* renamed from: com.facebook.ads.redexgen.X.Ih  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0919Ih {
    public static String[] A03 = {"65cMlekakVUIMLtYd2qVn8RcZ0adnk1M", "UjyIGuEYWfjJHNBaVK1tpUnDezxozlQO", "8TtcshNmMrpBHoTy3Jx7PSsI4WaoiE", "opOgbEamfowehMTo5e", "TsJIn0", "EhVZCkSBDk6mMyTg5zdzmerfhGbFv5ld", "Eri8EAzeqOX6dLYscfL5OJU1HmdTNDem", "nefT9Ttk6cyPRqOW12bbBLbtHnReAUgq"};
    public long A00;
    public long A01;
    public volatile long A02 = -9223372036854775807L;

    public C0919Ih(long j2) {
        A02(j2);
    }

    public static long A00(long j2) {
        return (1000000 * j2) / 90000;
    }

    public static long A01(long j2) {
        return (90000 * j2) / 1000000;
    }

    private final synchronized void A02(long j2) {
        int i2 = (this.A02 > (-9223372036854775807L) ? 1 : (this.A02 == (-9223372036854775807L) ? 0 : -1));
        if (A03[4].length() != 6) {
            throw new RuntimeException();
        }
        A03[4] = "LzgDaR";
        I6.A04(i2 == 0);
        this.A00 = j2;
    }

    public final long A03() {
        return this.A00;
    }

    public final long A04() {
        if (this.A02 != -9223372036854775807L) {
            long j2 = this.A02;
            String[] strArr = A03;
            if (strArr[1].charAt(3) != strArr[7].charAt(3)) {
                String[] strArr2 = A03;
                strArr2[1] = "a2e4BTQtBTIbtdID7RtsbeiIoOOOiE5j";
                strArr2[7] = "T6brmwdtMhRZgX81oiPgAK3x7yaW2pG8";
                return this.A01 + j2;
            }
            throw new RuntimeException();
        }
        long j3 = this.A00;
        String[] strArr3 = A03;
        if (strArr3[6].charAt(9) != strArr3[0].charAt(9)) {
            A03[4] = "vWaoyi";
            if (j3 != LocationRequestCompat.PASSIVE_INTERVAL) {
                return j3;
            }
            return -9223372036854775807L;
        }
        throw new RuntimeException();
    }

    public final long A05() {
        if (this.A00 == LocationRequestCompat.PASSIVE_INTERVAL) {
            return 0L;
        }
        long j2 = this.A02;
        if (A03[4].length() != 6) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[1] = "iob8LfiWSdIXeaYrhNgyOnbM2i0L2mJ3";
        strArr[7] = "rhCREaYiIoksCalrOiAV4Z6SpW6PjrFh";
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.A01;
    }

    public final long A06(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A02 != -9223372036854775807L) {
            this.A02 = j2;
        } else {
            long j3 = this.A00;
            if (j3 != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.A01 = j3 - j2;
            }
            synchronized (this) {
                this.A02 = j2;
                notifyAll();
            }
        }
        return this.A01 + j2;
    }

    public final long A07(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A02 != -9223372036854775807L) {
            long A01 = A01(this.A02);
            long closestWrapCount = (IjkMediaMeta.AV_CH_WIDE_RIGHT + A01) / IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            long j3 = ((closestWrapCount - 1) * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j2;
            long j4 = (IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT * closestWrapCount) + j2;
            long abs = Math.abs(j3 - A01);
            long ptsWrapBelow = Math.abs(j4 - A01);
            if (abs >= ptsWrapBelow) {
                j3 = j4;
            }
            j2 = j3;
        }
        return A06(A00(j2));
    }

    public final void A08() {
        this.A02 = -9223372036854775807L;
    }
}
