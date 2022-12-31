package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.7I  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C7I {
    public static byte[] A09;
    public long A00;
    @Nullable
    public Integer A01;
    public String A02;
    public String A03;
    public boolean A04;
    public boolean A05;
    public final String A06;
    public final String A07;
    public final String A08;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A09 = new byte[]{88, 91, 85, 80};
    }

    public C7I(String str, String str2, String str3) {
        this.A03 = A00(0, 0, 9);
        this.A02 = A00(0, 4, 123);
        this.A00 = -1L;
        this.A08 = str;
        this.A07 = str2;
        this.A06 = str3;
        this.A01 = null;
    }

    public C7I(String str, String str2, String str3, long j2) {
        this.A03 = A00(0, 0, 9);
        this.A02 = A00(0, 4, 123);
        this.A00 = -1L;
        this.A08 = str;
        this.A07 = str2;
        this.A06 = str3;
        this.A01 = null;
        this.A00 = j2;
    }
}
