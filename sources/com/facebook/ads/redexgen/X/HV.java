package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class HV {
    public static byte[] A07;
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final Uri A04;
    @Nullable
    public final String A05;
    @Nullable
    public final byte[] A06;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 28);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{-110, -122, 122, -105, -86, -105, -119, -90, -101, -103, -111, -60};
    }

    public HV(Uri uri, long j2, long j3, long j4, @Nullable String str, int i2) {
        this(uri, null, j2, j3, j4, str, i2);
    }

    public HV(Uri uri, long j2, long j3, @Nullable String str) {
        this(uri, j2, j2, j3, str, 0);
    }

    public HV(Uri uri, long j2, long j3, @Nullable String str, int i2) {
        this(uri, j2, j2, j3, str, i2);
    }

    public HV(Uri uri, @Nullable byte[] bArr, long j2, long j3, long j4, @Nullable String str, int i2) {
        boolean z = true;
        I6.A03(j2 >= 0);
        I6.A03(j3 >= 0);
        if (j4 <= 0 && j4 != -1) {
            z = false;
        }
        I6.A03(z);
        this.A04 = uri;
        this.A06 = bArr;
        this.A01 = j2;
        this.A03 = j3;
        this.A02 = j4;
        this.A05 = str;
        this.A00 = i2;
    }

    public final boolean A02(int i2) {
        return (this.A00 & i2) == i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(A00(2, 9, 26));
        sb.append(this.A04);
        String A00 = A00(0, 2, 74);
        sb.append(A00);
        sb.append(Arrays.toString(this.A06));
        sb.append(A00);
        sb.append(this.A01);
        sb.append(A00);
        sb.append(this.A03);
        sb.append(A00);
        sb.append(this.A02);
        sb.append(A00);
        sb.append(this.A05);
        sb.append(A00);
        sb.append(this.A00);
        sb.append(A00(11, 1, 75));
        return sb.toString();
    }
}
