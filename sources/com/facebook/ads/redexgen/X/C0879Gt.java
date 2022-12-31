package com.facebook.ads.redexgen.X;

import android.text.Layout;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Gt  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0879Gt {
    public static byte[] A0G;
    public static String[] A0H = {"gPfaOYEITfuanLdVCW8PPCT70T", "M09L9hJVD3E", "SkJXoKJQHijlm7VqsoHZEZwEmj5TLLCc", "PzoJTbfigDFXx9xueDpeQaPajCaKnfmN", "zy8acRwSmU", "EJIQGv6cByhyLGLfI7fJN1oDm4V", "77NuOZxmpIn29Otv7yNmBxSNaW0583gz", "YbktzD3yqdg7"};
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public Layout.Alignment A08;
    public String A09;
    public String A0A;
    public String A0B;
    public String A0C;
    public List<String> A0D;
    public boolean A0E;
    public boolean A0F;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 47);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0G = new byte[]{-95, -64, -62, -54, -58, -47, -50, -44, -51, -61, Byte.MAX_VALUE, -62, -50, -53, -50, -47, Byte.MAX_VALUE, -51, -50, -45, Byte.MAX_VALUE, -61, -60, -59, -56, -51, -60, -61, -115, -37, 4, 3, 9, -75, -8, 4, 1, 4, 7, -75, 3, 4, 9, -75, -7, -6, -5, -2, 3, -6, -7};
    }

    static {
        A02();
    }

    public C0879Gt() {
        A03();
    }

    public static int A00(int i2, String str, String str2, int i3) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }

    private final void A03() {
        String A01 = A01(0, 0, 56);
        this.A0A = A01;
        this.A0B = A01;
        this.A0D = Collections.emptyList();
        this.A0C = A01;
        this.A09 = null;
        this.A0F = false;
        this.A0E = false;
        this.A06 = -1;
        this.A07 = -1;
        this.A02 = -1;
        this.A05 = -1;
        this.A04 = -1;
        this.A08 = null;
    }

    public final float A04() {
        return this.A00;
    }

    public final int A05() {
        if (this.A0E) {
            return this.A01;
        }
        throw new IllegalStateException(A01(0, 29, 48));
    }

    public final int A06() {
        if (this.A0F) {
            return this.A03;
        }
        throw new IllegalStateException(A01(29, 22, 102));
    }

    public final int A07() {
        return this.A04;
    }

    public final int A08() {
        if (this.A02 == -1 && this.A05 == -1) {
            return -1;
        }
        return (this.A02 == 1 ? 1 : 0) | (this.A05 == 1 ? 2 : 0);
    }

    public final int A09(String str, String str2, String[] strArr, String str3) {
        if (this.A0A.isEmpty() && this.A0B.isEmpty() && this.A0D.isEmpty() && this.A0C.isEmpty()) {
            return str2.isEmpty() ? 1 : 0;
        }
        String str4 = this.A0A;
        if (A0H[2].charAt(13) != 'W') {
            A0H[7] = "TLp9oTSw2za9";
            int A00 = A00(A00(A00(0, str4, str, 1073741824), this.A0B, str2, 2), this.A0C, str3, 4);
            if (A00 == -1 || !Arrays.asList(strArr).containsAll(this.A0D)) {
                return 0;
            }
            return A00 + (this.A0D.size() * 4);
        }
        throw new RuntimeException();
    }

    public final Layout.Alignment A0A() {
        return this.A08;
    }

    public final C0879Gt A0B(int i2) {
        this.A01 = i2;
        this.A0E = true;
        return this;
    }

    public final C0879Gt A0C(int i2) {
        this.A03 = i2;
        this.A0F = true;
        return this;
    }

    public final C0879Gt A0D(String str) {
        this.A09 = C0923Il.A0M(str);
        return this;
    }

    public final C0879Gt A0E(boolean z) {
        this.A02 = z ? 1 : 0;
        return this;
    }

    public final C0879Gt A0F(boolean z) {
        this.A05 = z ? 1 : 0;
        return this;
    }

    public final C0879Gt A0G(boolean z) {
        this.A07 = z ? 1 : 0;
        return this;
    }

    public final String A0H() {
        return this.A09;
    }

    public final void A0I(String str) {
        this.A0A = str;
    }

    public final void A0J(String str) {
        this.A0B = str;
    }

    public final void A0K(String str) {
        this.A0C = str;
    }

    public final void A0L(String[] strArr) {
        this.A0D = Arrays.asList(strArr);
    }

    public final boolean A0M() {
        return this.A0E;
    }

    public final boolean A0N() {
        return this.A0F;
    }

    public final boolean A0O() {
        return this.A06 == 1;
    }

    public final boolean A0P() {
        return this.A07 == 1;
    }
}
