package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Co  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0774Co {
    public static byte[] A03;
    public static final long[] A04;
    public int A00;
    public int A01;
    public final byte[] A02 = new byte[8];

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 42);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{0, 33, 110, 56, 47, 34, 39, 42, 110, 56, 47, 60, 39, 32, 58, 110, 34, 43, 32, 41, 58, 38, 110, 35, 47, 61, 37, 110, 40, 33, 59, 32, 42};
    }

    static {
        A03();
        A04 = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    }

    public static int A00(int varIntLength) {
        int i2 = 0;
        while (true) {
            long[] jArr = A04;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & varIntLength) != 0) {
                int i3 = i2 + 1;
                return i3;
            }
            i2++;
        }
    }

    public static long A01(byte[] bArr, int i2, boolean z) {
        long j2 = bArr[0] & 255;
        if (z) {
            j2 &= A04[i2 - 1] ^ (-1);
        }
        for (int i3 = 1; i3 < i2; i3++) {
            int i4 = bArr[i3];
            j2 = (j2 << 8) | (i4 & 255);
        }
        return j2;
    }

    public final int A04() {
        return this.A00;
    }

    public final long A05(CQ cq, boolean z, boolean z2, int i2) throws IOException, InterruptedException {
        if (this.A01 == 0) {
            if (!cq.ADI(this.A02, 0, 1, z)) {
                return -1L;
            }
            this.A00 = A00(this.A02[0] & Draft_75.END_OF_FRAME);
            if (this.A00 != -1) {
                this.A01 = 1;
            } else {
                throw new IllegalStateException(A02(0, 33, 100));
            }
        }
        int i3 = this.A00;
        if (i3 > i2) {
            this.A01 = 0;
            return -2L;
        }
        if (i3 != 1) {
            cq.readFully(this.A02, 1, i3 - 1);
        }
        this.A01 = 0;
        return A01(this.A02, this.A00, z2);
    }

    public final void A06() {
        this.A01 = 0;
        this.A00 = 0;
    }
}
