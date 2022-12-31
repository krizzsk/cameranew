package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ub  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1216Ub implements HR {
    public static byte[] A00;
    public static final HQ A01;
    public static final C1216Ub A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 72);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{10, 59, 51, 51, 63, -26, 57, 53, 59, 56, 41, 43};
    }

    static {
        A01();
        A02 = new C1216Ub();
        A01 = new C1217Uc();
    }

    public C1216Ub() {
    }

    public /* synthetic */ C1216Ub(C1217Uc c1217Uc) {
        this();
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final Uri A7d() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final long ACf(HV hv) throws IOException {
        throw new IOException(A00(0, 12, 126));
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final void close() throws IOException {
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        throw new UnsupportedOperationException();
    }
}
