package com.facebook.ads.redexgen.X;

import android.os.SystemClock;
import android.util.Log;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Wh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1271Wh implements BP {
    public static byte[] A01;
    public final /* synthetic */ C1270Wg A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 22);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{44, 32, 114, 70, 87, 90, 92, 103, 65, 82, 80, 88, 67, 109, 100, 101, 120, 99, 100, 109, 42, 99, 103, 122, 101, 121, 121, 99, 104, 102, 115, 42, 102, 107, 120, 109, 111, 42, 107, Byte.MAX_VALUE, 110, 99, 101, 42, 102, 107, 126, 111, 100, 105, 115, 48, 42, 33, 2, 7, 0, 27, 29, 7, 1, 82, 19, 7, 22, 27, 29, 82, 6, 27, 31, 23, 1, 6, 19, 31, 2, 82, 90, 20, 0, 19, 31, 23, 82, 2, 29, 1, 27, 6, 27, 29, 28, 82, 31, 27, 1, 31, 19, 6, 17, 26, 91, 72, 82, 88, 123, 126, 121, 98, 100, 126, 120, 43, 106, 126, 111, 98, 100, 43, Byte.MAX_VALUE, 98, 102, 110, 120, Byte.MAX_VALUE, 106, 102, 123, 43, 35, 120, 114, 120, Byte.MAX_VALUE, 110, 102, 43, 104, 103, 100, 104, 96, 43, 102, 98, 120, 102, 106, Byte.MAX_VALUE, 104, 99, 34, 49, 43};
    }

    public C1271Wh(C1270Wg c1270Wg) {
        this.A00 = c1270Wg;
    }

    public /* synthetic */ C1271Wh(C1270Wg c1270Wg, BS bs) {
        this(c1270Wg);
    }

    @Override // com.facebook.ads.redexgen.X.BP
    public final void AAw(long j2) {
        Log.w(A00(2, 10, 37), A00(12, 41, 28) + j2);
    }

    @Override // com.facebook.ads.redexgen.X.BP
    public final void ABg(long j2, long j3, long j4, long j5) {
        long A03;
        long A04;
        StringBuilder sb = new StringBuilder();
        sb.append(A00(53, 52, 100));
        sb.append(j2);
        String A00 = A00(0, 2, 22);
        sb.append(A00);
        sb.append(j3);
        sb.append(A00);
        sb.append(j4);
        sb.append(A00);
        sb.append(j5);
        sb.append(A00);
        A03 = this.A00.A03();
        sb.append(A03);
        sb.append(A00);
        A04 = this.A00.A04();
        sb.append(A04);
        String sb2 = sb.toString();
        if (!C1270Wg.A0q) {
            Log.w(A00(2, 10, 37), sb2);
            return;
        }
        throw new BV(sb2, null);
    }

    @Override // com.facebook.ads.redexgen.X.BP
    public final void ACE(long j2, long j3, long j4, long j5) {
        long A03;
        long A04;
        StringBuilder sb = new StringBuilder();
        sb.append(A00(105, 50, 29));
        sb.append(j2);
        String A00 = A00(0, 2, 22);
        sb.append(A00);
        sb.append(j3);
        sb.append(A00);
        sb.append(j4);
        sb.append(A00);
        sb.append(j5);
        sb.append(A00);
        A03 = this.A00.A03();
        sb.append(A03);
        sb.append(A00);
        A04 = this.A00.A04();
        sb.append(A04);
        String sb2 = sb.toString();
        if (!C1270Wg.A0q) {
            Log.w(A00(2, 10, 37), sb2);
            return;
        }
        throw new BV(sb2, null);
    }

    @Override // com.facebook.ads.redexgen.X.BP
    public final void ACL(int i2, long j2) {
        BJ bj;
        long j3;
        BJ bj2;
        bj = this.A00.A0R;
        if (bj != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            j3 = this.A00.A0E;
            long j4 = elapsedRealtime - j3;
            bj2 = this.A00.A0R;
            bj2.ACM(i2, j2, j4);
        }
    }
}
