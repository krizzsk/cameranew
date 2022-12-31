package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Qr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1128Qr {
    public static byte[] A05;
    public C1124Qn A00;
    public EnumC1127Qq A01;
    public String A02;
    public String A03;
    public byte[] A04;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 21);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{119};
    }

    public AbstractC1128Qr(String str, @Nullable C1130Qt c1130Qt, C1124Qn c1124Qn) {
        this.A03 = A00(0, 0, 77);
        if (str != null) {
            this.A03 = str;
        }
        if (c1130Qt != null && !c1130Qt.A06().isEmpty()) {
            this.A03 += A00(0, 1, 35) + c1130Qt.A06();
        }
        this.A00 = c1124Qn;
    }

    public final C1124Qn A02() {
        return this.A00;
    }

    public final EnumC1127Qq A03() {
        return this.A01;
    }

    public final String A04() {
        return this.A02;
    }

    public final String A05() {
        return this.A03;
    }

    public final byte[] A06() {
        return this.A04;
    }
}
