package com.facebook.ads.redexgen.X;

import android.net.TrafficStats;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Callable;
/* renamed from: com.facebook.ads.redexgen.X.7F  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C7F implements Callable<Boolean> {
    public static byte[] A02;
    public static String[] A03 = {"4L70rbdc", "PBHhMXx0npnpwTY", "91GJPzFmEyeOW3DYeKz29HPCrWXW0gNC", "umTRidE45okZulrVlJrHIV8", "kRbho3HgdeG0CdJ8rA209tRImftPXEnI", "60YY30c8MY", "ZuHjaYDngPTOcLYvMZdLe8TI8ruUn8GD", "lL0vcWHD5F"};
    public final C7I A00;
    public final /* synthetic */ C7J A01;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 32);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{114, 126, 109, 116, 106, 111, 43, 52, 57, 56, 50};
        if (A03[1].length() != 15) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[7] = "XFV0lH04tD";
        strArr[5] = "8rdCtS3Igw";
    }

    static {
        A02();
    }

    public C7F(C7J c7j, C7I c7i) {
        this.A01 = c7j;
        this.A00 = c7i;
    }

    private final Boolean A00() {
        String A01;
        C8J c8j;
        C8J c8j2;
        AnonymousClass00 A032;
        Map map;
        if (C0974Kn.A02(this)) {
            return null;
        }
        try {
            TrafficStats.setThreadStatsTag(61453);
            if (this.A00.A04) {
                A01 = A01(0, 6, 63);
            } else {
                A01 = A01(6, 5, 125);
            }
            AnonymousClass06 anonymousClass06 = new AnonymousClass06(this.A00.A08, this.A00.A07, this.A00.A06, A01, this.A00.A02, this.A00.A05);
            anonymousClass06.A04 = this.A00.A03;
            anonymousClass06.A02 = this.A00.A01;
            anonymousClass06.A05 = this.A00.A04;
            c8j = this.A01.A04;
            if (C7M.A06(c8j)) {
                map = C7J.A0F;
                map.put(this.A00.A08, anonymousClass06);
            }
            c8j2 = this.A01.A04;
            A032 = C7J.A03(c8j2.A00());
            return Boolean.valueOf(A032.ADo(anonymousClass06) != null);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            return null;
        }
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Boolean call() throws Exception {
        if (C0974Kn.A02(this)) {
            return null;
        }
        try {
            return A00();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            return null;
        }
    }
}
